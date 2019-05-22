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
    private static Group specialImagesComp = new Group();  //special tile images   comp
    private static int countRound = 0;
    private static int countDice = 0;
    private static Group grids = new Group();   //棋盘和返回键, 名字和基础分
    private static int basicScorePlayer = 0;
    private static int basicScoreComp = 0;
    private static DraggableTile tileGet = null;
    private static DraggableTile specialUsing = null;
    private static Group specialTiles = new Group();
    private static Tile tileS0;
    private static Tile tileS1;
    private static Tile tileS2;
    private static Tile tileS3;
    private static Tile tileS4;
    private static Tile tileS5;
    private static Group alert = new Group();
    public static Group round = new Group();
    private static int specialRemaining = 6;


    public static void mulStart(){
        askPlayerName();
        initBoard();
        nameAndScore();
        initSpecial();
        initDiceAndButtons();
        rootMul.getChildren().add(round);
        root.getChildren().add(rootMul);

        nextRound();
    }

    public static void nextRound(){
        if(countRound==7){
            finishGame();
        }else {
            countRound++;
            ImageView imageView = new ImageView();
            Image theRound = new Image(Viewer.class.getResource(URI_BASE+"round"+countRound+".png").toString());
            Timeline timeline = new Timeline(   new KeyFrame(
                    Duration.ZERO,
                    e -> {imageView.setImage(theRound);
                        imageView.setFitHeight(300);
                        imageView.setFitWidth(700);
                        imageView.setLayoutX(150);
                        imageView.setLayoutY(110);}
            ),
                    new KeyFrame(Duration.millis(1000)));
            timeline.setOnFinished(e -> round.getChildren().clear());
            timeline.play();
            round.getChildren().add(imageView);

            Button roundReminder = new Button("Round: "+countRound);
            roundReminder.setLayoutX(475);
            roundReminder.setLayoutY(100);
            board.getChildren().add(roundReminder);

            /*
            Text score1 = new Text();
            Text score2 = new Text();
            score1.setText("Basic Score: "+basicScorePlayer);
            score2.setText("Basic Score: "+basicScoreComp);
            score1.setLayoutX(320);
            score1.setLayoutY(45);
            score2.setLayoutX(870);
            score2.setLayoutY(45);
            board.getChildren().addAll(score1,score2);
             */
        }

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
                tileGet = new DraggableTile(tileName,495,155);
                board.getChildren().add(tileGet);
                //String compPlaceSqu = RailroadInk.generateMove(boardStringComp,diceResult);
                //String compPlacement = compPlaceSqu.substring(countDice*5,countDice*5+5);

                Button useSpecial = new Button("Use special tile");
                useSpecial.setLayoutX(475);
                useSpecial.setLayoutY(330);
                useSpecial.setOnMousePressed(event -> {
                    board.getChildren().remove(useSpecial);
                    board.getChildren().remove(tileGet);
                    tileGet=null;
                    specials.getChildren().remove(specialImages);
                    specials.getChildren().add(specialTiles);
                });

                Button make = new Button("make placement");
                make.setLayoutX(475);
                make.setLayoutY(280);
                make.setOnMousePressed(event -> {
                    String placement="";
                    if(specialUsing==null){
                        placement = tileGet.getPlacementString();
                        if(RailroadInk.isValidPlacementSequence(boardStringPlayer+placement) && !Board.isOverlap(placement,boardStringPlayer)){
                            boardStringPlayer=boardStringPlayer+placement;
                            System.out.println(boardStringPlayer);
                            board.getChildren().add(new Tile(tileGet.tileName,tileGet.getLayoutX(),tileGet.getLayoutY(),tileGet.rotate));
                            board.getChildren().remove(tileGet);
                            tileGet=null;
                            board.getChildren().remove(make);
                            board.getChildren().remove(useSpecial);
                            if(countRound<7){
                                board.getChildren().add(roll);
                            }else if (countRound==7 && countDice<3){
                                board.getChildren().add(roll);
                            }
                            if(countDice<3){
                                countDice++;
                            }else {
                                countDice=0;
                                nextRound();
                            }
                            //basicScorePlayer=RailroadInk.getBasicScore(boardStringPlayer);
                        }else {
                            tileGet.alertError();
                        }
                    }else {
                        placement = specialUsing.getPlacementString();
                        if(RailroadInk.isValidPlacementSequence(boardStringPlayer+placement) && !Board.isOverlap(placement,boardStringPlayer)){
                            boardStringPlayer=boardStringPlayer+placement;
                            System.out.println(boardStringPlayer);
                            board.getChildren().add(new Tile(specialUsing.tileName,specialUsing.getLayoutX(),specialUsing.getLayoutY(),specialUsing.rotate));
                            board.getChildren().remove(specialUsing);
                            specialUsing=null;
                            board.getChildren().remove(make);
                            board.getChildren().remove(useSpecial);
                            specialRemaining--;
                            if(countRound<7){
                                board.getChildren().add(roll);
                            }else if (countRound==7 && countDice<3){
                                board.getChildren().add(roll);
                            }
                            if(countDice<3){
                                countDice++;
                            }else {
                                countDice=0;
                                nextRound();
                            }
                            //basicScorePlayer=RailroadInk.getBasicScore(boardStringPlayer);
                        }else {
                            specialUsing.alertError();
                        }
                    }
                });
                board.getChildren().add(make);
                if(specialRemaining>3){
                    board.getChildren().add(useSpecial);
                }
            });

        });
        board.getChildren().add(roll);
    }

    private static void finishGame(){
        int playerScore = RailroadInk.getBasicScore(boardStringPlayer);
        int compScore = RailroadInk.getBasicScore(boardStringComp);
        Image image;
        if(playerScore>compScore){
            image = new Image(Viewer.class.getResource(URI_BASE+"win.png").toString());
        }else if(playerScore==compScore){
            image = new Image(Viewer.class.getResource(URI_BASE+"even.png").toString());
        }else {
            image = new Image(Viewer.class.getResource(URI_BASE+"lose.png").toString());
        }
        ImageView imageView = new ImageView();
        Timeline timeline = new Timeline(   new KeyFrame(
                Duration.ZERO,
                e -> {imageView.setImage(image);
                    imageView.setFitHeight(300);
                    imageView.setFitWidth(700);
                    imageView.setLayoutX(150);
                    imageView.setLayoutY(110);}
        ),
                new KeyFrame(Duration.millis(2000)));
        timeline.setOnFinished(e -> board.getChildren().remove(imageView));
        timeline.play();
        board.getChildren().add(imageView);

        Text a = new Text();
        a.setText(yourName+" : "+playerScore);
        a.setLayoutX(490);
        a.setLayoutY(450);
        Text b = new Text();
        b.setText("Computer : "+compScore);
        b.setLayoutX(490);
        b.setLayoutY(490);
        board.getChildren().addAll(a,b);


    }

    private static void initBoard(){   //棋盘和 back按钮  还有出口
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

        Tile a1  = new Tile("HighExit",70-50,150+50*2,270);
        Tile a2  = new Tile("HighExit",620-50,150+50*2,270);
        Tile b1  = new Tile("HighExit",70+50*7,150+50*2,90);
        Tile b2  = new Tile("HighExit",620+50*7,150+50*2,90);
        Tile c1  = new Tile("HighExit",70+50,150-50*2);
        Tile c2  = new Tile("HighExit",620+50,150-50*2);
        Tile d1 = new Tile("HighExit",70+50*5,150-50*2);
        Tile d2 = new Tile("HighExit",620+50*5,150-50*2);
        Tile e1 = new Tile("HighExit",70+50,150+50*6,180);
        Tile e2 = new Tile("HighExit",620+50,150+50*6,180);
        Tile f1 = new Tile("HighExit",70+50*5,150+50*6,180);
        Tile f2 = new Tile("HighExit",620+50*5,150+50*6,180);
        Tile g1 = new Tile("RailExit",70-50,150,270);
        Tile g2 = new Tile("RailExit",620-50,150,270);
        Tile h1 = new Tile("RailExit",70+50*7,150,90);
        Tile h2 = new Tile("RailExit",620+50*7,150,90);
        Tile i1 = new Tile("RailExit",70-50,150+50*4,270);
        Tile i2 = new Tile("RailExit",620-50,150+50*4,270);
        Tile j1 = new Tile("RailExit",70+50*7,150+50*4,90);
        Tile j2 = new Tile("RailExit",620+50*7,150+50*4,90);
        Tile k1 = new Tile("RailExit",70+50*3,150-50*2);
        Tile k2 = new Tile("RailExit",620+50*3,150-50*2);
        Tile l1 = new Tile("RailExit",70+50*3,150+50*6,180);
        Tile l2 = new Tile("RailExit",620+50*3,150+50*6,180);
        grids.getChildren().addAll(a1,a2,b1,b2,c1,c2,d1,d2,e1,e2,f1,f2,g1,g2,h1,h2,i1,i2,j1,j2,k1,k2,l1,l2);

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
        back.setLayoutX(10);
        back.setLayoutY(10);
        back.setOnMousePressed(e -> {    //所有group都要清空， 数字string都要还原
            rootMul.getChildren().clear();
            board.getChildren().clear();
            grids.getChildren().clear();
            specials.getChildren().clear();
            specialImages.getChildren().clear();
            specialImagesComp.getChildren().clear();
            round.getChildren().clear();
            yourName="";
            boardStringPlayer="";
            boardStringComp="";
            countRound=0;
            countDice=0;
            basicScoreComp=0;
            basicScorePlayer=0;

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
        name1.setText(yourName);
        name2.setText("Computer");
        name1.setLayoutX(70);
        name1.setLayoutY(45);
        name2.setLayoutX(620);
        name2.setLayoutY(45);
        grids.getChildren().addAll(name1,name2);
    }

    public static void initSpecial(){
        for(int i = 0; i<6; i++){
            String tileName = "S"+i;
            specialImagesComp.getChildren().add(new Tile(tileName,620+i*60,530));
            specialTiles.getChildren().add(new DraggableTile(tileName,70+i*60,530));
        }
        tileS0=new Tile("S0",70,530);
        tileS1=new Tile("S1",70+60,530);
        tileS2=new Tile("S2",70+60*2,530);
        tileS3=new Tile("S3",70+60*3,530);
        tileS4=new Tile("S4",70+60*4,530);
        tileS5=new Tile("S5",70+60*5,530);

        specialImages.getChildren().addAll(tileS0,tileS1,tileS2,tileS3,tileS4,tileS5);
        specials.getChildren().addAll(specialImages,specialImagesComp);
        rootMul.getChildren().add(specials);
    }



    // -----分界线----------
    //后面的都要改

    static class Tile extends ImageView {
        double x,y;
        String tileName;
        MultiplePlayers multiplePlayers;
        int rotate;
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
        Tile(String tileName, double x, double y,int rotate){
            this.x = x;
            this.y = y;
            this.tileName=tileName;
            this.rotate=rotate;
            this.setImage(new Image(Viewer.class.getResource(URI_BASE+tileName+".png").toString()));
            this.setFitHeight(50);
            this.setFitWidth(50);
            this.setLayoutX(x);
            this.setLayoutY(y);
            this.toFront();
            if(rotate<=270){
                this.setRotate(rotate);
            }else{
                this.setRotate(0);
                this.setScaleX(-1);
                this.setRotate(rotate-360);
            }
        }
    }


    static class DraggableTile extends Tile {
        private double x,y;
        private double mouseX, mouseY;
        private int rotate=0;
        String gridName = "__";

        DraggableTile(String tileName, double x, double y){
            super(tileName,x,y);
            this.x = x;
            this.y = y;

            this.setOnScroll(event -> {
                this.rotate();
            });
            this.setOnMousePressed(event -> {
                this.mouseX = event.getSceneX();
                this.mouseY = event.getSceneY();
                this.x = super.getLayoutX();
                this.y = super.getLayoutY();
                this.toFront();
                alert.getChildren().clear();
                board.getChildren().remove(alert);
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
                double min = 50*50*2;

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
                if(min<50*50*2){
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
               if(specialUsing==null){
                   switch (this.tileName.charAt(1)){
                       case '0':
                           specialImages.getChildren().remove(tileS0);
                           break;
                       case '1':
                           specialImages.getChildren().remove(tileS1);
                           break;
                       case '2':
                           specialImages.getChildren().remove(tileS2);
                           break;
                       case '3':
                           specialImages.getChildren().remove(tileS3);
                           break;
                       case '4':
                           specialImages.getChildren().remove(tileS4);
                           break;
                       case '5':
                           specialImages.getChildren().remove(tileS5);
                           break;
                   }
                   specialUsing=this;
                   specials.getChildren().remove(specialTiles);
                   specials.getChildren().add(specialImages);
                   specials.getChildren().add(specialUsing);
               }
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
            up.setWidth(60);
            up.setHeight(5);
            up.setX(this.getLayoutX()-5);
            up.setY(this.getLayoutY()-5);
            down.setWidth(60);
            down.setHeight(5);
            down.setX(this.getLayoutX()-5);
            down.setY(this.getLayoutY()+50);
            left.setWidth(5);
            left.setHeight(60);
            left.setX(this.getLayoutX()-5);
            left.setY(this.getLayoutY()-5);
            right.setWidth(5);
            right.setHeight(60);
            right.setX(this.getLayoutX()+50);
            right.setY(this.getLayoutY()-5);

            alert.getChildren().addAll(up,down,left,right);
            board.getChildren().add(alert);
        }

        void backToOrigin(){  //can only use on special tiles
            int i = Integer.parseInt(this.tileName.substring(1,2));
            this.setLayoutX(70+i*60);
            this.setLayoutY(530);
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
        double min = 50*50*2;
        for(int[] location:gridLocation()){
            double xSquare = (x-location[0])*(x-location[0]);
            double ySquare = (y-location[1])*(y-location[1]);
            if(xSquare+ySquare<min){
                nearest[0] = location[0];
                nearest[1] = location[1];
                min = xSquare+ySquare;
            }
        }
        if(min>=50*50*2){
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
                list[count][0]=70+m*50;
                list[count][1]=100+i*50;
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
