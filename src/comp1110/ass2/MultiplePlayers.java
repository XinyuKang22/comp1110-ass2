package comp1110.ass2;

import comp1110.ass2.gui.Board;
import comp1110.ass2.gui.Viewer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;
import static javafx.scene.paint.Color.*;


/**
 * @author Xinyu Kang
 */
public class MultiplePlayers extends Viewer{

    private static final String URI_BASE = "assets/";
    private static Group rootMul = new Group();
    private static Group board = new Group();
    private static String yourName="";
    private static String boardStringPlayer = "";
    private static String boardStringComp = "";
    private static Group specials = new Group(); //draggable special tiles for player
    private static Group specialImages = new Group();  //special tile images for player
    private static Group specialImagesComp = new Group();  //special tile images  for comp
    private static int countRound = 0;
    private static int countDice = 0;
    private static Group grids = new Group();
    private static int basicScorePlayer = 0;
    private static int basicScoreComp = 0;
    private static DraggableTile tileUsing = null;  //cache of normal tile using
    private static DraggableTile specialUsing = null; //cache of special tile using
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
    private static String diceResult = "";
    private static String compSqu = "";
    private static DraggableTile firstNormal;
    private static DraggableTile secondNormal;
    private static DraggableTile thirdNormal;
    private static DraggableTile fourthNormal;
    private static Tile firstImage;
    private static Tile secondImage;
    private static Tile thirdImage;
    private static Tile fourthImage;
    private static Group normals = new Group();  //each round begins, this group change to contain four normal tiles
    private static Group normalImages = new Group();
    private static ArrayList<DraggableTile> usedTiles = new ArrayList<>();
    private static Button useSpecial = null;
    private static Text currentScorePlayer = null;
    private static Text currentScoreComp = null;

    //start the game
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

    //begin a new round
    public static void nextRound(){
        if(countRound==7){
            finishGame();
        }else {
            countRound++;
            //initialize the dice and update the placements of computer
            diceResult = RailroadInk.generateDiceRoll();
            compSqu = RailroadInk.generateMove(boardStringComp,diceResult);

            //show the round animation
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

            //show round reminder
            Button roundReminder = new Button("Round: "+countRound);
            roundReminder.setLayoutX(475);
            roundReminder.setLayoutY(100);
            board.getChildren().add(roundReminder);
            board.getChildren().add(normals);
        }

    }

