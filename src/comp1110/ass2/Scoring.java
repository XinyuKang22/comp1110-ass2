package comp1110.ass2;

import comp1110.ass2.gui.Board;

public class Scoring {

    final String boardString = "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52";
    final String[] highwayExits = {"A1", "A5", "D0", "D6", "G1", "G5"};
    final String[] railwayExits = {"A3", "B0", "B6", "F0", "F6", "G3"};


    public static int countConnectedExits(String boardString) {
        String[] point = {"0", "0","4", "8", "12", "16", "20", "24", "28", "32", "36", "40", "45"};
        int a = 0;
        String b = "";
        for (int i = 0; i < boardString.length(); i = i + 5) {
            if(Board.isConnectedToExit(boardString.substring(i,i+5)) && (!inString(b , boardString.substring(i,i+5)))){
                if(!inString(b,removeMes(getExits(boardString,boardString.substring(i,i+5))))){
                b += removeMes(getExits(boardString,boardString.substring(i,i+5)));
                if (inString(b , boardString.substring(i,i+5))){a += Integer.valueOf(point[removeMes(getExits(boardString,boardString.substring(i,i+5))).length()/5]);}
                else{a += Integer.valueOf(point[removeMes(getExits(boardString,boardString.substring(i,i+5))).length()/5 + 1]);} }

            } }

        return a;
    }

    public static int countErrors(String boardString) {
        int errors = 0;
        for (int i = 2; i < boardString.length(); i = i + 5) {
            String a = boardString.substring(i-2,i+3);
            String[] info = Board.rotatedTileInfo(a);
            int exsit = 4;
            for (int z=0; z< info.length;z++){
                if (info[z].equals("Nothing")){exsit -= 1;} }
            String[] grid = Board.getNearbyGrids(boardString.substring(i,i+2));
            int connect = 0;
            for (int j = 0; j < boardString.length(); j = j + 5){
                if (RailroadInk.areConnectedNeighbours(a,boardString.substring(j,j+5))) {connect += 1;} }
             errors += connect - exsit + getConnectedEdge(a);
        }
            return errors;
    }

    public static int countTilesInCentre(String boardString) {
        final String[] centreGrid = {"C2", "C3", "C4", "D2", "D3", "D4", "E2", "E3", "E4"};
        int score = 0;
        for (int i = 2; i < boardString.length(); i = i + 5) {
            if (inArray(centreGrid, boardString.substring(i, i + 2))) {
                score += 1;}
           }
            return score;
        }

    public static int countLongestHighway (String boardString){
        return -1;
    }

    public static int countLongestRailway (String boardString){
        return -1;
    }

    public static int getAdvancedScore ( int basicScore, int longestHighway, int longestRailway){
        return -1;
    }

