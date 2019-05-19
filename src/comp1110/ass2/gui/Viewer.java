package comp1110.ass2.gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import comp1110.ass2.RailroadInk;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import static javafx.scene.paint.Color.*;

/**
 * A very simple viewer for tile placements in the Railroad Ink game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various tile placements.
 */
//Written by Xinyu Kang
public class Viewer extends Application {

    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 640;
    private static final String URI_BASE = "assets/";
    private final Group root = new Group();
    private final Group begin = new Group();
    private final Group board = new Group();
    private final Group controls = new Group();
    private final Group special = new Group();
    private final Group placementGroup =new Group();
    private final Group dice =new Group();
    private final Group roundButton = new Group();
    private final Group tile = new Group();
    private final Group alert = new Group();
    private final Group stringShow = new Group();
    private final Group round = new Group();
    private int roundNum = 1;
    String boardString = "";
    private ArrayList<DraggableTile> moveTileRecord = new ArrayList<>();
    private DraggableTile tileS0 = new DraggableTile("S0",700,150,this);
    private DraggableTile tileS1 = new DraggableTile("S1",700+75,150,this);
    private DraggableTile tileS2 = new DraggableTile("S2",700+75*2,150,this);
    private DraggableTile tileS3 = new DraggableTile("S3",700,150+75,this);
    private DraggableTile tileS4 = new DraggableTile("S4",700+75,150+75,this);
    private DraggableTile tileS5 = new DraggableTile("S5",700+75*2,150+75,this);
    private ArrayList<DraggableTile> availableSpecial = new ArrayList<>();
    private Group specialTiles = new Group();
    private int remainingSpecial = 6;
    private int countDice = 0;
    private DraggableTile tileMoved;
    private DraggableTile specialMoved = null;
    private Group specialPictures = new Group();

