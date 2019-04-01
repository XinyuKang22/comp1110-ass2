package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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

        ImageView board = new ImageView();
        board.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "Board.jpg").toString()));
        board.setFitHeight(700);
        board.setFitWidth(700);
        ImageView highExit = new ImageView();
        highExit.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "HighExit.png").toString()));
        highExit.setFitHeight(100);
        highExit.setFitWidth(100);
        ImageView railExit = new ImageView();
        railExit.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "RailExit.png").toString()));
        railExit.setFitHeight(100);
        railExit.setFitWidth(100);
        ImageView a0 = new ImageView();
        a0.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "A0.png").toString()));
        a0.setFitHeight(100);
        a0.setFitWidth(100);
        ImageView a1 = new ImageView();
        a1.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "A1.png").toString()));
        a1.setFitHeight(100);
        a1.setFitWidth(100);
        ImageView a2 = new ImageView();
        a2.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "A2.png").toString()));
        a2.setFitHeight(100);
        a2.setFitWidth(100);
        ImageView a3 = new ImageView();
        a3.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "A3.png").toString()));
        a3.setFitHeight(100);
        a3.setFitWidth(100);
        ImageView a4 = new ImageView();
        a4.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "A4.png").toString()));
        a4.setFitHeight(100);
        a4.setFitWidth(100);
        ImageView a5 = new ImageView();
        a5.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "A5.png").toString()));
        a5.setFitHeight(100);
        a5.setFitWidth(100);
        ImageView b0 = new ImageView();
        b0.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "B0.png").toString()));
        b0.setFitHeight(100);
        b0.setFitWidth(100);
        ImageView b1 = new ImageView();
        b1.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "B1.png").toString()));
        b1.setFitHeight(100);
        b1.setFitWidth(100);
        ImageView b2 = new ImageView();
        b2.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "B2.png").toString()));
        b2.setFitHeight(100);
        b2.setFitWidth(100);
        ImageView s0 = new ImageView();
        s0.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "S0.png").toString()));
        s0.setFitHeight(100);
        s0.setFitWidth(100);
        ImageView s1 = new ImageView();
        s1.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "S1.png").toString()));
        s1.setFitHeight(100);
        s1.setFitWidth(100);
        ImageView s2 = new ImageView();
        s2.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "S2.png").toString()));
        s2.setFitHeight(100);
        s2.setFitWidth(100);
        ImageView s3 = new ImageView();
        s3.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "S3.png").toString()));
        s3.setFitHeight(100);
        s3.setFitWidth(100);
        ImageView s4 = new ImageView();
        s4.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "S4.png").toString()));
        s4.setFitHeight(100);
        s4.setFitWidth(100);
        ImageView s5 = new ImageView();
        s5.setImage(new Image(Viewer.class.getResource(Viewer.URI_BASE + "S5.png").toString()));
        s5.setFitHeight(100);
        s5.setFitWidth(100);
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
