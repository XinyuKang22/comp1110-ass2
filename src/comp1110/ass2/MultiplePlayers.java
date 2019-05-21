package comp1110.ass2;

import comp1110.ass2.gui.Board;
import comp1110.ass2.gui.Viewer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Optional;

import static javafx.scene.paint.Color.*;


//Written by Xinyu Kang
public class MultiplePlayers extends Viewer{

    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 640;
    private static final String URI_BASE = "assets/";
    private static Group rootMul = new Group();
    private static Group board = new Group();  //包括 : 棋盘， 玩家头像， 玩家名称, 回合计数器， 基本分数按钮， 骰子框框, 骰子
    private static String yourName="";  //玩家名字，等待输入
    private static String boardStringPlayer = "";
    private static String boardStringComp = "";
    private static Group specials = new Group(); //draggable special tiles  player
    private static Group specialImages = new Group();  //special tile images   player
    private static Group tempSpecialImages = new Group();
    private static Group tempSpecialUsing = null;
    private static Group specialImagesComp = new Group();  //special tile images   comp
    private static int countRound = 0;
    private static int countDice = 0;
    private static Group grids = new Group();   //棋盘和返回键, 名字和基础分
    private static int basicScorePlayer = 0;
    private static int basicScoreComp = 0;
    private static DraggableTile tileGet = null;


    public static void mulStart(){
        askPlayerName();
        initBoard();
        nameAndScore();
        initSpecial();
        initDiceAndButtons();
        root.getChildren().add(rootMul);
    }

    private static void initDiceAndButtons(){
        Button roll = new Button("Roll dice");
        roll.setLayoutX(490);
        roll.setLayoutY(230);
        roll.setOnMousePressed(e -> {
            board.getChildren().remove(roll);
            Image diceRolling = new Image(Viewer.class.getResource("assets/"+"dieA.gif").toString());
            ImageView imageView = new ImageView();
            imageView.setLayoutX(490);
            imageView.setLayoutY(150);
            imageView.setFitHeight(60);
            imageView.setFitWidth(60);
            Timeline timeline = new Timeline( new KeyFrame(Duration.ZERO, event -> {imageView.setImage(diceRolling);}),new KeyFrame(Duration.millis(1800)));
            board.getChildren().add(imageView);
            timeline.play();
            timeline.setOnFinished(actionEvent -> {
                board.getChildren().remove(imageView);
                String diceResult = RailroadInk.generateDiceRoll();
                String tileName = diceResult.substring(countDice*2,countDice*2+2);
                //String placement = RailroadInk.generateMove(boardStringComp,tileName);
                tileGet = new DraggableTile(tileName,495,155);
                board.getChildren().add(tileGet);
            });

        });
        board.getChildren().add(roll);
    }

    private static void initBoard(){   //棋盘和 back按钮
        for(int i=0; i<7; i++){
            for(int m=0; m<7; m++){
                grids.getChildren().add(new Grid(70+i*50,100+m*50,50));
            }
        }
        for(int i=0; i<7; i++){
            for(int m=0; m<7; m++){
                grids.getChildren().add(new Grid(620+i*50,100+m*50,50));
            }
        }
        board.getChildren().add(grids);

        Rectangle diceFrame = new Rectangle();    //建一个骰子的框框
        diceFrame.setX(490);
        diceFrame.setY(150);
        diceFrame.setWidth(60);
        diceFrame.setHeight(60);
        diceFrame.setFill(BEIGE);
        diceFrame.setStroke(BLACK);
        diceFrame.setStrokeWidth(5);
        board.getChildren().add(diceFrame);

        Button back = new Button("Back");
        back.setLayoutX(20);
        back.setLayoutY(20);
        back.setOnMousePressed(e -> {    //所有group都要清空， 数字string都要还原
            rootMul.getChildren().clear();
            board.getChildren().clear();
            grids.getChildren().clear();
            specials.getChildren().clear();
            specialImages.getChildren().clear();
            specialImagesComp.getChildren().clear();
            yourName="";

            root.getChildren().remove(rootMul);
            root.getChildren().add(begin);
        });
        board.getChildren().add(back);

        rootMul.getChildren().add(board);
    }

