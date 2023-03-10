package comp1110.ass2.gui;

import comp1110.ass2.RailroadInk;
import comp1110.ass2.Tiles;

import java.util.ArrayList;


public class Board extends RailroadInk {


    //@author Yinuo Zhang
    public static String[] grid = {"A0","A1","A2","A3","A4","A5","A6",
            "B0","B1","B2","B3","B4","B5","B6",
            "C0","C1","C2","C3","C4","C5","C6",
            "D0","D1","D2","D3","D4","D5","D6",
            "E0","E1","E2","E3","E4","E5","E6",
            "F0","F1","F2","F3","F4","F5","F6",
            "G0","G1","G2","G3","G4","G5","G6"};



    /**
     * Given a location string, find its index in "grid"
     * @author Yinuo Zhang
     * @param theLocation i.e. "A4" "D3" "G6"
     * @return the index of the location string in "grid" , which can be any integer between [0,48]
     */
    public static int findLocationIndex (String theLocation){

        for(int i=0; i<49; i++){
            if(grid[i].equals(theLocation)){
                return i;
            }
        }
        return -1;
    }



    /**
     * Given a grid, find the grids near it.
     * i.e. input:"C2", output: {"B2","D2","C1","C3"}
     * @author Yinuo Zhang
     * @param theLocation location string representing the grid
     * @return location string list of grids on the top, bottom, left and right(if there is any)
     */
    public static String[] getNearbyGrids (String theLocation) {

        int theIndex = findLocationIndex(theLocation);

        String[] nearbyGrids = new String[4];

        // Considered situations of having only two nearby grids, having three, and for most of them, having four.
        if (theLocation.equals("A0")) {
            nearbyGrids[0] = grid[theIndex + 7];
            nearbyGrids[1] = grid[theIndex + 1];
        } else if (theLocation.equals("A6")) {
            nearbyGrids[0] = grid[theIndex + 7];
            nearbyGrids[1] = grid[theIndex - 1];
        } else if (theLocation.equals("G0")) {
            nearbyGrids[0] = grid[theIndex - 7];
            nearbyGrids[1] = grid[theIndex + 1];
        } else if (theLocation.equals("G6")) {
            nearbyGrids[0] = grid[theIndex - 7];
            nearbyGrids[1] = grid[theIndex - 1];
        }else if (theLocation.equals("B6") || theLocation.equals("C6") || theLocation.equals("D6") ||theLocation.equals("E6") ||theLocation.equals("F6") ) {
            nearbyGrids[0]=grid[theIndex-7];
            nearbyGrids[1]=grid[theIndex+7];
            nearbyGrids[2]=grid[theIndex-1];
        }else if (theLocation.equals("B0") || theLocation.equals("C0") || theLocation.equals("D0") ||theLocation.equals("E0") ||theLocation.equals("F0") ){
            nearbyGrids[0]=grid[theIndex-7];
            nearbyGrids[1]=grid[theIndex+7];
            nearbyGrids[2]=grid[theIndex+1];
        }else if (theLocation.equals("A1") ||theLocation.equals("A2") ||theLocation.equals("A3") ||theLocation.equals("A4") ||theLocation.equals("A5") ){
            nearbyGrids[0]=grid[theIndex+7];
            nearbyGrids[1]=grid[theIndex-1];
            nearbyGrids[2]=grid[theIndex+1];
        }else if (theLocation.equals("G1") ||theLocation.equals("G2") ||theLocation.equals("G3") ||theLocation.equals("G4") ||theLocation.equals("G5") ){
            nearbyGrids[0]=grid[theIndex-7];
            nearbyGrids[1]=grid[theIndex-1];
            nearbyGrids[2]=grid[theIndex+1];
        }else {
            nearbyGrids[0]=grid[theIndex-7];
            nearbyGrids[1]=grid[theIndex+7];
            nearbyGrids[2]=grid[theIndex-1];
            nearbyGrids[3]=grid[theIndex+1];
        }

        int countNotNull =0;
        for(String grid:nearbyGrids){
            if(grid!=null){
                countNotNull++;
            }
        }

        String[] toReturn = new String[countNotNull];
        System.arraycopy(nearbyGrids,0,toReturn,0,countNotNull);

        return toReturn;
    }



    /**
     * Given two tile placement string, return whether they are adjacent.
     * @author Yinuo Zhang
     * @return if they are adjacent, return true.
     */
    public static boolean areNeighbors (String tilePlacementStringA,String tilePlacementStringB){
        String locationA = tilePlacementStringA.substring(2,4);
        String locationB = tilePlacementStringB.substring(2,4);
        String[] possibleNeighborLocations = getNearbyGrids(locationB);

        for (String location:possibleNeighborLocations){
            if(locationA.equals(location)){
                return true;
            }
        }
        return false;
    }



