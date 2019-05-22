package comp1110.ass2;

import comp1110.ass2.gui.Board;
import java.util.Random;

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

            if(Board.isAtExit(tilesPlacementList[index])){
                if(!Board.isConnectedToExit(tilesPlacementList[index])){
                    return false;
                }
            }else {
                String[] previousPlacements = new String[index];
                System.arraycopy(tilesPlacementList, 0, previousPlacements, 0, index);
                if (!Board.hasConnectedNeighbors(tilesPlacementList[index], previousPlacements)) {
                    return false;
                }
            }
        }
        return true;

    }


    public static void main(String[] args) {
        String a = "A1A30";
        String b = "A1A2A3B0";
        System.out.println(generateMove(a,b));
    }

    /**
     * Generate a random dice roll as a string of eight characters.
     * Dice A should be rolled three times, dice B should be rolled once.
     * Die A has faces numbered 0-5.
     * Die B has faces numbered 0-2.
     * Each die roll is composed of a character 'A' or 'B' representing the dice,
     * followed by a digit character representing the face.
     *
     * @return a String representing the die roll e.g. A0A4A3B2
     */
    public static String generateDiceRoll() {
        int result, result1, result2, result3 = 0;
        Random r = new Random();
        result = r.nextInt(5);
        result1 = r.nextInt(5);
        result2 = r.nextInt(5);
        result3 = r.nextInt(2);
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
     *
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
     * @param boardString a board string representing the current state of the game as at the start of the round
     * @param diceRoll a String representing a dice roll for the round
     * @return a String representing an ordered sequence of valid piece placements for the current round
     * @see RailroadInk#generateDiceRoll()
     */
    public static String generateMove(String boardString, String diceRoll) {
        String place = "";
        String moves = "";
        String[] a = {"A", "B", "C", "D", "E", "F", "G" };
        String[] b = {"0", "1", "2", "3", "4", "5", "6" };
        String[] c = {"0", "1", "2", "3", "4", "5", "6", "7" };
        for (int x = 0; x<7; x++){
            for (int y = 0; y<7; y++){
                for (int z = 0; z<8; z++){ place += a[x] + b[y] + c[z]; }}}

        for (int i = 0; i < 8; i = i+2){
            for (int j = 0; j<place.length(); j += 3){
                String move = diceRoll.substring(i,i+2) + place.substring(j,j+3);
                if(isValidPlacementSequence(boardString + move)  && !Board.isOverlap(move ,boardString)){
                    boardString += boardString + move;
                    moves += move ;
                    break;}
            }}

        return moves;
    }

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

