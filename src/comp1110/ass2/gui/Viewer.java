package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import comp1110.ass2.RailroadInk;

/**
 * A very simple viewer for tile placements in the Railroad Ink game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various tile placements.
 */
//Written by Xinyu Kang
public class Viewer extends Application {
    /* board layout */
    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 640;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    private final Group placementGroup =new Group();
    TextField textField =new TextField();
    ImageView img;
    GridPane grid;

    //draw a grid
    private void displayGrid() {
        this.grid = new GridPane();
        this.grid.setPrefSize(450,450);
        this.grid.setLayoutX(150);
        this.grid.setLayoutY(100);
        root.getChildren().add(grid);

        grid.setGridLinesVisible(true);
        for(int i=0; i<7; i++){
            RowConstraints row;
            ColumnConstraints col;

            row = new RowConstraints(65);
            col = new ColumnConstraints(65);

            grid.getRowConstraints().add(row);
            grid.getColumnConstraints().add(col);
        }

        //set up exits
        ImageView exitB0 = new ImageView();
        exitB0.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitB0.setFitHeight(65);
        exitB0.setFitWidth(65);
        exitB0.setLayoutX(150-65);
        exitB0.setLayoutY(100+65);
        exitB0.setRotate(270);
        root.getChildren().add(exitB0);

        ImageView exitD0 = new ImageView();
        exitD0.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitD0.setFitHeight(65);
        exitD0.setFitWidth(65);
        exitD0.setLayoutX(150-65);
        exitD0.setLayoutY(100+65*3);
        exitD0.setRotate(270);
        root.getChildren().add(exitD0);

        ImageView exitF0 = new ImageView();
        exitF0.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitF0.setFitHeight(65);
        exitF0.setFitWidth(65);
        exitF0.setLayoutX(150-65);
        exitF0.setLayoutY(100+65*5);
        exitF0.setRotate(270);
        root.getChildren().add(exitF0);

        ImageView exitB6 = new ImageView();
        exitB6.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitB6.setFitHeight(65);
        exitB6.setFitWidth(65);
        exitB6.setLayoutX(150+65*7);
        exitB6.setLayoutY(100+65);
        exitB6.setRotate(90);


        root.getChildren().add(exitB6);

        ImageView exitD6 = new ImageView();
        exitD6.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitD6.setFitHeight(65);
        exitD6.setFitWidth(65);
        exitD6.setLayoutX(150+65*7);
        exitD6.setLayoutY(100+65*3);
        exitD6.setRotate(90);
        root.getChildren().add(exitD6);

        ImageView exitF6 = new ImageView();
        exitF6.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitF6.setFitHeight(65);
        exitF6.setFitWidth(65);
        exitF6.setLayoutX(150+65*7);
        exitF6.setLayoutY(100+65*5);
        exitF6.setRotate(90);
        root.getChildren().add(exitF6);

        ImageView exitA1 = new ImageView();
        exitA1.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitA1.setFitHeight(65);
        exitA1.setFitWidth(65);
        exitA1.setLayoutX(150+65);
        exitA1.setLayoutY(100-65);
        root.getChildren().add(exitA1);

        ImageView exitA3 = new ImageView();
        exitA3.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitA3.setFitHeight(65);
        exitA3.setFitWidth(65);
        exitA3.setLayoutX(150+65*3);
        exitA3.setLayoutY(100-65);
        root.getChildren().add(exitA3);

        ImageView exitA5 = new ImageView();
        exitA5.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitA5.setFitHeight(65);
        exitA5.setFitWidth(65);
        exitA5.setLayoutX(150+65*5);
        exitA5.setLayoutY(100-65);
        root.getChildren().add(exitA5);

        ImageView exitG1 = new ImageView();
        exitG1.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitG1.setRotate(180);
        exitG1.setFitHeight(65);
        exitG1.setFitWidth(65);
        exitG1.setLayoutX(150+65);
        exitG1.setLayoutY(100+65*7);
        root.getChildren().add(exitG1);

        ImageView exitG3 = new ImageView();
        exitG3.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitG3.setRotate(180);
        exitG3.setFitHeight(65);
        exitG3.setFitWidth(65);
        exitG3.setLayoutX(150+65*3);
        exitG3.setLayoutY(100+65*7);
        root.getChildren().add(exitG3);

        ImageView exitG5 = new ImageView();
        exitG5.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitG5.setRotate(180);
        exitG5.setFitHeight(65);
        exitG5.setFitWidth(65);
        exitG5.setLayoutX(150+65*5);
        exitG5.setLayoutY(100+65*7);
        root.getChildren().add(exitG5);
    }

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement) {
        // FIXME Task 4: implement the simple placement viewer

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

           //set up tile
           img = new ImageView();
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

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {

        Label label1 = new Label("Placement String:");
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Railroad Ink");
        Scene scene = new Scene(root, VIEWER_WIDTH,VIEWER_HEIGHT, Color.BEIGE);

        root.getChildren().add(controls);
        root.getChildren().add(placementGroup);

        makeControls();
        displayGrid();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