    /**
     * Given a tile placement string, find the edge/centre details(like, "Highway","Station" , and so on) in given orientation.
     * @author Xinyu Kang
     * @return a list of five strings, recorded information of the tile in current orientation.
     *         the strings are ordered with UPLR and Centre.  e.g. {"Highway","Railway","Railway","Railway","Station"}
     */
    public static String[] rotatedTileInfo (String tilePlacementString) {
        String[] info = new String[5]; //record the information for the top, right, bottom, left and centre of the rotated tile
        String tileString = tilePlacementString.substring(0,2);
        Tiles tile = Tiles.valueOf(tileString);
        String orientation = tilePlacementString.substring(4);

        if(orientation.equals("0")){ //original position
            info[0] = Tiles.getNorth(tile);
            info[1] = Tiles.getEast(tile);
            info[2] = Tiles.getSouth(tile);
            info[3] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("1")){ //clockwise 90 degree
            info[1] = Tiles.getNorth(tile);
            info[2] = Tiles.getEast(tile);
            info[3] = Tiles.getSouth(tile);
            info[0] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("2")){ //clockwise 180 degree
            info[2] = Tiles.getNorth(tile);
            info[3] = Tiles.getEast(tile);
            info[0] = Tiles.getSouth(tile);
            info[1] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("3")){ //clockwise 270 degree
            info[3] = Tiles.getNorth(tile);
            info[0] = Tiles.getEast(tile);
            info[1] = Tiles.getSouth(tile);
            info[2] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("4")){ //mirroring orientation 0
            info[0] = Tiles.getNorth(tile);
            info[3] = Tiles.getEast(tile);
            info[2] = Tiles.getSouth(tile);
            info[1] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("5")){ //clockwise 90 degree base on orientation 4
            info[1] = Tiles.getNorth(tile);
            info[0] = Tiles.getEast(tile);
            info[3] = Tiles.getSouth(tile);
            info[2] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("6")){//clockwise 180 degree base on orientation 4
            info[2] = Tiles.getNorth(tile);
            info[1] = Tiles.getEast(tile);
            info[0] = Tiles.getSouth(tile);
            info[3] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("7")){//clockwise 360 degree base on orientation 4
            info[3] = Tiles.getNorth(tile);
            info[2] = Tiles.getEast(tile);
            info[1] = Tiles.getSouth(tile);
            info[0] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }

        return info;
    }


    /**
     * Determine whether the tile is put in a position that can connect to exit
     * @author Xinyu Kang
     * @return true if the tile is at exit
     */
    public static boolean isAtExit (String tilePlacementString){
        String[] exits = {"A1","A5","D0","D6","G1","G5","A3","B0","B6","F0","F6","G3"};
        String location = tilePlacementString.substring(2,4);

        for(String exit:exits){
            if(exit.equals(location)){
                return true;
            }
        }
        return false;
    }


    /**
     * Determine whether the tile is connected to the exit.Highway edge should connect to highway exit, and same for Railway.
     * @author Xinyu Kang
     * @return true if the tile is validly connected to an exit
     */
    public static boolean isConnectedToExit (String tilePlacementString){

        if(isAtExit(tilePlacementString)){
            String location = tilePlacementString.substring(2,4);
            String[] info = rotatedTileInfo(tilePlacementString);

            if(location.equals("A1") || location.equals("A5")){
                if (info[0].equals("Highway")){   //A1 & A5 are highway exits and can be connected by the top of tiles
                    return true;
                }
            }else if (location.equals("A3")){    //A3 is railway exit and can be connected by the top of tiles
                if (info[0].equals("Railway")){
                    return true;
                }
            }else if (location.equals("D6")) {  //D6 is highway exit and can be connected by the right of tiles
                if (info[1].equals("Highway")) {
                    return true;
                }
            }else if (location.equals("B6") || location.equals("F6")){
                if (info[1].equals("Railway")){ //B6 and F6 are railway exits and can be connected by the right of tiles
                    return true;
                }
            }else if (location.equals("G1") || location.equals("G5")){
                if (info[2].equals("Highway")){ //G1 and G5 are highway exits and can be connected by the bottom of tiles
                    return true;
                }
            }else if (location.equals("G3")){
                if (info[2].equals("Railway")){ //G3 is railway exit and can be connected by the bottom of tiles
                    return true;
                }
            }else if (location.equals("D0")){
                if (info[3].equals("Highway")){//D0 is highway exit and can be connected by the left of tiles
                    return true;
                }
            }else if (location.equals("B0") || location.equals("F0")){
                if (info[3].equals("Railway")){//B0 and F0 are railway exits and can be connected by the left of tiles
                    return true;
                }
            }
        }
        return false;
    }




    /**
     * Find the relative position of B for A
     * @author Xinyu Kang
     * @return int 0 represents thePlacement is on referencePlacement;
     *         int 1 represents thePlacement is on the right of referencePlacement;
     *         int 2 represents thePlacement is under referencePlacement;
     *         int 3 represents thePlacement is on the left of referencePlacement;
     */
    public static int relativePosition (String referencePlacement, String thePlacement){
        String referenceRow = referencePlacement.substring(2,3);
        String referenceColumn = referencePlacement.substring(3,4);
        String theRow = thePlacement.substring(2,3);
        String theColumn = thePlacement.substring(3,4);

        if(theColumn.equals(referenceColumn)){
            if(theRow.compareTo(referenceRow)==-1){
                return 0; //on
            }else if (theRow.compareTo(referenceRow)==1){
                return 2; //under
            }
        }else if (theRow.equals(referenceRow)){
            if(theColumn.compareTo(referenceColumn)==-1){
                return 3; //left
            }else if (theColumn.compareTo(referenceColumn)==1){
                return 1; //right
            }
        }
        return -1;
    }



    /**
     * From tilePlacementList, find whether there is at least one tile connected to the tile.
     * @author Xinyu Kang
     * @return true if the tile has a validly connected neighbor in the tile list
     */
    public static boolean hasConnectedNeighbors (String tilePlacementString, String[] tilePlacementList){
        for(String tilePlacement:tilePlacementList){
            if(areConnectedNeighbours(tilePlacementString,tilePlacement)){
                return true;
            }
        }
        return false;
    }

    /**
     * @author Xinyu Kang
     * @param tilePlacementString
     * @param boardString
     * @return true if the tile placement is overlapped with previous placements
     */
    public static boolean isOverlap(String tilePlacementString, String boardString){

        for(int i = 0; i<boardString.length(); i=i+5){
            if(boardString.charAt(i+2)==tilePlacementString.charAt(2)){
                if(boardString.charAt(i+3)==tilePlacementString.charAt(3)){
                    return true;
                }
            }
        }
        return false;
    }

}
