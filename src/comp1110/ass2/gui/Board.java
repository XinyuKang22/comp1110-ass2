package comp1110.ass2.gui;

import comp1110.ass2.RailroadInk;
import comp1110.ass2.Tiles;


public class Board extends RailroadInk {



    public static String[] grid = {"A0","A1","A2","A3","A4","A5","A6",
            "B0","B1","B2","B3","B4","B5","B6",
            "C0","C1","C2","C3","C4","C5","C6",
            "D0","D1","D2","D3","D4","D5","D6",
            "E0","E1","E2","E3","E4","E5","E6",
            "F0","F1","F2","F3","F4","F5","F6",
            "G0","G1","G2","G3","G4","G5","G6"};

    /**
     * Given a location string, determine its index in "grid"
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


    public static String[] getNearbyGrids (String theLocation){

        int theIndex = findLocationIndex(theLocation);

        String[] s = new String[4];
        if(theLocation.equals("B6") || theLocation.equals("C6") || theLocation.equals("D6") ||theLocation.equals("E6") ||theLocation.equals("F6") ){
            s[0]=grid[theIndex-7];
            s[1]=grid[theIndex+7];
            s[2]=grid[theIndex-1];
        }else if(theLocation.equals("B0") || theLocation.equals("C0") || theLocation.equals("D0") ||theLocation.equals("E0") ||theLocation.equals("F0") ){
            s[0]=grid[theIndex-7];
            s[1]=grid[theIndex+7];
            s[2]=grid[theIndex+1];
        }else if(theLocation.equals("A1") ||theLocation.equals("A2") ||theLocation.equals("A3") ||theLocation.equals("A4") ||theLocation.equals("A5") ){
            s[0]=grid[theIndex+7];
            s[1]=grid[theIndex-1];
            s[2]=grid[theIndex+1];
        }else if(theLocation.equals("G1") ||theLocation.equals("G2") ||theLocation.equals("G3") ||theLocation.equals("G4") ||theLocation.equals("G5") ){
            s[0]=grid[theIndex-7];
            s[1]=grid[theIndex-1];
            s[2]=grid[theIndex+1];
        }else if(theLocation.equals("A0")){
            s[0]=grid[theIndex+7];
            s[1]=grid[theIndex+1];
        }else if(theLocation.equals("A6")){
            s[0]=grid[theIndex+7];
            s[1]=grid[theIndex-1];
        }else if(theLocation.equals("G0")){
            s[0]=grid[theIndex-7];
            s[1]=grid[theIndex+1];
        }else if(theLocation.equals("G6")){
            s[0]=grid[theIndex-7];
            s[1]=grid[theIndex-1];
        }else {
            s[0]=grid[theIndex-7];
            s[1]=grid[theIndex+7];
            s[2]=grid[theIndex-1];
            s[3]=grid[theIndex+1];
        }

        int countValidNeighborLocation =0;
        for(String neighbor:s){
            if(neighbor!=null){
                countValidNeighborLocation++;
            }
        }

        String[] toReturn = new String[countValidNeighborLocation];
        for(int i = 0;i<countValidNeighborLocation;i++){
            toReturn[i]=s[i];
        }
        return toReturn;
    }



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




    //返回当前旋转情况下，上、右、下、左、中的情况
    public static String[] rotatedTileInfo (String tilePlacementString) {
        String[] info = new String[5];
        String tileString = tilePlacementString.substring(0,2);
        Tiles tile = Tiles.valueOf(tileString);
        String orientation = tilePlacementString.substring(4);

        if(orientation.equals("0")){
            info[0] = Tiles.getNorth(tile);
            info[1] = Tiles.getEast(tile);
            info[2] = Tiles.getSouth(tile);
            info[3] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("1")){
            info[1] = Tiles.getNorth(tile);
            info[2] = Tiles.getEast(tile);
            info[3] = Tiles.getSouth(tile);
            info[0] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("2")){
            info[2] = Tiles.getNorth(tile);
            info[3] = Tiles.getEast(tile);
            info[0] = Tiles.getSouth(tile);
            info[1] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("3")){
            info[3] = Tiles.getNorth(tile);
            info[0] = Tiles.getEast(tile);
            info[1] = Tiles.getSouth(tile);
            info[2] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("4")){
            info[0] = Tiles.getNorth(tile);
            info[3] = Tiles.getEast(tile);
            info[2] = Tiles.getSouth(tile);
            info[1] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("5")){
            info[1] = Tiles.getNorth(tile);
            info[0] = Tiles.getEast(tile);
            info[3] = Tiles.getSouth(tile);
            info[2] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("6")){
            info[2] = Tiles.getNorth(tile);
            info[1] = Tiles.getEast(tile);
            info[0] = Tiles.getSouth(tile);
            info[3] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }else if (orientation.equals("7")){
            info[3] = Tiles.getNorth(tile);
            info[2] = Tiles.getEast(tile);
            info[1] = Tiles.getSouth(tile);
            info[0] = Tiles.getWest(tile);
            info[4] = Tiles.getCentre(tile);
        }

        return info;
    }

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


    public static boolean isConnectedToExit (String tilePlacementString){

        if(isAtExit(tilePlacementString)){
            String location = tilePlacementString.substring(2,4);
            String[] info = rotatedTileInfo(tilePlacementString);

            if(location.equals("A1") || location.equals("A5")){
                if (info[0].equals("Highway")){
                    return true;
                }
            }else if (location.equals("A3")){
                if (info[0].equals("Railway")){
                    return true;
                }
            }else if (location.equals("D6")) {
                if (info[1].equals("Highway")) {
                    return true;
                }
            }else if (location.equals("B6") || location.equals("F6")){
                if (info[1].equals("Railway")){
                    return true;
                }
            }else if (location.equals("G1") || location.equals("G5")){
                if (info[2].equals("Highway")){
                    return true;
                }
            }else if (location.equals("G3")){
                if (info[2].equals("Railway")){
                    return true;
                }
            }else if (location.equals("D0")){
                if (info[3].equals("Highway")){
                    return true;
                }
            }else if (location.equals("B0") || location.equals("F0")){
                if (info[3].equals("Railway")){
                    return true;
                }
            }
        }
        return false;
    }


    public static int relativePosition (String referencePlacement, String thePlacement){
        String referenceRow = referencePlacement.substring(2,3);
        String referenceColumn = referencePlacement.substring(3,4);
        String theRow = thePlacement.substring(2,3);
        String theColumn = thePlacement.substring(3,4);

        if(theColumn.equals(referenceColumn)){
            if(theRow.compareTo(referenceRow)==-1){
                return 0;
            }else if (theRow.compareTo(referenceRow)==1){
                return 2;
            }
        }else if (theRow.equals(referenceRow)){
            if(theColumn.compareTo(referenceColumn)==-1){
                return 3;
            }else if (theColumn.compareTo(referenceColumn)==1){
                return 1;
            }
        }
        return -1;
    }


    public static boolean hasConnectedNeighbors (String tilePlacementString, String[] tilePlacementList){
        for(String tilePlacement:tilePlacementList){
            if(areConnectedNeighbours(tilePlacementString,tilePlacement)){
                return true;
            }
        }
        return false;
    }

}
