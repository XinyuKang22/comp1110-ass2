package comp1110.ass2;

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

import java.util.Optional;

import static javafx.scene.paint.Color.BEIGE;
import static javafx.scene.paint.Color.BLACK;


//Written by Xinyu Kang
public class MultiplePlayers extends Viewer{

    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 640;
    private static final String URI_BASE = "assets/";
    private static Group rootMul = new Group();
    private static Group board = new Group();  //包括 : 棋盘， 玩家头像， 玩家名称, 回合计数器， 基本分数按钮， 骰子框框, 骰子
    private static String yourName="";  //玩家名字，等待输入
    private String boardStringPlayer = "";
    private String boardStringComp = "";
    private static Group specials = new Group(); //draggable special tiles  player
    private static Group specialImages = new Group();  //special tile images   player
    private static Group tempSpecialImages = new Group();
    private static Group tempSpecialUsing = null;
    private static Group specialImagesComp = new Group();  //special tile images   comp
    private int countRound = 0;
    private int countDice = 0;
    private static Group grids = new Group();   //棋盘和返回键, 名字和基础分
    private static int basicScorePlayer = 0;
    private static int basicScoreComp = 0;


    public static void mulStart(Group root){
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
                board.getChildren().remove(roll);
            });
        });
        board.getChildren().add(roll);
    }

    private static void initBoard(){   //棋盘和 back按钮
        for(int i=0; i<7; i++){
            for(int m=0; m<7; m++){
                grids.getChildren().add(new Viewer.Grid(70+i*50,100+m*50,50));
            }
        }
        for(int i=0; i<7; i++){
            for(int m=0; m<7; m++){
                grids.getChildren().add(new Viewer.Grid(620+i*50,100+m*50,50));
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

    static class Tile extends ImageView {
        double x,y;
        String tileName;
        Viewer viewer;
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


}
