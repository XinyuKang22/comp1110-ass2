package comp1110.ass2;

public class Scoring extends SoloPlayer{

    final String[] centreGrid = {"C2","C3","C4","D2","D3","D4","E2","E3","E4"};
    final String[] highwayExits = {"A1","A5","D0","D6","G1","G5"};
    final String[] railwayExits = {"A3","B0","B6","F0","F6","G3"};



    public static int countConnectedExits (String boardString) { return -1; }

    public static int countErrors (String boardString) {
        return -1;
    }

    public static int countTilesInCentre (String boardString) {
        return -1;
    }

    public static int countLongestHighway (String boardString) {
        return -1;
    }

    public static int countLongestRailway (String boardString) { return -1; }

    public static int getBasicScore(int connectedExits, int errors, int tilesInCentre) {
        return -1;
    }

    public static int getAdvancedScore(int basicScore, int longestHighway, int longestRailway) { return -1; }

}