    private static void askPlayerName(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Welcome to Battle Mode ! ");
        dialog.setContentText("Please enter your name : ");
        Optional<String> name = dialog.showAndWait();
        if(name.isPresent()){
            yourName=name.get();
        }
    }

    private static void nameAndScore(){
        Text name1 = new Text();
        Text name2 = new Text();
        Text score1 = new Text();
        Text score2 = new Text();
        name1.setText(yourName);
        name2.setText("Computer");
        score1.setText("Basic Score: "+basicScorePlayer);
        score2.setText("Basic Score: "+basicScoreComp);
        name1.setLayoutX(70);
        name1.setLayoutY(80);
        score1.setLayoutX(320);
        score1.setLayoutY(80);
        name2.setLayoutX(620);
        name2.setLayoutY(80);
        score2.setLayoutX(870);
        score2.setLayoutY(80);
        grids.getChildren().addAll(name1,name2,score1,score2);
    }

    public static void initSpecial(){
        for(int i = 0; i<6; i++){
            String tileName = "S"+i;
            specialImages.getChildren().add(new Tile(tileName,70+i*60,500));
            specialImagesComp.getChildren().add(new Tile(tileName,620+i*60,500));
        }
        specials.getChildren().addAll(specialImages,specialImagesComp);
        rootMul.getChildren().add(specials);
    }



    // -----分界线----------
    //后面的都要改

    static class Tile extends ImageView {
        double x,y;
        String tileName;
        MultiplePlayers multiplePlayers;
        Tile(String tileName, double x, double y){
            this.x = x;
            this.y = y;
            this.tileName=tileName;
            this.setImage(new Image(Viewer.class.getResource(URI_BASE+tileName+".png").toString()));
            this.setFitHeight(50);
            this.setFitWidth(50);
            this.setLayoutX(x);
            this.setLayoutY(y);
            this.toFront();

        }
    }


    static class DraggableTile extends Tile {
        private double x,y;
        private double mouseX, mouseY;
        //private MultiplePlayers multiplePlayers;
        private int rotate=0;
        String gridName = "__";

        DraggableTile(String tileName, double x, double y){
            super(tileName,x,y);
            this.x = x;
            this.y = y;
            //this.multiplePlayers = multiplePlayers;

            this.setOnScroll(event -> {
                this.rotate();
            });
            this.setOnMousePressed(event -> {
                this.mouseX = event.getSceneX();
                this.mouseY = event.getSceneY();
                this.x = super.getLayoutX();
                this.y = super.getLayoutY();
                this.toFront();
                //
            });
            this.setOnMouseDragged(event -> {
                this.setLayoutX(this.x+ event.getSceneX() - mouseX);
                this.setLayoutY(this.y+  event.getSceneY() - mouseY);
            });
            this.setOnMouseReleased(event -> {
                double xFitted = nearestGrid(this.getLayoutX(),this.getLayoutY())[0];
                double yFitted = nearestGrid(this.getLayoutX(),this.getLayoutY())[1];
                this.setLayoutX(xFitted);
                this.setLayoutY(yFitted);

                double theX = this.getLayoutX();
                double theY = this.getLayoutY();
                double a=150;
                double b=100;
                double min = 65*65*2;

                for(String key:theBoardGrid().keySet()){
                    int gridX = theBoardGrid().get(key)[0];
                    int gridY = theBoardGrid().get(key)[1];
                    double xSquare = (theX-gridX)*(theX-gridX);
                    double ySquare = (theY-gridY)*(theY-gridY);
                    if(xSquare+ySquare<min){
                        a = gridX;
                        b = gridY;
                        min = xSquare+ySquare;
                        gridName=key;
                    }
                }
                if(min<65*65*2){
                    this.setLayoutX(a);
                    this.setLayoutY(b);
                }else {
                    this.setLayoutX(x);
                    this.setLayoutY(y);
                }
                lockOthers();
            });
        }
        void lockOthers(){
            if(this.tileName.substring(0,1).equals("S")){
                /*
                if(specialMoved==null){
                    specialMoved=this;
                    special.getChildren().add(this);
                    tiles.getChildren().remove(specialTiles);
                    specialPictures.getChildren().clear();
                    for(ImageView imageView:specialImages(this)){
                        specialPictures.getChildren().add(imageView);
                    }
                    special.getChildren().add(specialPictures);
                }
                 */

            }
        }

