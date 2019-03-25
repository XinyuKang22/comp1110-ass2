package comp1110.ass2;

public class LegalPlacements extends SoloPlayer{

    final String[] grid = {"A0","A1","A2","A3","A4","A5","A6",
            "B0","B1","B2","B3","B4","B5","B6",
            "C0","C1","C2","C3","C4","C5","C6",
            "D0","D1","D2","D3","D4","D5","D6",
            "E0","E1","E2","E3","E4","E5","E6",
            "F0","F1","F2","F3","F4","F5","F6",
            "G0","G1","G2","G3","G4","G5","G6"};

    final String[] highwayExits = {"A1","A5","D0","D6","G1","G5"};
    final String[] railwayExits = {"A3","B0","B6","F0","F6","G3"};



    /**
     * Determine whether a tile placement string is well-formed:
     * - it consists of exactly 5 characters;
     * - the first character represents a die A or B, or a special tile S
     * - the second character indicates which tile or face of the die (0-6 for die A and special tiles, or 0-3 for die B)
     * - the third character represents the placement row A-G
     * - the fourth character represents the placement column 0-6
     * - the fifth character represents the orientation 0-7
     */
    public static boolean isTilePlacementWellFormed(String tilePlacementString){
        return false;
    }


    /*
    Determine whether a board string consists of exactly N five-character tile placements (where N = 1 .. 31)
     */
    public static boolean isBoardStringWellFormed(String boardString){
        return false;
    }



    /*
    Determine whether the tile be placed such that at least one edge connects to
    either an exit or a pre-existing route.
     */
    public static boolean isConnected (String boardString, String tilePlacementString){
        return false;
    }



    /*
    Determine whether the highway(railway) edge is connected to a highway(railway) edge/exit.
    Highways and railways may only join at station tiles.
     */
    public static boolean isValidlyConnected (String boardString, String tilePlacementString) { return false; }



    /*
     Determine whether the provided placements are neighbours connected by at least
     one validly connecting edge.
      */
    public static boolean areConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
        return false;
    }



}
