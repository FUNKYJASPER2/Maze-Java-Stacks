import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.GRAY;
import static javafx.scene.paint.Color.WHITE;

public class Maze extends Application implements EventHandler<KeyEvent> {

    private Line line;
    private Group root;
    private Color color = Color.RED;

    @Override
    public void start(Stage stage) {
        root = new Group();


        Text title = new Text(900,100,"Maze Game");
        title.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 80));
        title.setFill(WHITE);
        title.setX(725);
        title.setY(100);

        // scene is created
        Scene scene = new Scene(root, 500, 500, Color.GRAY);

        // title set and buttons added to the screen
        stage.setTitle("Elastic Lines");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();


        Button playButton = new Button("Play");
        playButton.setTranslateX(750);
        playButton.setTranslateY(300);
        playButton.setMinSize(400,100);
        playButton.setStyle("-fx-font-size: 4em; ");
        // event handler for when its clicked and changes the color
        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // set new scene
            }
        });

        Button scoreButton = new Button("Score");
        scoreButton.setTranslateX(750);
        scoreButton.setTranslateY(500);
        scoreButton.setMinSize(400,100);
        scoreButton.setStyle("-fx-font-size: 4em; ");
        // event handler for when its clicked and changes the color
        scoreButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // set new scene
            }
        });

        Button quitButton = new Button("Quit");
        quitButton.setTranslateX(750);
        quitButton.setTranslateY(700);
        quitButton.setMinSize(400,100);
        quitButton.setStyle("-fx-font-size: 4em; ");
        // event handler for when its clicked and changes the color
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(1);
            }
        });

        // adds all the button to root so it shows up
        root.getChildren().addAll(playButton, scoreButton, quitButton,title);

    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(KeyEvent event){
        if(event.getCode() == KeyCode.DOWN){

        }
        if(event.getCode() == KeyCode.UP){

        }
        if(event.getCode() == KeyCode.LEFT){

        }
        if(event.getCode() == KeyCode.RIGHT){

        }
    }
}