    //initialize dices and buttons need during a round
    private static void initDiceAndButtons(){
        //set up the roll button
        Button roll = new Button("Roll dice");
        roll.setLayoutX(490);
        roll.setLayoutY(150+60*4+20);
        roll.setOnMousePressed(e -> {
            board.getChildren().remove(roll);

            //show four dice rolling gif, representing four dices rolled
            //first three are larger, representing dice A
            //last onr is smaller, representing dice B
            ImageView imageView1 = new ImageView();
            Image diceRolling1 = new Image(Viewer.class.getResource("assets/"+"dieA.gif").toString());
            imageView1.setLayoutX(490);
            imageView1.setLayoutY(150);
            imageView1.setFitHeight(60);
            imageView1.setFitWidth(60);
            Image diceRolling2 = new Image(Viewer.class.getResource("assets/"+"dieA.gif").toString());
            ImageView imageView2 = new ImageView();
            imageView2.setLayoutX(490);
            imageView2.setLayoutY(150+60);
            imageView2.setFitHeight(60);
            imageView2.setFitWidth(60);
            Image diceRolling3 = new Image(Viewer.class.getResource("assets/"+"dieA.gif").toString());
            ImageView imageView3 = new ImageView();
            imageView3.setLayoutX(490);
            imageView3.setLayoutY(150+60*2);
            imageView3.setFitHeight(60);
            imageView3.setFitWidth(60);
            Image diceRolling4 = new Image(Viewer.class.getResource("assets/"+"dieA.gif").toString());
            ImageView imageView4 = new ImageView();
            imageView4.setLayoutX(490+5);
            imageView4.setLayoutY(150+60*3+5);
            imageView4.setFitHeight(50);
            imageView4.setFitWidth(50);
            Timeline timeline = new Timeline( new KeyFrame(Duration.ZERO, event -> {
                imageView1.setImage(diceRolling1);
                imageView2.setImage(diceRolling2);
                imageView3.setImage(diceRolling3);
                imageView4.setImage(diceRolling4);
            }),new KeyFrame(Duration.millis(1800)));
            board.getChildren().addAll(imageView1,imageView2,imageView3,imageView4);
            timeline.play();
            timeline.setOnFinished(actionEvent -> {
                board.getChildren().removeAll(imageView1,imageView2,imageView3,imageView4);

                //set up the draggable tiles and simple tiles
                //simple tiles are mainly used to replace locked tiles
                firstNormal = new DraggableTile(diceResult.substring(0,2),495,155);
                secondNormal = new DraggableTile(diceResult.substring(2,4),495,155+60);
                thirdNormal = new DraggableTile(diceResult.substring(4,6),495,155+60*2);
                fourthNormal = new DraggableTile(diceResult.substring(6,8),496,155+60*3);
                firstImage = new Tile(diceResult.substring(0,2),495,155);
                secondImage = new Tile(diceResult.substring(2,4),495,155+60);
                thirdImage = new Tile(diceResult.substring(4,6),495,155+60*2);
                fourthImage = new Tile(diceResult.substring(6,8),496,155+60*3);
                normals.getChildren().addAll(firstNormal,secondNormal,thirdNormal,fourthNormal);
                normalImages.getChildren().addAll(firstImage,secondImage,thirdImage,fourthImage);

                // make computer's placements
                //check whether used special tiles
                int len = compSqu.length()/5;
                for(int i = 0; i<len; i++){
                    String compPlacement = compSqu.substring(i*5,i*5+5);
                    Tile compTile = new Tile(compPlacement.substring(0,2),Integer.parseInt(compPlacement.substring(3,4))*50+620,(compPlacement.substring(2,3).hashCode()-65)*50+100,Integer.parseInt(compPlacement.substring(4,5))*90);
                    board.getChildren().add(compTile);
                    boardStringComp = boardStringComp+compPlacement;
                    currentScoreComp.setText("Basic score : "+RailroadInk.getBasicScore(boardStringComp));
                    if(compPlacement.substring(0,1).equals("S")){
                        int k = Integer.parseInt(compPlacement.substring(1,2));
                        Iterator<Node> iterator = specialImagesComp.getChildren().iterator();
                        while (iterator.hasNext()){
                            if(iterator.next().getLayoutX()==620+k*60){
                                iterator.remove();
                            }
                        }
                    }
                }

                //set up the button to use special tiles
                useSpecial = new Button("Use special tile");
                useSpecial.setLayoutX(475);
                useSpecial.setLayoutY(150+60*4+80);
                useSpecial.setOnMousePressed(event -> {
                    board.getChildren().remove(useSpecial);  //special tile can only use once a time
                    board.getChildren().remove(tileUsing);  //a special tile replace a normal tile
                    tileUsing =null;
                    specials.getChildren().remove(specialImages); //unlock the special tiles
                    specials.getChildren().add(specialTiles);
                });

                //set on make placement button
                Button make = new Button("make one placement");
                make.setLayoutX(475);
                make.setLayoutY(150+60*4+30);
                make.setOnMousePressed(event -> {
                    if(tileUsing!=null || specialUsing!=null){
                        String placement="";
                        if(specialUsing==null){ //means placed a normal tile
                            placement = tileUsing.getPlacementString();
                            //check validity
                            if(RailroadInk.isValidPlacementSequence(boardStringPlayer+placement) && RailroadInk.isBoardStringWellFormed(boardStringPlayer+placement)){
                                boardStringPlayer=boardStringPlayer+placement;
                                //reset all the temporary thing
                                currentScorePlayer.setText("Basic score : "+RailroadInk.getBasicScore(boardStringPlayer));
                                normals.getChildren().remove(tileUsing);
                                board.getChildren().add(new Tile(tileUsing.tileName, tileUsing.getLayoutX(), tileUsing.getLayoutY(), tileUsing.rotate));
                                board.getChildren().remove(tileUsing);
                                usedTiles.add(tileUsing);
                                tileUsing =null;
                                board.getChildren().remove(normalImages);
                                board.getChildren().remove(useSpecial);
                                if(countDice<3){ //during a round
                                    board.getChildren().add(normals);
                                    countDice++;
                                }else {  //end a round
                                    countDice=0;
                                    board.getChildren().remove(make);
                                    if(countRound<7){
                                        board.getChildren().add(roll);
                                    }else if (countRound==7 && countDice<3){ //in the last round, but not last tile
                                        board.getChildren().add(roll);
                                    }
                                    nextRound();
                                }
                            }else {
                                tileUsing.alertError();
                            }
                        }else {  //placed a special tile
                            placement = specialUsing.getPlacementString();
                            //check validity
                            if(RailroadInk.isValidPlacementSequence(boardStringPlayer+placement)&& RailroadInk.isBoardStringWellFormed(boardStringPlayer+placement)){
                                boardStringPlayer=boardStringPlayer+placement;
                                //reset everything related and temporary
                                currentScorePlayer.setText("Basic score : "+RailroadInk.getBasicScore(boardStringPlayer));
                                board.getChildren().add(new Tile(specialUsing.tileName,specialUsing.getLayoutX(),specialUsing.getLayoutY(),specialUsing.rotate));
                                specials.getChildren().remove(specialUsing);
                                specialUsing=null;
                                specialRemaining--;
                                board.getChildren().add(normals);
                                board.getChildren().remove(normalImages);
                                board.getChildren().remove(useSpecial);
                                if(countDice<3){ //during a round
                                    countDice++;
                                }else { //ending a round
                                    if(countRound<7){
                                        board.getChildren().add(roll);
                                    }else if (countRound==7 && countDice<3){  //last round but not last tile
                                        board.getChildren().add(roll);
                                    }
                                    board.getChildren().remove(make); //make placement button should show up after dices rolled
                                    countDice=0;
                                    nextRound();
                                }
                            }else {
                                specialUsing.alertError();
                            }
                        }
                    }else { //did not place anything
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Cannot find new placement");
                        alert.showAndWait();
                    }
                });
                board.getChildren().add(make);
            });

        });
        board.getChildren().add(roll);
    }