    public static boolean inArray (String[]a, String b )
    {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(b)) {
                return true;
            }
        }
        return false;
    }

    public static boolean inString (String a, String b){
        for (int i =0; i < a.length(); i += 5){
            if (a.substring(i,i+5).equals(b)){return true;}}
        return false;
    }

    public  static  int  getConnectedEdge (String tilePlacementString){
        String[] info = Board.rotatedTileInfo(tilePlacementString);
        if (tilePlacementString.charAt(2) == 'A' && tilePlacementString.charAt(3) == '0') {
            if(info[0].equals("Nothing") && info[2].equals("Nothing")){return 0;} else if (info[0].equals("Nothing") || info[2].equals("Nothing")){return 1;} else {return 2;} }
        else if (tilePlacementString.charAt(2) == 'A' && tilePlacementString.charAt(3) == '6'){
            if(info[0].equals("Nothing") && info[1].equals("Nothing")){return 0;} else if (info[0].equals("Nothing") || info[1].equals("Nothing")){return 1;} else {return 2;} }
        else if (tilePlacementString.charAt(2) == 'G' && tilePlacementString.charAt(3) == '0'){
            if(info[2].equals("Nothing") && info[3].equals("Nothing")){return 0;} else if (info[2].equals("Nothing") || info[3].equals("Nothing")){return 1;} else {return 2;} }
        else if (tilePlacementString.charAt(2) == 'G' && tilePlacementString.charAt(3) == '6'){
            if(info[1].equals("Nothing") && info[2].equals("Nothing")){return 0;} else if (info[1].equals("Nothing") || info[2].equals("Nothing")){return 1;} else {return 2;} }
        else if(tilePlacementString.charAt(2) == 'A' ){if (info[0].equals("Nothing")) {return 0;} else {return 1;}}
        else if(tilePlacementString.charAt(2) == 'G'){if (info[2].equals("Nothing")){return 0;} else {return 1;}}
        else if(tilePlacementString.charAt(3) == '0'){if (info[3].equals("Nothing")){return 0;} else {return 1;}}
        else  if(tilePlacementString.charAt(3) == '6'){if (info[1].equals("Nothing")){return 0;} else {return 1;}}
        return 0;
}

    public static String getExits(String boardString, String tileString){
        String a  = "";
        for (int i = 0; i < boardString.length(); i += 5){
            if(!(Board.isAtExit(boardString.substring(i,i+5)))){
                if (RailroadInk.areConnectedNeighbours(tileString,boardString.substring(i,i+5))){
                    if ( !(boardString.substring(i,i+5).substring(0,2).equals("B2"))){
                      a += getExits(removeMe(boardString,tileString), boardString.substring(i,i+5)); }

                    else {
                             for (int j = 0; j < boardString.length();j += 5 ){
                                 if (RailroadInk.areConnectedNeighbours(boardString.substring(j,j+5),boardString.substring(i,i+5))){
                                    if(Board.relativePosition(boardString.substring(i,i+5),tileString) == 0) {
                                        if (Board.relativePosition(boardString.substring(i,i+5),boardString.substring(j,j+5)) == 2 && !(Board.isAtExit(boardString.substring(j,j+5)))){
                                            a += getExits(removeMe(removeMe(boardString,tileString),boardString.substring(i,i+5)), boardString.substring(j,j+5));} else if (Board.relativePosition(boardString.substring(i,i+5),boardString.substring(j,j+5)) == 2 && Board.isAtExit(boardString.substring(j,j+5))){a += boardString.substring(j,j+5) ;}}
                                    else if(Board.relativePosition(boardString.substring(i,i+5),tileString) == 1)
                                    {if (Board.relativePosition(boardString.substring(i,i+5),boardString.substring(j,j+5)) == 3 && !(Board.isAtExit(boardString.substring(j,j+5)))){
                                        a += getExits(removeMe(removeMe(boardString,tileString),boardString.substring(i,i+5)), boardString.substring(j,j+5));}else if (Board.relativePosition(boardString.substring(i,i+5),boardString.substring(j,j+5)) == 3 && Board.isAtExit(boardString.substring(j,j+5))) {a += boardString.substring(j,j+5) ;}}
                                    else if(Board.relativePosition(boardString.substring(i,i+5),tileString) == 2)
                                    {if (Board.relativePosition(boardString.substring(i,i+5),boardString.substring(j,j+5)) == 0 && !(Board.isAtExit(boardString.substring(j,j+5)))){
                                        a += getExits(removeMe(removeMe(boardString,tileString),boardString.substring(i,i+5)), boardString.substring(j,j+5));}else if (Board.relativePosition(boardString.substring(i,i+5),boardString.substring(j,j+5)) == 0 && Board.isAtExit(boardString.substring(j,j+5))) {a += boardString.substring(j,j+5) ;}}
                                    else if(Board.relativePosition(boardString.substring(i,i+5),tileString) == 3)
                                    { if (Board.relativePosition(boardString.substring(i,i+5),boardString.substring(j,j+5)) == 1 && !(Board.isAtExit(boardString.substring(j,j+5)))){
                                        a += getExits(removeMe(removeMe(boardString,tileString),boardString.substring(i,i+5)), boardString.substring(j,j+5));}else if (Board.relativePosition(boardString.substring(i,i+5),boardString.substring(j,j+5)) == 1 && Board.isAtExit(boardString.substring(j,j+5))) {a += boardString.substring(j,j+5) ;}}} }}}}
            else {
                if (!inString(a,boardString.substring(i,i+5)) && (RailroadInk.areConnectedNeighbours(tileString,boardString.substring(i,i+5))))
                {a += boardString.substring(i,i+5) + getExits(removeMe(boardString,tileString), boardString.substring(i,i+5));}}}
        return a;
    }

    private static String removeMe (String boardString, String target){
        for (int i = 0; i < boardString.length(); i+=5){
            if(boardString.substring(i,i+5).equals(target)){boardString = boardString.substring(0,i)+boardString.substring(i+5);}
        }return  boardString;
    }
    private static String removeMes (String a){
        String b = "";
        for (int i = 0; i < a.length(); i+=5){
            if (!inString(b,a.substring(i,i+5))){
             b += a.substring(i,i+5);}}
        return b;
    }

    public static void main(String[] args) {
        String a = "A4A50A1A30B2B31A0C34A3B41B2C40A3B52A2B60A2C62S5C50B1D65A4B21A2A60A3B10A4A10A4C10B2G10B2F10A4E10A3D12A1F01S2D00A4C00B1B02A0F23A0G20A2F61B2F50A3G52A0G02";
        String c = "A3D61A3D53A4D41A3D31A3D23A3D31A3D23A4D01S2D10";
        String b = "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52";
        String d = "A2B63A4D01A2G30B0G12A2G30B0G12A2G30A4D01B0G12A0F61";
        String e = "A4A10B2G10S2D00B1B02A1A30A2B60B1D65B2G10A4A50A1A30A2B60B1D65A4A10S2D00B1B02";
        System.out.println(removeMes("A4A10B2G10S2D00B1B02A1A30A2B60B1D65B2G10"));
        System.out.println(countConnectedExits(a));
    }
}