    private ArrayList<ImageView> specialPics(){
        ArrayList<ImageView> toReturn = new ArrayList<>();
        DraggableTile[] a = {tileS0, tileS1, tileS2, tileS3, tileS4, tileS5};
        for(DraggableTile tile:a){
            int i = Integer.parseInt(tile.tileName.substring(1,2));
            ImageView imageView = new ImageView(Viewer.class.getResource(URI_BASE+tile.tileName+".png").toString());
            imageView.setFitHeight(65);
            imageView.setFitWidth(65);
            if(i<3){
                imageView.setLayoutX(700+i*75);
                imageView.setLayoutY(150);
            }else {
                imageView.setLayoutX(700+(i-3)*75);
                imageView.setLayoutY(150+75);
            }
            imageView.setOnMouseClicked(e -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("This special tile is locked. ");
                alert.showAndWait();
            });
            toReturn.add(imageView);
        }
        return toReturn;
    }

    private ArrayList<ImageView> specialImages(DraggableTile tileClicked){
        ArrayList<ImageView> toReturn = new ArrayList<>();
        for(DraggableTile tile:availableSpecial){
            if(!tile.tileName.equals(tileClicked.tileName)){
                int i = Integer.parseInt(tile.tileName.substring(1,2));
                ImageView imageView = new ImageView(Viewer.class.getResource(URI_BASE+tile.tileName+".png").toString());
                imageView.setFitHeight(65);
                imageView.setFitWidth(65);
                if(i<3){
                    imageView.setLayoutX(700+i*75);
                    imageView.setLayoutY(150);
                }else {
                    imageView.setLayoutX(700+(i-3)*75);
                    imageView.setLayoutY(150+75);
                }
                imageView.setOnMouseClicked(e -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("This special tile is locked. ");
                    alert.showAndWait();
                });
                toReturn.add(imageView);
            }
        }
        return toReturn;
    }

    private void finishGame(){
        special.getChildren().clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("You have finished the game!!");
        alert.setHeaderText("Your basic score is:  "+RailroadInk.getBasicScore(boardString));
        alert.showAndWait();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Railroad Ink");
        Scene scene = new Scene(root, VIEWER_WIDTH,VIEWER_HEIGHT, Color.BEIGE);
        root.getChildren().add(board);
        root.getChildren().add(controls);
        root.getChildren().add(placementGroup);
        root.getChildren().add(special);
        root.getChildren().add(round);
        root.getChildren().add(roundButton);
        root.getChildren().add(tile);
        root.getChildren().add(alert);
        root.getChildren().add(dice);
        root.getChildren().add(begin);
        root.getChildren().add(stringShow);
        //root.getChildren().add(specialTiles);
        displayBeginPage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement) {
        if(!RailroadInk.isBoardStringWellFormed(placement)){
            throw new IllegalArgumentException("Illegal Board String");
        }
       for(int i=0; i<placement.length(); i+=5){

           String tile = placement.substring(i,i+2);
           int rowPosition = (placement.substring(i+2,i+3).hashCode()-65)*65+100;
           int colPosition = Integer.parseInt(placement.substring(i+3,i+4))*65+150;
           int orientation = Integer.parseInt(placement.substring(i+4,i+5));
           int angle;
           if(orientation<4){
               angle = orientation*90;
           }else {
               angle = (orientation-4)*90;
           }

           ImageView img = new ImageView();
           img.setImage(new Image(Viewer.class.getResource(URI_BASE+tile+".png").toString()));
           img.setRotate(angle);
           if(orientation>=4){
               img.setScaleX(-1);
           }
           img.setFitWidth(65);
           img.setFitHeight(65);
           img.setPreserveRatio(true);
           img.setSmooth(true);
           HBox hBox = new HBox();
           hBox.getChildren().add(img);
           placementGroup.getChildren().add(hBox);
           hBox.setLayoutX(colPosition);
           hBox.setLayoutY(rowPosition);
       }
    }



    private void startRound(){
        if(roundNum==8){
            finishGame();
        }else {
            ImageView imageView = new ImageView();
            Image theRound = new Image(Viewer.class.getResource(URI_BASE+"round"+roundNum+".png").toString());
            //round.getChildren().add(theRound);
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

            Button roundReminder = new Button("Round: "+roundNum);
            roundReminder.setLayoutX(650);
            roundReminder.setLayoutY(20);
            Button boardStringViewer = new Button("Click to view boardString");
            boardStringViewer.setLayoutX(810);
            boardStringViewer.setLayoutY(20);
            boardStringViewer.setOnMousePressed(e -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(boardString+",   score: "+RailroadInk.getBasicScore(boardString));
                alert.showAndWait();
            });
            roundButton.getChildren().add(roundReminder);
            roundButton.getChildren().add(boardStringViewer);
            countDice=0;
        }
    }

    void displayRollingArea(){
        ImageView lockedSpecial = new ImageView(Viewer.class.getResource(URI_BASE+"lockedSpecial.png").toString());
        lockedSpecial.setFitWidth(215);
        lockedSpecial.setFitHeight(140);
        lockedSpecial.setLayoutX(700);
        lockedSpecial.setLayoutY(150);

        //special.getChildren().add(lockedSpecial);
        for(ImageView specialPic:specialPics()){
            specialPictures.getChildren().add(specialPic);
        }
        special.getChildren().add(specialPictures);

        Rectangle rectangle1 = new Rectangle();
        rectangle1.setHeight(10);
        rectangle1.setWidth(75*4+10);
        rectangle1.setX(700-10);
        rectangle1.setY(400-10);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setHeight(10);
        rectangle2.setWidth(75*4+10);
        rectangle2.setX(700-10);
        rectangle2.setY(400+65);

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setHeight(65+20);
        rectangle3.setWidth(10);
        rectangle3.setX(700-10);
        rectangle3.setY(400-10);

        Rectangle rectangle4 = new Rectangle();
        rectangle4.setHeight(65+20);
        rectangle4.setWidth(10);
        rectangle4.setX(700+65);
        rectangle4.setY(400-10);

        Rectangle rectangle5 = new Rectangle();
        rectangle5.setHeight(65+20);
        rectangle5.setWidth(10);
        rectangle5.setX(700+75*2-10);
        rectangle5.setY(400-10);

        Rectangle rectangle6 = new Rectangle();
        rectangle6.setHeight(65+20);
        rectangle6.setWidth(10);
        rectangle6.setX(700+75*3-10);
        rectangle6.setY(400-10);

        Rectangle rectangle7 = new Rectangle();
        rectangle7.setHeight(65+20);
        rectangle7.setWidth(10);
        rectangle7.setX(700+75*4-10);
        rectangle7.setY(400-10);

        special.getChildren().addAll(rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7);

        ImageView imageView0 = new ImageView(Viewer.class.getResource(URI_BASE+"dieA.gif").toString());
        ImageView imageView1 = new ImageView(Viewer.class.getResource(URI_BASE+"dieA.gif").toString());
        ImageView imageView2 = new ImageView(Viewer.class.getResource(URI_BASE+"dieA.gif").toString());
        ImageView imageView3 = new ImageView(Viewer.class.getResource(URI_BASE+"dieA.gif").toString());
        ImageView[] diceRolling = new ImageView[4];
        diceRolling[0] = imageView0;
        diceRolling[1] = imageView1;
        diceRolling[2] = imageView2;
        diceRolling[3] = imageView3;

        imageView0.setLayoutX(700);
        imageView0.setLayoutY(400);
        imageView0.setFitWidth(65);
        imageView0.setFitHeight(65);
        imageView0.setScaleX(-1);
        imageView1.setLayoutX(700+75);
        imageView1.setLayoutY(400);
        imageView1.setFitWidth(65);
        imageView1.setFitHeight(65);
        imageView1.setScaleY(-1);
        imageView2.setLayoutX(700+75*2);
        imageView2.setLayoutY(400);
        imageView2.setFitWidth(65);
        imageView2.setFitHeight(65);
        imageView2.setScaleX(-1);
        imageView2.setScaleY(-1);
        imageView3.setLayoutX(700+75*3+5);
        imageView3.setLayoutY(400+5);
        imageView3.setFitWidth(55);
        imageView3.setFitHeight(55);

        Button roll = new Button("Roll");
        roll.setLayoutX(750);
        roll.setLayoutY(500);
        Button stop = new Button("Stop");
        stop.setLayoutX(750+75*2);
        stop.setLayoutY(500);
        roll.setOnMousePressed(event -> {
            dice.getChildren().add(diceRolling[countDice]);
        });
        stop.setOnMousePressed(event -> {
            dice.getChildren().clear();
            String diceResult = RailroadInk.generateDiceRoll();
            tileMoved = new DraggableTile(diceResult.substring(countDice*2,countDice*2+2),700+countDice*75,400,this);
            tile.getChildren().add(tileMoved);
            countDice++;

            Button useSpecial = new Button("Change to use special tiles");
            useSpecial.setLayoutX(700+150);
            useSpecial.setLayoutY(560);
            useSpecial.setOnMousePressed(e -> {
                tile.getChildren().remove(tileMoved);
                special.getChildren().add(specialTiles);
                special.getChildren().remove(specialPictures);

            });

            Button makePlacement = new Button("Make Placement ! ");
            makePlacement.setLayoutX(700);
            makePlacement.setLayoutY(560);
            makePlacement.setOnMousePressed(e ->{   //现在不会出现两个special tile 了， 完了再简化一下这里
                String placementString;

                if(specialMoved==null){
                    placementString = tileMoved.getPlacementString();
                    if(RailroadInk.isValidPlacementSequence(boardString+placementString)){
                        makePlacement(placementString);
                        tile.getChildren().remove(tileMoved);
                        special.getChildren().add(roll);
                        special.getChildren().add(stop);
                        board.getChildren().remove(useSpecial);
                        board.getChildren().remove(makePlacement);
                        boardString=boardString+placementString;
                        specialMoved=null;
                        if(countDice==4){
                            roundNum++;
                            startRound();
                        }
                    }else {
                        tileMoved.alertError();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.headerTextProperty().set("Invalid Placement!!");
                        alert.showAndWait();
                    }
                }else {
                    placementString = specialMoved.getPlacementString();
                    if(RailroadInk.isValidPlacementSequence(boardString+placementString)){
                        makePlacement(placementString);
                        availableSpecial.remove(specialMoved);
                        specialTiles.getChildren().remove(specialMoved);
                        special.getChildren().add(roll);
                        special.getChildren().add(stop);
                        board.getChildren().remove(useSpecial);
                        board.getChildren().remove(makePlacement);
                        boardString=boardString+placementString;
                        specialMoved=null;
                        remainingSpecial--;
                        if(remainingSpecial<=3){
                            specialTiles.getChildren().clear();
                            specialPictures.getChildren().clear();
                            availableSpecial.clear();
                        }
                        if(countDice==4){
                            roundNum++;
                            startRound();
                        }
                    }else {
                        DraggableTile a = specialMoved;
                        special.getChildren().remove(specialPictures);
                        special.getChildren().remove(specialMoved);
                        specialTiles.getChildren().add(a);
                        a.backToOrigin();
                        special.getChildren().add(specialTiles);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.headerTextProperty().set("Invalid Special Placement!!");
                        alert.showAndWait();
                        specialMoved=null;
                    }

                }
            });

            board.getChildren().add(makePlacement);
            special.getChildren().remove(roll);
            special.getChildren().remove(stop);
            if(remainingSpecial>3){
                board.getChildren().add(useSpecial);
            }
        });
        special.getChildren().addAll(roll,stop);
    }


    void displaySpecials(){
        availableSpecial.add(tileS0);
        availableSpecial.add(tileS1);
        availableSpecial.add(tileS2);
        availableSpecial.add(tileS3);
        availableSpecial.add(tileS4);
        availableSpecial.add(tileS5);

        specialTiles.getChildren().add(tileS0);
        specialTiles.getChildren().add(tileS1);
        specialTiles.getChildren().add(tileS2);
        specialTiles.getChildren().add(tileS3);
        specialTiles.getChildren().add(tileS4);
        specialTiles.getChildren().add(tileS5);
    }

    void displayBeginPage(){
        Button start  = new Button("Start Game");
        start.setLayoutX(VIEWER_WIDTH/2-100);
        start.setLayoutY(VIEWER_HEIGHT/2);
        start.setOnMousePressed(event ->{
            displayRollingArea();
            displayBoard();
            displaySpecials();
            begin.getChildren().clear();
            startRound();
        });
        Button view = new Button("Placement Viewer");
        view.setLayoutX(VIEWER_WIDTH/2+100);
        view.setLayoutY(VIEWER_HEIGHT/2);
        view.setOnMousePressed(event ->{
            inputArea();
            displayBoard();
            begin.getChildren().clear();
        });

        begin.getChildren().add(start);
        begin.getChildren().add(view);

    }


    class Tile extends ImageView {
        double x,y;
        String tileName;
        Viewer viewer;
        Tile(String tileName, double x, double y){
            this.x = x;
            this.y = y;
            this.tileName=tileName;
            this.setImage(new Image(Viewer.class.getResource(URI_BASE+tileName+".png").toString()));
            this.setFitHeight(65);
            this.setFitWidth(65);
            this.setLayoutX(x);
            this.setLayoutY(y);
            this.toFront();

        }
    }

    class DraggableTile extends Tile {
        private double x,y;
        private double mouseX, mouseY;
        private Viewer viewer;
        private int rotate=0;
        String gridName = "__";

        void lockOthers(){
            if(this.tileName.substring(0,1).equals("S")){
                specialMoved=this;
                special.getChildren().remove(specialTiles);
                special.getChildren().add(this);
                specialPictures.getChildren().clear();
                for(ImageView imageView:specialImages(this)){
                    specialPictures.getChildren().add(imageView);
                }
                special.getChildren().add(specialPictures);

            }
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

            alert.getChildren().addAll(up,down,left,right);
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
            specialMoved=null;
        }

        String getPlacementString(){
            return tileName+gridName+rotate/90;
        }

        DraggableTile(String tileName, double x, double y, Viewer viewer){
            super(tileName,x,y);
            this.x = x;
            this.y = y;
            this.viewer=viewer;

            this.setOnScroll(event -> {
                this.rotate();
                //recordSpecial();
            });
            this.setOnMousePressed(event -> {
                this.mouseX = event.getSceneX();
                this.mouseY = event.getSceneY();
                this.x = super.getLayoutX();
                this.y = super.getLayoutY();
                this.toFront();
                stringShow.getChildren().clear();
                alert.getChildren().clear();
                lockOthers();
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
                //recordSpecial();
            });
        }
    }

    double[] nearestGrid(double x, double y){
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

    public int[][] gridLocation(){
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

    public HashMap<String,int[]> theBoardGrid(){
        HashMap<String,int[]> locations = new HashMap<>();
        int[][] locationValue = gridLocation();
        String[] locationString = Board.grid;
        for(int i=0; i<49; i++){
            locations.put(locationString[i],locationValue[i]);
        }
        return locations;
    }

    class Grid extends Rectangle {
        double x,y;
        double size;
        Grid(double x, double y, double size){
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

    private void displayBoard() {
        for(int i=0; i<7; i++){
            for(int m=0; m<7; m++){
                board.getChildren().add(new Grid(150+i*65,100+m*65,65));
            }
        }

        Button back = new Button("Back");
        back.setLayoutX(20);
        back.setLayoutY(20);
        back.setOnMousePressed(e -> {
            controls.getChildren().clear();
            placementGroup.getChildren().clear();
            board.getChildren().clear();
            special.getChildren().clear();
            dice.getChildren().clear();
            stringShow.getChildren().clear();
            roundButton.getChildren().clear();
            tile.getChildren().clear();
            alert.getChildren().clear();
            boardString = "";
            availableSpecial.clear();
            remainingSpecial=6;
            moveTileRecord.clear();
            //specialTiles.getChildren().clear();

            displayBeginPage();
        });
        board.getChildren().add(back);

        ImageView exitB0 = new ImageView();
        exitB0.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitB0.setFitHeight(65);
        exitB0.setFitWidth(65);
        exitB0.setLayoutX(150-65);
        exitB0.setLayoutY(100+65);
        exitB0.setRotate(270);
        board.getChildren().add(exitB0);

        ImageView exitD0 = new ImageView();
        exitD0.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitD0.setFitHeight(65);
        exitD0.setFitWidth(65);
        exitD0.setLayoutX(150-65);
        exitD0.setLayoutY(100+65*3);
        exitD0.setRotate(270);
        board.getChildren().add(exitD0);

        ImageView exitF0 = new ImageView();
        exitF0.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitF0.setFitHeight(65);
        exitF0.setFitWidth(65);
        exitF0.setLayoutX(150-65);
        exitF0.setLayoutY(100+65*5);
        exitF0.setRotate(270);
        board.getChildren().add(exitF0);

        ImageView exitB6 = new ImageView();
        exitB6.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitB6.setFitHeight(65);
        exitB6.setFitWidth(65);
        exitB6.setLayoutX(150+65*7);
        exitB6.setLayoutY(100+65);
        exitB6.setRotate(90);
        board.getChildren().add(exitB6);

        ImageView exitD6 = new ImageView();
        exitD6.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitD6.setFitHeight(65);
        exitD6.setFitWidth(65);
        exitD6.setLayoutX(150+65*7);
        exitD6.setLayoutY(100+65*3);
        exitD6.setRotate(90);
        board.getChildren().add(exitD6);

        ImageView exitF6 = new ImageView();
        exitF6.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitF6.setFitHeight(65);
        exitF6.setFitWidth(65);
        exitF6.setLayoutX(150+65*7);
        exitF6.setLayoutY(100+65*5);
        exitF6.setRotate(90);
        board.getChildren().add(exitF6);

        ImageView exitA1 = new ImageView();
        exitA1.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitA1.setFitHeight(65);
        exitA1.setFitWidth(65);
        exitA1.setLayoutX(150+65);
        exitA1.setLayoutY(100-65);
        board.getChildren().add(exitA1);

        ImageView exitA3 = new ImageView();
        exitA3.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitA3.setFitHeight(65);
        exitA3.setFitWidth(65);
        exitA3.setLayoutX(150+65*3);
        exitA3.setLayoutY(100-65);
        board.getChildren().add(exitA3);

        ImageView exitA5 = new ImageView();
        exitA5.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitA5.setFitHeight(65);
        exitA5.setFitWidth(65);
        exitA5.setLayoutX(150+65*5);
        exitA5.setLayoutY(100-65);
        board.getChildren().add(exitA5);

        ImageView exitG1 = new ImageView();
        exitG1.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitG1.setRotate(180);
        exitG1.setFitHeight(65);
        exitG1.setFitWidth(65);
        exitG1.setLayoutX(150+65);
        exitG1.setLayoutY(100+65*7);
        board.getChildren().add(exitG1);

        ImageView exitG3 = new ImageView();
        exitG3.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitG3.setRotate(180);
        exitG3.setFitHeight(65);
        exitG3.setFitWidth(65);
        exitG3.setLayoutX(150+65*3);
        exitG3.setLayoutY(100+65*7);
        board.getChildren().add(exitG3);

        ImageView exitG5 = new ImageView();
        exitG5.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitG5.setRotate(180);
        exitG5.setFitHeight(65);
        exitG5.setFitWidth(65);
        exitG5.setLayoutX(150+65*5);
        exitG5.setLayoutY(100+65*7);
        board.getChildren().add(exitG5);

    }

    /*
    ImageView diceBRolling(ImageView imageView){
        ArrayList<Image> tileB = new ArrayList<>();
        tileB.add(new Image(Viewer.class.getResource(URI_BASE+"B0.png").toString()));
        tileB.add(new Image(Viewer.class.getResource(URI_BASE+"B1.png").toString()));
        tileB.add(new Image(Viewer.class.getResource(URI_BASE+"B2.png").toString()));
        Collections.shuffle(tileB);
        imageIterator = tileB.iterator();
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> {
                            if(imageIterator.hasNext()) {
                                imageView.setImage(imageIterator.next());
                            }
                        }
                ),
                new KeyFrame(Duration.millis(100)));
        timeline.setOnFinished(event -> {
            Collections.shuffle(tileB);
            imageIterator = tileB.iterator();
            timeline.playFromStart();
        });
        timeline.play();
        imageView.setFitHeight(65);
        imageView.setFitWidth(65);
        return imageView;
    }

    ImageView diceARolling(ImageView imageView){
        ArrayList<Image> tileA = new ArrayList<>();
        tileA.add(new Image(Viewer.class.getResource(URI_BASE+"A0.png").toString()));
        tileA.add(new Image(Viewer.class.getResource(URI_BASE+"A1.png").toString()));
        tileA.add(new Image(Viewer.class.getResource(URI_BASE+"A2.png").toString()));
        tileA.add(new Image(Viewer.class.getResource(URI_BASE+"A3.png").toString()));
        tileA.add(new Image(Viewer.class.getResource(URI_BASE+"A4.png").toString()));
        tileA.add(new Image(Viewer.class.getResource(URI_BASE+"A5.png").toString()));
        Collections.shuffle(tileA);

        imageIterator= tileA.iterator();
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> {
                            if(imageIterator.hasNext()){
                                imageView.setImage(imageIterator.next());
                            }
                        }
                ),
                new KeyFrame(Duration.millis(100)));
        //timeline.setCycleCount(tileA.size());
        timeline.setOnFinished(event -> {
            Collections.shuffle(tileA);
            imageIterator = tileA.iterator();
            timeline.playFromStart();
        });
        timeline.play();
        imageView.setFitHeight(65);
        imageView.setFitWidth(65);
        return imageView;
       }
       */
    /**
     * Create a basic text field for input and a refresh button.
     */
    private void inputArea() {

        Label label1 = new Label("Placement String:");
        TextField textField = new TextField();
        textField.setPrefWidth(100);
        textField.setPrefColumnCount(3);
        Button button1 = new Button("Make Placement");
        button1.setOnAction(e -> {
            makePlacement(textField.getText());
            textField.clear();
        });
        Button button2 = new Button("Clear");
        button2.setOnAction(e ->{
            placementGroup.getChildren().clear();

        });
        button2.setLayoutX(880);
        button2.setLayoutY(180);


        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button1);
        hb.setSpacing(10);
        hb.setLayoutX(660);
        hb.setLayoutY(150);

        controls.getChildren().add(hb);
        controls.getChildren().add(button2);
    }

    void showPlacementString(String placementString){
        Button toShow = new Button(placementString);
        toShow.setLayoutX(100);
        toShow.setLayoutY(100);
        stringShow.getChildren().add(toShow);
    }

}
