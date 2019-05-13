package comp1110.ass2;


//Written by Xinyu Kang
public class SoloPlayer extends MultiplePlayers{

    String boardString = "";
    String[] specialTiles = {"S0","S1","S2","S3","S4","S5"};
    int round = 1;



    /*
    Generate a random dice roll as an ordered string list representing four tiles.
    e.g. {"A0","A3","A3","B1"}
     */
    public static String[] generateDiceRoll( ){ return null; }



    /*
    popNextTile: Return the tile to be placed next, and delete the tile from the list.
    undoPopNextTile: Undo popNextTile.
     */
    public static String popNextTile (String[] diceRoll){
        return null;
    }
    public static void undoPopNextTile (String[] diceRoll, String nextTile){ }



    /*
    Determine whether the number of used special tiles reached the maximum.
    Return true if did not reach the maximum.
     */
    public static boolean whetherCanUseSpecialTile (String[] specialTiles){
        return false;
    }



    /*
    popSpecialTile: Delete the selected special tile from the special tiles list.
    undoPopSpecialTile: Undo popSpecialTile.
     */
    public static void popSpecialTile (String[] specialTiles, String selectedSpecialTile){ }
    public static void undoPopSpecialTile (String[] specialTiles, String selectedSpecialTile){ }



    /*
    e.g. a tile on die A face 2, placing at grid B5 in orientation 3,
         return "A2B53" as its tile placement string.
     */
    public static String toTilePlacementString(String tile, String location, int orientation){
        return null;
    }



    /*
    generatePlacement: Add the tile's placement string to the board string.
    undoGeneratePlacement: Undo generatePlacement.
     */
    public static void generatePlacement (String boardString, String tilePlacementString){ }
    public static void undoGeneratePlacement (String boardString, String tilePlacementString){ }



    /*
    currentBasicScore: Return the basic scores for current game.
    currentAdvancedScore: Return the advanced scores for current game.
    */
    public static int currentBasicScore (String boardString){ return -1; }
    public static int currentAdvancedScore (String boardString){ return -1; }



    /*
    Return the best placement of a tile for current game.
     */
    public static String placementHint (String boardString, String tile) {
        return null;
    }


    public static void finishTheRound (int round){ round++; }



    /*
    Empty the boardString and reinitialize the specialTiles.
    */
    public static void restartTheGame() { }



}
