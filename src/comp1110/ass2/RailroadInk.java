package comp1110.ass2;

import comp1110.ass2.gui.Board;

import java.util.*;

public class RailroadInk {

    /**
     * Determine whether a tile placement string is well-formed:
     * - it consists of exactly 5 characters;
     * - the first character represents a die A or B, or a special tile S
     * - the second character indicates which tile or face of the die (0-5 for die A and special tiles, or 0-2 for die B)
     * - the third character represents the placement row A-G
     * - the fourth character represents the placement column 0-6
     * - the fifth character represents the orientation 0-7
     *
     * @author Elton Li
     * @param tilePlacementString a candidate tile placement string
     * @return true if the tile placement is well formed
     */
    public static boolean isTilePlacementWellFormed(String tilePlacementString) {
        if(tilePlacementString.length()!=5){
            return false;
        }else {
            try {
                char first = tilePlacementString.charAt(0);
                int second = Integer.parseInt(tilePlacementString.substring(1,2));
                String third = tilePlacementString.substring(2,3);
                int fourth = Integer.parseInt(tilePlacementString.substring(3,4));
                int fifth = Integer.parseInt(tilePlacementString.substring(4));

                if(first=='A' || first=='S'){
                    if(second<0 || second>5){
                        return false;
                    }
                }else if(first=='B'){
                    if(second<0 || second>2){
                        return false;
                    }
                }else {
                    return false;
                }

                if(third.hashCode()<65 || third.hashCode()>71){
                    return false;
                }

                if(fourth<0 || fourth>6){
                    return false;
                }

                if(fifth<0 || fifth>7){
                    return false;
                }
            }catch (java.lang.NumberFormatException e){
                return false;
            }
        }
        return true;
    }


    /**
     * Determine whether a board string is well-formed:
     * - it consists of exactly N five-character tile placements (where N = 1 .. 31);
     * - each piece placement is well-formed
     * - no more than three special tiles are included
     *
     * @author Elton Li
     * @param boardString a board string describing the placement of one or more pieces
     * @return true if the board string is well-formed
     */
    public static boolean isBoardStringWellFormed(String boardString) {
       if(boardString==null || boardString==""|| boardString.length()>155 || boardString.length()%5!=0){
           return false;
       }else {
           int countSpecialTile = 0;
           for(int i =0; i<boardString.length();i=i+5){
               String tilePlacementString = boardString.substring(i,i+5);
               if(!isTilePlacementWellFormed(tilePlacementString)){
                   return false;
               }
               if(tilePlacementString.charAt(0)=='S'){
                   countSpecialTile++;
               }
           }
           return countSpecialTile<=3;
       }
    }


    /**
     * Determine whether the provided placements are neighbours connected by at least one validly connecting edge.
     * For example,
     * - areConnectedNeighbours("A3C10", "A3C23") would return true as these tiles are connected by a highway edge;
     * - areConnectedNeighbours("A3C23", "B1B20") would return false as these neighbouring tiles are disconnected;
     * - areConnectedNeighbours("A0B30", "A3B23") would return false as these neighbouring tiles have an
     * invalid connection between highway and railway; and
     * areConnectedNeighbours("A0B30", "A3C23") would return false as these tiles are not neighbours.
     *
     * @author Yinuo Zhang
     * @return true if the placements are connected neighbours
     */
    public static boolean areConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {

        if(!Board.areNeighbors(tilePlacementStringA,tilePlacementStringB)){
            return false;
        }

        String[] infoA = Board.rotatedTileInfo(tilePlacementStringA);
        String[] infoB = Board.rotatedTileInfo(tilePlacementStringB);

        int B_relativeTo_A = Board.relativePosition(tilePlacementStringA,tilePlacementStringB);

        if(B_relativeTo_A==0){
            return infoB[2].equals(infoA[0]) && !infoA[0].equals("Nothing");

        }else if (B_relativeTo_A==1){
            return infoB[3].equals(infoA[1]) && !infoA[1].equals("Nothing");

        }else if (B_relativeTo_A==2){
            return infoB[0].equals(infoA[2]) && !infoA[2].equals("Nothing");

        }else if (B_relativeTo_A==3){
            return infoB[1].equals(infoA[3]) && !infoA[3].equals("Nothing");

        }
        return false;
    }


