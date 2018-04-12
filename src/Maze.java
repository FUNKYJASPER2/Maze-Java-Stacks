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

    private Stage window;

    @Override
    public void start(Stage stage) {
        window = stage;
        // title set and buttons added to the screen
        stage.setTitle("Maze Game");
        stage.setScene(mainMenu());
        stage.setMaximized(true);
        stage.show();
    }

    public Scene mainMenu(){
        Group root;
        root = new Group();


        Text title = new Text(900,100,"Maze Game");
        title.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 80));
        title.setFill(WHITE);
        title.setX(725);
        title.setY(100);

        // scene is created
        Scene mainMenuScene = new Scene(root, 1920, 1080, Color.GRAY);

        Button playButton = new Button("Play");
        playButton.setTranslateX(750);
        playButton.setTranslateY(300);
        playButton.setMinSize(400,100);
        playButton.setStyle("-fx-font-size: 4em; ");
        // event handler for when its clicked and changes the color
        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(playGameScene());
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
        root.getChildren().addAll(playButton, scoreButton, quitButton, title);

        return mainMenuScene;
    }

    public Scene playGameScene(){
        Group root2;
        root2 = new Group();
        Scene playGameScene = new Scene(root2,1920, 1080, Color.GREY);

        Text title = new Text(900,100,"Maze Game");
        title.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 80));
        title.setFill(WHITE);
        title.setX(725);
        title.setY(100);



        Button mainMunuButton = new Button("Main Menu");
        mainMunuButton.setTranslateX(100);
        mainMunuButton.setTranslateY(50);
        mainMunuButton.setMinSize(200,50);
        mainMunuButton.setStyle("-fx-font-size: 2em; ");
        // event handler for when its clicked and changes the color
        mainMunuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(mainMenu());
            }
        });


        Button quitButton = new Button("Quit");
        quitButton.setTranslateX(1620);
        quitButton.setTranslateY(50);
        quitButton.setMinSize(200,50);
        quitButton.setStyle("-fx-font-size: 2em; ");
        // event handler for when its clicked and changes the color
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(1);
            }
        });








        root2.getChildren().addAll(mainMunuButton,quitButton,title);

        return playGameScene;
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




/* Things to add ----------------------------------------------------------

// level 1
// level 2
// level 3
// high score
// printing maze
// limited movements

**** this is dont by printing squares with lines where they need to be than, checks players coordinate and if they are match
**** the certian cooridnate than the user can only move set ways


*/

