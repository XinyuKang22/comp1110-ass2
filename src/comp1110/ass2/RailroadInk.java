package comp1110.ass2;

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
    public static boolean isTilePlacementWellFormed(String tilePlacementString) {
        // FIXME Task 2: determine whether a tile placement is well-formed
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
    public static boolean isBoardStringWellFormed(String boardString) {
        // FIXME Task 3: determine whether a board string is well-formed
        return false;
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
        char[] a = tilePlacementStringA.toCharArray();
        char[] b = tilePlacementStringB.toCharArray();
        int c = findPosition(tilePlacementStringA, tilePlacementStringB);
        int d = findPosition1(c);
        String[][] A = {{"RNNR", "RRNN", "NRRN", "NNRR", "RRNN", "NRRN", "NNRR", "RNNR"}, {"RNRN", "NRNR", "RNRN", "NRNR", "RNRN", "NRNR", "RNRN", "NRNR"},
                {"RRRN", "NRRR", "RNRR", "RRNR", "RNRR", "RRNR", "RRRN", "NRRR"}, {"HHHN", "NHHH", "HNHH", "HHNH", "HNHH", "HHNH", "HHHN", "NHHH"},
                {"HNHN", "NHNH", "HNHN", "NHNH", "HNHN", "NHNH", "HNHN", "NHNH"}, {"HNNH", "HHNN", "NHHN", "NNHH", "HHNN", "NHHN", "NNHH", "HNNH"}};

        String[][] B = {{"HNRN", "NHNR", "RNHN", "NRNH", "HNRN", "NHNR", "RNHN", "NRNH"},
                {"HRNN", "NHRN", "NNHR", "RNNH", "HNNR", "RHNN", "NRHN", "NNRH"},
                {"HRHR", "RHRH", "HRHR", "RHRH", "HRHR", "RHRH", "HRHR", "RHRH"}};

        String[][] S = {{"HHRH","HHHR","RHHH","HRHH","HHRH","HHHR","RHHH","HRHH"},{"HRRR","RHRR","RRHR","RRRH","HRRR","RHRR","RRHR","RRRH"},
                {"HHHH", "HHHH", "HHHH", "HHHH", "HHHH", "HHHH", "HHHH", "HHHH"}, {"RRRR","RRRR","RRRR","RRRR","RRRR","RRRR","RRRR","RRRR" },
                {"HRRH","HHRR","RHHR","RRHH","HHRR","RHHR","RRHH","HRRH"},{"HRHR", "RHRH", "HRHR", "RHRH", "HRHR", "RHRH", "HRHR", "RHRH"}};

        if (areNeighbours(tilePlacementStringA, tilePlacementStringB)) {
            if (a[0] == 'A' && b[0] == 'A') { if (A[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == 'N' || A[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) == 'N'){
                return false;} else return A[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == A[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) ; }

            else if (a[0] == 'A' && b[0] == 'B') { if (A[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == 'N' || B[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) == 'N'){
                return false;} else return A[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == B[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) ; }

            else if (a[0] == 'A' && b[0] == 'S') { if (A[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == 'N' || S[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) == 'N'){
                return false;} else return A[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == S[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) ; }

            else if (a[0] == 'B' && b[0] == 'B') { if (B[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == 'N' || B[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) == 'N'){
                return false;} else return B[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == B[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) ; }

            else if (a[0] == 'B' && b[0] == 'A') { if (B[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == 'N' || A[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) == 'N'){
                return false;} else return B[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == A[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) ; }

            else if (a[0] == 'B' && b[0] == 'S') { if (B[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == 'N' || S[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) == 'N'){
                return false;} else return B[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == S[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) ; }

            else if (a[0] == 'S' && b[0] == 'S') { if (S[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == 'N' || S[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) == 'N'){
                return false;} else return S[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == S[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) ; }

            else if (a[0] == 'S' && b[0] == 'A') { if (S[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == 'N' || A[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) == 'N'){
                return false;} else return S[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == A[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) ; }

            else if (a[0] == 'S' && b[0] == 'B') { if (S[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == 'N' || B[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) == 'N'){
                return false;} else return S[Character.getNumericValue(a[1])][Character.getNumericValue(a[4])].charAt(c) == B[Character.getNumericValue(b[1])][Character.getNumericValue(b[4])].charAt(d) ; }
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
        // FIXME Task 6: determine whether the given placement sequence is valid
        return false;
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

    /*
    Generic function to find the index of an element in a char array in Java
     */
    public static int find(char[] a, char target)
    {
        for (int i = 0; i < a.length; i++)
            if (target == (a[i]))
                return i;
        return -1;
    }

    /*
    find the index of the direction where two tiles connected in the first tile
    */
    public static int findPosition(String a, String b){
        char[] i = {'A','B','C','D','E','F','G'};
        if(a.charAt(2) == b.charAt(2)){ // two tiles are vertical
            if (Integer.valueOf(a.charAt(3)) < Integer.valueOf(b.charAt(3))){return 1; } // compared between indexes of one row
            else return 3;}

        else // two tiles are parallel
            if(find(i,a.charAt(2)) < find(i,b.charAt(2))){return 2;} // compared between indexes of one column
            else return 0;
    }

    /*
    return the index of the direction in the second tile
    */
    public static int findPosition1(int a) {
        if (a == 2) { // the two indexes are symmetric
            return 0;
        } else if (a == 3) {
            return 1;
        } else return a + 2;
    }


    /*
    determine whether the two tiles are neighnours
     */
    public static boolean areNeighbours (String tilePlacementStringA, String tilePlacementStringB){
        char[] a = tilePlacementStringA.toCharArray();
        char[] b = tilePlacementStringB.toCharArray();
        char[] i = {'A','B','C','D','E','F','G'}; //an array of every row
        char[] n = {'0','1','2','3','4','5','6'}; //an array of every column
        if(a[2]==b[2] && (a[3]!= '0')&& (a[3]!= '6')) { // two tiles are vertical
            return !((b[3] != n[(find(n, a[3]) + 1)]) && (b[3] != n[(find(n, a[3]) - 1)])); } // determine whether they are neighbours in one column

        else if(a[2]==b[2] && (a[3]== '0')) {
            return !(b[3] != n[(find(n, a[3]) + 1)]); }

        else if(a[2]==b[2] && (a[3]== '6')) {
            return !(b[3] != n[(find(n, a[3]) - 1)]); }

        else if(a[3]==b[3]&& (a[2]!= 'A')&& (a[2]!= 'G')){ //two tiles are parallel
            return !((b[2]!=i[(find(i,a[2])+1)]) && (b[2]!=i[(find(i,a[2])-1)]));} // determine whether they are neighbours in one row

        else if (a[3]==b[3] && (a[2]== 'A')) {
            return !(b[2] != i[(find(i, a[2]) + 1)]); }

        else if (a[3]==b[3] && (a[2]== 'G')) {
            return !(b[2] != i[(find(i, a[2]) - 1)]);}

        else if ((a[2]!=b[2])&&(a[3]!=b[3])){return false;} // they are neither one row nor one column
        else return true;
    }

}