    /**
     * Given a well-formed board string representing an ordered list of placements,
     * determine whether the board string is valid.
     * A board string is valid if each tile placement is legal with respect to all previous tile
     * placements in the string, according to the rules for legal placements:
     * - A tile must be placed such that at least one edge connects to either an exit or a pre-existing route.
     *   Such a connection is called a valid connection.
     * - Tiles may not be placed such that a highway edge connects to a railway edge;
     *   this is referred to as an invalid connection.
     *   Highways and railways may only join at station tiles.
     * - A tile may have one or more edges touching a blank edge of another tile;
     *   this is referred to as disconnected, but the placement is still legal.
     *
     * @author Xinyu Kang
     * @param boardString a board string representing some placement sequence
     * @return true if placement sequence is valid
     */
    public static boolean isValidPlacementSequence(String boardString) {

        if(boardString.isEmpty()){
            return false;
        }

        int listLength = boardString.length()/5;
        String[] tilesPlacementList = new String[listLength];

        int count = 0;  //count the number of tile placement string that already included
        for (int i=0; i<boardString.length(); i=i+5){
            tilesPlacementList[count] = boardString.substring(i,i+5);
            count++;
        }

        if(!Board.isConnectedToExit(tilesPlacementList[0])){ //check whether 1st tile connected to exit
            return false;
        }

        for(int index = 1; index<tilesPlacementList.length; index++) {
            String[] previousPlacements = new String[index];
            System.arraycopy(tilesPlacementList, 0, previousPlacements, 0, index);

            if(Board.isOverlap(tilesPlacementList[index],boardString.substring(0,index*5))){
                return false;
            }else{
                if(Board.isAtExit(tilesPlacementList[index])){
                    if(!Board.hasConnectedNeighbors(tilesPlacementList[index],previousPlacements)){
                        if(!Board.isConnectedToExit(tilesPlacementList[index])){
                            return false;
                        }
                    }else {
                        if(!Board.isConnectedToExit(tilesPlacementList[index])){
                            int col = Integer.parseInt(tilesPlacementList[index].substring(3,4));
                            char row = tilesPlacementList[index].charAt(2);
                            String[] a = Board.rotatedTileInfo(tilesPlacementList[index]);
                            String theEdge = "";
                            if(col==0){
                                theEdge=a[3];
                            }else if(col==6){
                                theEdge=a[1];
                            }
                            if(row=='A'){
                                theEdge=a[0];
                            }else if(row=='G'){
                                theEdge=a[1];
                            }
                            if(theEdge!="Nothing"){
                                return false;
                            }
                        }
                    }
                }else {
                    if(!Board.hasConnectedNeighbors(tilesPlacementList[index],previousPlacements)){
                        return false;
                    }
                }
            }

            HashMap<String,Integer> allNeighbors = new HashMap<>();
            for(String s:tilesPlacementList){
                if(s.equals(tilesPlacementList[index])){
                    break;
                }else {
                    if(Board.areNeighbors(tilesPlacementList[index],s)){
                        allNeighbors.put(s,Board.relativePosition(tilesPlacementList[index],s));
                    }
                }
            }
            String[] a = Board.rotatedTileInfo(tilesPlacementList[index]);
            for(String placement:allNeighbors.keySet()){
                String[] b = Board.rotatedTileInfo(placement);
                switch (allNeighbors.get(placement)){
                    case 0:
                        if(a[0].equals("Highway") && b[2].equals("Railway")){
                            return false;
                        }else if( a[0].equals("Railway") && b[2].equals("Highway")){
                            return false;
                        }
                        break;
                    case 1:
                        if(a[1].equals("Highway") && b[3].equals("Railway")){
                            return false;
                        }else if( a[1].equals("Railway") && b[3].equals("Highway")){
                            return false;
                        }
                        break;
                    case 2:
                        if(a[2].equals("Highway") && b[0].equals("Railway")){
                            return false;
                        }else if( a[2].equals("Railway") && b[0].equals("Highway")){
                            return false;
                        }
                        break;
                    case 3:
                        if(a[3].equals("Highway") && b[1].equals("Railway")){
                            return false;
                        }else if( a[3].equals("Railway") && b[1].equals("Highway")){
                            return false;
                        }
                        break;
                }
            }

        }
        return true;

    }