        String getPlacementString(){
            return tileName+gridName+rotate/90;
        }

        void rotate(){
            rotate=rotate+90;
            if(rotate<=270){
                this.setRotate(rotate);
            }else if(rotate<=630){
                this.setRotate(0);
                this.setScaleX(-1);
                this.setRotate(rotate-360);
            }else {
                rotate=0;
                this.setRotate(rotate);
                this.setScaleX(1);
            }
        }

        void alertError(){
            Rectangle up = new Rectangle();
            Rectangle down = new Rectangle();
            Rectangle left = new Rectangle();
            Rectangle right = new Rectangle();
            Rectangle[] allRec = {up,down,left,right};
            for(Rectangle rec:allRec){
                rec.setFill(RED);
            }
            up.setWidth(75);
            up.setHeight(5);
            up.setX(this.getLayoutX()-5);
            up.setY(this.getLayoutY()-5);
            down.setWidth(75);
            down.setHeight(5);
            down.setX(this.getLayoutX()-5);
            down.setY(this.getLayoutY()+65);
            left.setWidth(5);
            left.setHeight(75);
            left.setX(this.getLayoutX()-5);
            left.setY(this.getLayoutY()-5);
            right.setWidth(5);
            right.setHeight(75);
            right.setX(this.getLayoutX()+65);
            right.setY(this.getLayoutY()-5);

            //alert.getChildren().addAll(up,down,left,right);
        }

        void backToOrigin(){  //can only use on special tiles
            int i = Integer.parseInt(this.tileName.substring(1,2));
            if(i<3){
                this.setLayoutX(700+i*75);
                this.setLayoutY(150);
            }else {
                this.setLayoutX(700+(i-3)*75);
                this.setLayoutY(150+75);
            }
            this.setRotate(0);
            this.setScaleX(1);
            //specialMoved=null;
        }

    }

    static HashMap<String,int[]> theBoardGrid(){
        HashMap<String,int[]> locations = new HashMap<>();
        int[][] locationValue = gridLocation();
        String[] locationString = Board.grid;
        for(int i=0; i<49; i++){
            locations.put(locationString[i],locationValue[i]);
        }
        return locations;
    }

    static double[] nearestGrid(double x, double y){
        double[] nearest = new double[2];
        double min = 65*65*2;
        for(int[] location:gridLocation()){
            double xSquare = (x-location[0])*(x-location[0]);
            double ySquare = (y-location[1])*(y-location[1]);
            if(xSquare+ySquare<min){
                nearest[0] = location[0];
                nearest[1] = location[1];
                min = xSquare+ySquare;
            }
        }
        if(min>=65*65*2){
            nearest[0] = x;
            nearest[1] = y;
        }
        return nearest;
    }

    static int[][] gridLocation(){
        int[][] list = new int[49][2];
        int count = 0;
        for(int i=0; i<7; i++){
            for(int m=0; m<7; m++){
                list[count][0]=150+m*65;
                list[count][1]=100+i*65;
                count++;
            }
        }
        return list;
    }

    static class Grid extends Rectangle {
        double x,y;
        double size;
        public Grid(double x, double y, double size){
            this.x=x;
            this.y=y;
            this.size=size;
            this.setWidth(size);
            this.setHeight(size);
            this.setLayoutX(x);
            this.setLayoutY(y);
            this.setFill(BEIGE);
            this.setStroke(BLACK);
        }
    }

}
