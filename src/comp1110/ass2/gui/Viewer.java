package comp1110.ass2.gui;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import comp1110.ass2.RailroadInk;

/**
 * A very simple viewer for tile placements in the Railroad Ink game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various tile placements.
 */
public class Viewer extends Application {
    /* board layout */
    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 768;

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
        this.grid.setPrefSize(722,650); // (560+162, 560+90)
        placementGroup.getChildren().add(grid);

        grid.setGridLinesVisible(true);
        for(int i=0; i<8; i++){
            RowConstraints row;
            ColumnConstraints col;

            if(i==0){
                row = new RowConstraints(90);
                col = new ColumnConstraints(162);
            }else {
                row = new RowConstraints(80);
                col = new ColumnConstraints(80);
            }
            grid.getRowConstraints().add(row);
            grid.getColumnConstraints().add(col);
        }

        //set up exits
        ImageView exitB0 = new ImageView();
        exitB0.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitB0.setFitHeight(80);
        exitB0.setFitWidth(80);
        exitB0.setLayoutX(102);
        exitB0.setLayoutY(170);
        exitB0.setRotate(270);
        placementGroup.getChildren().add(exitB0);

        ImageView exitD0 = new ImageView();
        exitD0.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitD0.setFitHeight(80);
        exitD0.setFitWidth(80);
        exitD0.setLayoutX(102);
        exitD0.setLayoutY(330);
        exitD0.setRotate(270);
        placementGroup.getChildren().add(exitD0);

        ImageView exitF0 = new ImageView();
        exitF0.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitF0.setFitHeight(80);
        exitF0.setFitWidth(80);
        exitF0.setLayoutX(102);
        exitF0.setLayoutY(490);
        exitF0.setRotate(270);
        placementGroup.getChildren().add(exitF0);

        ImageView exitB6 = new ImageView();
        exitB6.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitB6.setFitHeight(80);
        exitB6.setFitWidth(80);
        exitB6.setLayoutX(102+600);
        exitB6.setLayoutY(170);
        exitB6.setRotate(90);
        placementGroup.getChildren().add(exitB6);

        ImageView exitD6 = new ImageView();
        exitD6.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitD6.setFitHeight(80);
        exitD6.setFitWidth(80);
        exitD6.setLayoutX(102+600);
        exitD6.setLayoutY(330);
        exitD6.setRotate(90);
        placementGroup.getChildren().add(exitD6);

        ImageView exitF6 = new ImageView();
        exitF6.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitF6.setFitHeight(80);
        exitF6.setFitWidth(80);
        exitF6.setLayoutX(102+600);
        exitF6.setLayoutY(490);
        exitF6.setRotate(90);
        placementGroup.getChildren().add(exitF6);

        ImageView exitA1 = new ImageView();
        exitA1.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitA1.setFitHeight(80);
        exitA1.setFitWidth(80);
        exitA1.setLayoutX(242);
        exitA1.setLayoutY(30);
        placementGroup.getChildren().add(exitA1);

        ImageView exitA3 = new ImageView();
        exitA3.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitA3.setFitHeight(80);
        exitA3.setFitWidth(80);
        exitA3.setLayoutX(402);
        exitA3.setLayoutY(30);
        placementGroup.getChildren().add(exitA3);

        ImageView exitA5 = new ImageView();
        exitA5.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitA5.setFitHeight(80);
        exitA5.setFitWidth(80);
        exitA5.setLayoutX(562);
        exitA5.setLayoutY(30);
        placementGroup.getChildren().add(exitA5);

        ImageView exitG1 = new ImageView();
        exitG1.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitG1.setRotate(180);
        exitG1.setFitHeight(80);
        exitG1.setFitWidth(80);
        exitG1.setLayoutX(242);
        exitG1.setLayoutY(630);
        placementGroup.getChildren().add(exitG1);

        ImageView exitG3 = new ImageView();
        exitG3.setImage(new Image(Viewer.class.getResource(URI_BASE+"RailExit.png").toString()));
        exitG3.setRotate(180);
        exitG3.setFitHeight(80);
        exitG3.setFitWidth(80);
        exitG3.setLayoutX(402);
        exitG3.setLayoutY(630);
        placementGroup.getChildren().add(exitG3);

        ImageView exitG5 = new ImageView();
        exitG5.setImage(new Image(Viewer.class.getResource(URI_BASE+"HighExit.png").toString()));
        exitG5.setRotate(180);
        exitG5.setFitHeight(80);
        exitG5.setFitWidth(80);
        exitG5.setLayoutX(562);
        exitG5.setLayoutY(630);
        placementGroup.getChildren().add(exitG5);
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
           int rowPosition = (placement.substring(i+2,i+3).hashCode()-65)*80+90;
           int colPosition = Integer.parseInt(placement.substring(i+3,i+4))*80+162;
           int orientation = Integer.parseInt(placement.substring(i+4,i+5))*90;

           //set up tile
           img = new ImageView();
           img.setImage(new Image(Viewer.class.getResource(URI_BASE+tile+".png").toString()));
           img.setRotate(orientation);
           img.setFitWidth(80);
           img.setFitHeight(80);
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
        Label label1 = new Label("Placement:");
        textField.setPrefWidth(100);
        Button button = new Button("Refresh");
        button.setOnAction(e -> {
            makePlacement(textField.getText());
            textField.clear();
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(760);
        hb.setLayoutY(VIEWER_HEIGHT - 500);
        controls.getChildren().add(hb);
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