    /**
     * Generate a random dice roll as a string of eight characters.
     * Dice A should be rolled three times, dice B should be rolled once.
     * Die A has faces numbered 0-5.
     * Die B has faces numbered 0-2.
     * Each die roll is composed of a character 'A' or 'B' representing the dice,
     * followed by a digit character representing the face.
     * @author Yinuo Zhang
     * @return a String representing the die roll e.g. A0A4A3B2
     */
    public static String generateDiceRoll() {
        Random r = new Random();
        int result = r.nextInt(6);
        int result1 = r.nextInt(6);
        int result2 = r.nextInt(6);
        int result3 = r.nextInt(3);
        String dice = "A" + Integer.toString(result) + "A" +  Integer.toString(result1) + "A" +  Integer.toString(result2) +"B" + Integer.toString(result3);
        return dice;
    }

    /**
     * Given the current state of a game board, output an integer representing the sum of all the following factors
     * that contribute to the player's final score.
     * <p>
     * * Number of exits mapped
     * * Number of centre tiles used
     * * Number of dead ends in the network
     * @author Yinuo Zhang
     * @param boardString a board string representing a completed game
     * @return integer (positive or negative) for score *not* considering longest rail/highway
     */
    public static int getBasicScore(String boardString) {
        int score = Scoring.countConnectedExits(boardString) + Scoring.countTilesInCentre(boardString) + Scoring.countErrors(boardString);
        return score;
    }

    /**
     * Given a valid boardString and a dice roll for the round,
     * return a String representing an ordered sequence of valid piece placements for the round.
     * @author Xinyu Kang
     * @param boardString a board string representing the current state of the game as at the start of the round
     * @param diceRoll a String representing a dice roll for the round
     * @return a String representing an ordered sequence of valid piece placements for the current round
     * @see RailroadInk#generateDiceRoll()
     */
    public static String generateMove(String boardString, String diceRoll) {
        String tile1 = diceRoll.substring(0,2);
        String tile2 = diceRoll.substring(2,4);
        String tile3 = diceRoll.substring(4,6);
        String tile4 = diceRoll.substring(6,8);
        ArrayList<String[]> list = new ArrayList<>();
        String[] a1 = {tile1,tile2,tile3,tile4};
        String[] a2 = {tile1,tile2,tile4,tile3};
        String[] a3 = {tile1,tile3,tile2,tile4};
        String[] a4 = {tile1,tile3,tile4,tile2};
        String[] a5 = {tile1,tile4,tile2,tile3};
        String[] a6 = {tile1,tile4,tile3,tile2};
        String[] b1 = {tile2,tile1,tile3,tile4};
        String[] b2 = {tile2,tile1,tile4,tile3};
        String[] b3 = {tile2,tile3,tile1,tile4};
        String[] b4 = {tile2,tile3,tile4,tile1};
        String[] b5 = {tile2,tile4,tile1,tile3};
        String[] b6 = {tile2,tile4,tile3,tile1};
        String[] c1 = {tile3,tile1,tile2,tile4};
        String[] c2 = {tile3,tile1,tile4,tile2};
        String[] c3 = {tile3,tile2,tile1,tile4};
        String[] c4 = {tile3,tile2,tile4,tile1};
        String[] c5 = {tile3,tile4,tile1,tile2};
        String[] c6 = {tile3,tile4,tile2,tile1};
        String[] d1 = {tile4,tile1,tile2,tile3};
        String[] d2 = {tile4,tile1,tile3,tile2};
        String[] d3 = {tile4,tile2,tile1,tile3};
        String[] d4 = {tile4,tile2,tile3,tile1};
        String[] d5 = {tile4,tile3,tile1,tile2};
        String[] d6 = {tile4,tile3,tile2,tile1};
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        list.add(b6);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);
        list.add(d6);

        ArrayList<String> results = new ArrayList<>();
        int maxLen = boardString.length();
        String bestOne = "";
        for(String[] s: list){
            String k = onePossibility(boardString,s);
            results.add(k);
            if((k.length()-boardString.length())==20){
                return k.substring(boardString.length());
            }
            if(k.length()>maxLen){
                maxLen=k.length();
                bestOne=k;
            }

        }
        return bestOne.substring(boardString.length());

