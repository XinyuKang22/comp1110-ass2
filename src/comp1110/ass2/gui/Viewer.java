package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    TextField textField;


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement) {
        // FIXME Task 4: implement the simple placement viewer
        if (!RailroadInk.isValidPlacementSequence(placement)){
            throw new IllegalArgumentException("Bad placement " + placement);
        }else{
            GridPane gridPane = new GridPane();
            gridPane.setPrefSize(624.0D, 624.0D);
            gridPane.setMaxSize(624.0D, 624.0D);
            gridPane.setGridLinesVisible(true);

            String tile = placement.substring(0,2);
            String location = placement.substring(2,4);
            String orientation = placement.substring(4);

            ImageView tileImage = new ImageView();
            tileImage.setImage(new Image(Viewer.class.getResource("assets/" + tile + ".png").toString()));
            tileImage.setRotate((double) Double.parseDouble(orientation)*90);

            this.root.getChildren().add(gridPane);
        }



    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(e -> {
            makePlacement(textField.getText());
            textField.clear();
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Railroad Ink");

        Group root = new Group();
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
        primaryStage.setScene(scene);

//        StackPane pane = new StackPane();
//        ImageView board = new ImageView();
//        board.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "Board.jpg").toString()));
//        board.setFitHeight(700);
//        board.setFitWidth(700);
//        board.setX(0);
//        board.setY(0);
//        pane.getChildren().add(board);

        root.getChildren().add(controls);

        makeControls();

        primaryStage.show();
    }
}