    //to finish a game
    private static void finishGame(){
        int playerScore = RailroadInk.getBasicScore(boardStringPlayer);
        int compScore = RailroadInk.getBasicScore(boardStringComp);

        //set up animation according to the scores of player and computer
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

        //set text for scoring, after animation, player can still see the scores
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

    //initialize the board
    private static void initBoard(){

        //initialize two 7*7 grids
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

        //initialize the scores remainder button
        currentScorePlayer= new Text("Basic Score : " +basicScorePlayer);
        currentScoreComp=new Text("Basic Score : "+basicScoreComp);
        currentScorePlayer.setLayoutX(270);
        currentScorePlayer.setLayoutY(50);
        currentScoreComp.setLayoutX(820);
        currentScoreComp.setLayoutY(50);
        board.getChildren().addAll(currentScorePlayer,currentScoreComp);

        //initialize exits
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

        //initialize the frame of dices
        Rectangle diceFrame1 = new Rectangle();
        diceFrame1.setX(490);
        diceFrame1.setY(150);
        diceFrame1.setWidth(60);
        diceFrame1.setHeight(60);
        diceFrame1.setFill(BEIGE);
        diceFrame1.setStroke(BLACK);
        diceFrame1.setStrokeWidth(5);
        board.getChildren().add(diceFrame1);

        Rectangle diceFrame2 = new Rectangle();
        diceFrame2.setX(490);
        diceFrame2.setY(150+60);
        diceFrame2.setWidth(60);
        diceFrame2.setHeight(60);
        diceFrame2.setFill(BEIGE);
        diceFrame2.setStroke(BLACK);
        diceFrame2.setStrokeWidth(5);
        board.getChildren().add(diceFrame2);

        Rectangle diceFrame3 = new Rectangle();
        diceFrame3.setX(490);
        diceFrame3.setY(150+60*2);
        diceFrame3.setWidth(60);
        diceFrame3.setHeight(60);
        diceFrame3.setFill(BEIGE);
        diceFrame3.setStroke(BLACK);
        diceFrame3.setStrokeWidth(5);
        board.getChildren().add(diceFrame3);

        Rectangle diceFrame4 = new Rectangle();
        diceFrame4.setX(490);
        diceFrame4.setY(150+60*3);
        diceFrame4.setWidth(60);
        diceFrame4.setHeight(60);
        diceFrame4.setFill(BEIGE);
        diceFrame4.setStroke(BLACK);
        diceFrame4.setStrokeWidth(5);
        board.getChildren().add(diceFrame4);

        //initialize the back button
        Button back = new Button("Back");
        back.setLayoutX(10);
        back.setLayoutY(10);
        back.setOnMousePressed(e -> {
            //clear all groups, reset all values
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
            tileUsing=null;
            specialUsing=null;
            specialTiles.getChildren().clear();
            tileS0=null;
            tileS1=null;
            tileS2=null;
            tileS3=null;
            tileS4=null;
            tileS5=null;
            alert.getChildren().clear();
            specialRemaining=6;
            diceResult = "";
            compSqu = "";
            firstNormal=null;
            secondNormal=null;
            thirdNormal=null;
            fourthNormal=null;
            firstImage=null;
            secondImage=null;
            thirdImage=null;
            fourthImage=null;
            normals.getChildren().clear();
            normalImages.getChildren().clear();
            usedTiles.clear();
            useSpecial=null;
            currentScorePlayer=null;
            currentScoreComp=null;
            root.getChildren().remove(rootMul);
            root.getChildren().add(begin);
        });
        board.getChildren().add(back);
        rootMul.getChildren().add(board);
    }

    //at the beginning of a game, ask the name of player
    private static void askPlayerName(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Welcome to Battle Mode ! ");
        dialog.setContentText("Please enter your name : ");
        Optional<String> name = dialog.showAndWait();
        if(name.isPresent()){
            yourName=name.get();
        }
    }

    //show the name and score of player and computer
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

    //initialize the special tiles
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


    static class Tile extends ImageView {
        double x,y;
        String tileName;
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

            this.setOnMousePressed(e -> { // Tile cannot be dragged, when player tried to, alert him/her
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("This tile is locked!");
                alert.showAndWait();
            });
        }
        Tile(String tileName, double x, double y,int rotate){ //add a rotate parameter, useful when make placements according to placementString
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
        private double oriX = -1;
        private double oriY = -1;

        DraggableTile(String tileName, double x, double y){
            super(tileName,x,y);
            this.x = x;
            this.y = y;

            this.setOnScroll(event -> {
                this.rotate();
            });
            this.setOnMousePressed(event -> {
                this.recordOriginalLocation();
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
                if(specialRemaining>3 && specialUsing==null){
                    board.getChildren().add(useSpecial);
                }
                lockOthers();
            });
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

        void recordOriginalLocation(){
            if(oriX<0){
                oriX=this.x;
            }
            if(oriY<0){
                oriY=this.y;
            }
        }

        void lockOthers(){
            if(this.tileName.substring(0,1).equals("S")){ //for special tiles
               if(specialUsing==null){
                   board.getChildren().remove(useSpecial);
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
            }else { //for normal tiles
                if(tileUsing==null){
                    board.getChildren().remove(normals);
                    tileUsing = this;
                    board.getChildren().add(tileUsing);
                    Iterator<Node> iterator = normalImages.getChildren().iterator();
                    while (iterator.hasNext()){
                        if (iterator.next().getLayoutY()==this.oriY){
                            iterator.remove();
                        }
                    }
                    board.getChildren().add(normalImages);
                }
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
    }

    //return a HashMap, grid strings as keys, x and y coordination as values
    static HashMap<String,int[]> theBoardGrid(){
        HashMap<String,int[]> locations = new HashMap<>();
        int[][] locationValue = gridLocation();
        String[] locationString = Board.grid;
        for(int i=0; i<49; i++){
            locations.put(locationString[i],locationValue[i]);
        }
        return locations;
    }

    //return the coordinate of the nearest grid
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

    //get all grids' location
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

    //a class helps to create boards
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
