package comp1110.ass2;

import comp1110.ass2.gui.Board;

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
     * @param tilePlacementString a candidate tile placement string
     * @return true if the tile placement is well formed
     */

    //isTIlePlacementWellFormed was just pattern matched to assignment 1. The function uses simple if statements and
    //as 'B' is different to 'A' and 'S,' another case was created even though apart from the 2nd character everything
    //else is the same.
    public static boolean isTilePlacementWellFormed(String tilePlacementString) {
        // FIXME Task 2: determine whether a tile placement is well-formed
        if (tilePlacementString.length() == 5){
            if ((tilePlacementString.charAt(0)) == 'A' || (tilePlacementString.charAt(0)) == 'S'){
                if ((tilePlacementString.charAt(1)) == '0' || (tilePlacementString.charAt(1)) == '1'
                        || (tilePlacementString.charAt(1)) == '2' || (tilePlacementString.charAt(1)) == '3'
                        || (tilePlacementString.charAt(1)) == '4' || (tilePlacementString.charAt(1)) == '5'){
                    if ((tilePlacementString.charAt(2)) == 'A' || (tilePlacementString.charAt(2)) == 'B'
                            || (tilePlacementString.charAt(2)) == 'C' || (tilePlacementString.charAt(2)) == 'D'
                            || (tilePlacementString.charAt(2)) == 'E' || (tilePlacementString.charAt(2)) == 'F'
                            || (tilePlacementString.charAt(2)) == 'G'){
                        if ((tilePlacementString.charAt(3)) == '0' || (tilePlacementString.charAt(3)) == '1'
                                || (tilePlacementString.charAt(3)) == '2' || (tilePlacementString.charAt(3)) == '3'
                                || (tilePlacementString.charAt(3)) == '4' || (tilePlacementString.charAt(3)) == '5'
                                || (tilePlacementString.charAt(3)) == '6'){
                            if ((tilePlacementString.charAt(4)) == '0' || (tilePlacementString.charAt(4)) == '1'
                                    || (tilePlacementString.charAt(4)) == '2' || (tilePlacementString.charAt(4)) == '3'
                                    || (tilePlacementString.charAt(4)) == '4' || (tilePlacementString.charAt(4)) == '5'
                                    || (tilePlacementString.charAt(4)) == '6' || (tilePlacementString.charAt(4)) == '7')
                            {return true;}
                        }
                    }
                }
            }
        }
        if (tilePlacementString.length() == 5){
            if ((tilePlacementString.charAt(0)) == 'B'){
                if ((tilePlacementString.charAt(1)) == '0' || (tilePlacementString.charAt(1)) == '1'
                        || (tilePlacementString.charAt(1)) == '2'){
                    if ((tilePlacementString.charAt(2)) == 'A' || (tilePlacementString.charAt(2)) == 'B'
                            || (tilePlacementString.charAt(2)) == 'C' || (tilePlacementString.charAt(2)) == 'D'
                            || (tilePlacementString.charAt(2)) == 'E' || (tilePlacementString.charAt(2)) == 'F'
                            || (tilePlacementString.charAt(2)) == 'G'){
                        if ((tilePlacementString.charAt(3)) == '0' || (tilePlacementString.charAt(3)) == '1'
                                || (tilePlacementString.charAt(3)) == '2' || (tilePlacementString.charAt(3)) == '3'
                                || (tilePlacementString.charAt(3)) == '4' || (tilePlacementString.charAt(3)) == '5'
                                || (tilePlacementString.charAt(3)) == '6'){
                            if ((tilePlacementString.charAt(4)) == '0' || (tilePlacementString.charAt(4)) == '1'
                                    || (tilePlacementString.charAt(4)) == '2' || (tilePlacementString.charAt(4)) == '3'
                                    || (tilePlacementString.charAt(4)) == '4' || (tilePlacementString.charAt(4)) == '5'
                                    || (tilePlacementString.charAt(4)) == '6' || (tilePlacementString.charAt(4)) == '7')
                            {return true;}
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Determine whether a board string is well-formed:
     * - it consists of exactly N five-character tile placements (where N = 1 .. 31);
     * - each piece placement is well-formed
     * - no more than three special tiles are included
     *
     * @param boardString a board string describing the placement of one or more pieces
     * @return true if the board string is well-formed
     */

    //isBoardStringWellFormed is far too difficult to brute force and hence uses loops to check each of the
    //characters. The function checks for null cases first, then invalid cases with strings over 155 characters
    //  long as well as incomplete cases using `mod` 5. A loop and array were used to scroll through the string in
    // conjunction with isTilePlacementWellFormed to check if every 5 characters is indeed a valid tile. Special tiles
    // are checked by looking for S and loops until there are 3 until it returns false.
    public static boolean isBoardStringWellFormed(String boardString) {
        // FIXME Task 3: determine whether a board string is well-formed
        if (boardString == null || boardString == "" || boardString.length() > 155 || boardString.length() %5 != 0){
            return false;
        }
        char[] a = boardString.toCharArray();
        int n = 0;
        int x = 0;
        while (n < boardString.length()){
            char[] c = {a[n], a[n+1], a[n+2], a[n+3], a[n+4]};
            String b = new String(c);
            if (isTilePlacementWellFormed(b) == false){return false;}
            if (boardString.charAt(n) == 'S'){
                x++;
            }
            n = n + 5;
        }
        if (x > 3){
            return false;
        }
        return true;
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
        // FIXME Task 7: generate a dice roll
        return "";
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
        // FIXME Task 8: compute the basic score
        return -1;
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
        // FIXME Task 10: generate a valid move
        return null;
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

