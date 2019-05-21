package comp1110.ass2;

import com.sun.glass.ui.View;
import comp1110.ass2.gui.Viewer;
import javafx.scene.Group;

//Written by Xinyu Kang
public class MultiplePlayers extends Viewer {

    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 640;
    private static final String URI_BASE = "assets/";
    private final Group root = new Group();
    private final Group board = new Group();  //包括 : 棋盘， 玩家头像， 玩家名称, 回合计数器， 基本分数按钮， makePlace 按钮
    private String yourName="";  //玩家名字，等待输入
    private String boardStringPlayer = "";
    private String boardStringComp = "";
    private final Group specials = new Group(); //draggable special tiles  player
    private final Group specialImages = new Group();  //special tile images   player
    private final Group tempSpecialImages = new Group();
    private final Group tempSpecialUsing = null;
    private final Group specialImagesComp = new Group();  //special tile images   comp
    private int countRound = 0;
    private int countDice = 0;


    void boardsDisplay(){
        
    }



    int round = 1;
    String[] playersBoardStrings;

    public static void finishTheRound (int round){ round++; }



    /*
    Create a empty board string for each player.
     */
    public static void initializeGame (String[] playersNameList){
        String[] playersBoardStrings = new String[playersNameList.length];
    }



    /*
    Find out the highest score and return his/her name.
     */
    public static String getWinner (String[] playersNameList, String[] playersBoardStrings){
        return null;
    }


}