        /*
        // task 10 version 1 part one, @author Yinuo Zhang
        String moves1 = generateMoves(boardString,diceRoll);
        String moves2 = generateMoves(boardString,diceRoll.substring(6) + diceRoll.substring(0,6));
        String moves3 = generateMoves(boardString,diceRoll.substring(4) + diceRoll.substring(0,4));
        String moves4 = generateMoves(boardString,diceRoll.substring(2) + diceRoll.substring(0,2));
        if (moves1.length() == 20){return moves1;} else if (moves2.length() == 20){return moves2;} else if (moves3.length() == 20){return moves3;} else if (moves4.length() == 20){return moves4;}
        else if (moves2.length() > moves1.length() && moves2.length() >= moves3.length() && moves2.length() >= moves4.length()){return moves2;}
        else if (moves3.length() > moves1.length() && moves3.length() >= moves2.length() && moves3.length() >= moves4.length()){return moves3;}
        else if (moves4.length() > moves1.length() && moves4.length() >= moves2.length()){return moves4;}
        return moves1;
         */
    }

    /**
     * @author Xinyu Kang
     * @param boardString
     * @param dices a list of dice rolling results i.e. {"A0","A0","A2","B1"}
     * @return new boardString
     */
    public static String onePossibility(String boardString, String[] dices){
        String moves1 = oneMove(boardString,dices[0]);
        if(moves1.length()==boardString.length()){
            return boardString;
        }
        String moves2 = oneMove(moves1,dices[1]);
        if(moves2.length()==moves1.length()){
            return moves1;
        }
        String moves3 = oneMove(moves2,dices[2]);
        if (moves3.length()==moves2.length()){
            return moves2;
        }
        String moves4 = oneMove(moves3,dices[3]);
        return moves4;
    }

    /**
     * @author Xinyu Kang
     * @param boardString
     * @param tileName
     * @return a new boardString
     */
    public static String oneMove(String boardString, String tileName){
        String[] a = {"A","B","C","D","E","F","G"};
        String[] b = {"1","2","3","4","5","6","7"};
        String[] c = {"0","1","2","3","4","5","6","7"};
        String toReturn="";
        for(String row:a){
            if(toReturn.length()>=5){
                break;
            }
            for(String col:b){
                if(toReturn.length()>=5){
                    break;
                }
                for(String ori:c){
                    String place = tileName+row+col+ori;
                    if(isBoardStringWellFormed(boardString+place) && isValidPlacementSequence(boardString+place)){
                        //list.add(place);
                        toReturn=place;
                        break;
                    }
                }
            }
        }

        String[] d = {"0","1","2","3","4","5"};
        if(toReturn.isEmpty()){
            for(String special:d){
                if(toReturn.length()>=5){
                    break;
                }
                for(String col:a){
                    if(toReturn.length()>=5){
                        break;
                    }
                    for(String row:b){
                        if(toReturn.length()>=5){
                            break;
                        }
                        for(String ori:c){
                            String place = "S"+special+row+col+ori;
                            if(isBoardStringWellFormed(boardString+place) && isValidPlacementSequence(boardString+place)){
                                toReturn=place;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return boardString+toReturn;
    }

/*

    //task 10 version 1  part two , @author Yinuo Zhang
    public static String generateMoves(String boardString, String diceRoll) {
        String moves = "";
        for (int i = 0; i <diceRoll.length(); i += 2){
            String move = generateAMove(boardString,diceRoll.substring(i,i+2));
            if(move != ""){
                moves += move;
                boardString += move; }}
        System.out.println(moves);
        return moves;
    }

    private static String generateAMove (String boardString, String diceRoll){
        String place = "";
        String[] a = {"A", "B", "C", "D", "E", "F", "G" };
        String[] b = {"0", "1", "2", "3", "4", "5", "6" };
        String[] c = {"0", "1", "2", "3", "4", "5", "6", "7" };
        for (int x = 0; x<7; x++){
            for (int y = 0; y<7; y++){
                for (int z = 0; z<8; z++){ place += a[x] + b[y] + c[z]; }}}

        for (int j = 0; j<place.length(); j += 3){
            String move = diceRoll+ place.substring(j,j+3);
            if(isValidPlacementSequence((boardString + move))){
                return move;}}

        return "";
    }
 */



    /**
     * Given the current state of a game board, output an integer representing the sum of all the factors contributing
     * to `getBasicScore`, as well as those attributed to:
     * <p>
     * * Longest railroad
     * * Longest highway
     *
     * @param boardString a board string representing a completed game
     * @return integer (positive or negative) for final score (not counting expansion packs)
     */
    public static int getAdvancedScore(String boardString) {
        // FIXME Task 12: compute the total score including bonus points
        return -1;
    }

}

