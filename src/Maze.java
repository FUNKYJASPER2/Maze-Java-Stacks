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

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.GRAY;
import static javafx.scene.paint.Color.WHITE;

public class Maze extends Application implements EventHandler<KeyEvent> {

    private Stage window;
    private int playerXpos = 920;
    private int playerYpos = 300;
    private Rectangle recPlayer = new Rectangle(playerXpos, playerYpos, 20, 20);

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
                window.setScene(scoreScene());
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

        playButton.setFocusTraversable(false);
        scoreButton.setFocusTraversable(false);
        quitButton.setFocusTraversable(false);

        // adds all the button to root so it shows up
        root.getChildren().addAll(playButton, scoreButton, quitButton, title);

        return mainMenuScene;
    }

    public Scene playGameScene(){
        Group root2;
        root2 = new Group();
        Scene playGameScene = new Scene(root2,1920, 1080, Color.GREY);

        playGameScene.setOnKeyPressed(this);

        Text title = new Text(900,100,"Maze Game");
        title.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 80));
        title.setFill(WHITE);
        title.setX(725);
        title.setY(100);


        Text levelTitle = new Text(900,100,"Level 1");
        levelTitle.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        levelTitle.setFill(WHITE);
        levelTitle.setX(850);
        levelTitle.setY(200);

        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setTranslateX(100);
        mainMenuButton.setTranslateY(50);
        mainMenuButton.setMinSize(200,50);
        mainMenuButton.setStyle("-fx-font-size: 2em; ");
        // event handler for when its clicked and changes the color
        mainMenuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

        mainMenuButton.setFocusTraversable(false);
        quitButton.setFocusTraversable(false);

        recPlayer.setFill(Color.rgb(255, 0, 0));

        // draws the maze for level 1

        double gridPosX = 600;
        double gridPosY = 300;

        for(int i = 0; i <= 10; i++){
            for(int k = 0; k <= 10; k++){
                Rectangle mazerec = new Rectangle(gridPosX, gridPosY, 20, 20);
                // added borders to tell its not just one big square
                mazerec.setStrokeWidth(1);
                mazerec.setStroke(BLACK);
                // -------------------------------------------
                mazerec.setFill(Color.rgb(150, 0, 150));
                root2.getChildren().add(mazerec);
                gridPosX += 20;
            }
            gridPosX = 600;
            gridPosY += 20;
        }









        root2.getChildren().addAll(mainMenuButton,quitButton,title,levelTitle, recPlayer);

        return playGameScene;
    }

    public Scene scoreScene(){
        Group root3;
        root3 = new Group();
        Scene scoreScene = new Scene(root3,1920, 1080, Color.GREY);

        Text title = new Text(900,100,"Maze Game");
        title.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 80));
        title.setFill(WHITE);
        title.setX(725);
        title.setY(100);

        Text scoreTitle = new Text(900,100,"High Scores");
        scoreTitle.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        scoreTitle.setFill(WHITE);
        scoreTitle.setX(800);
        scoreTitle.setY(200);


        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setTranslateX(100);
        mainMenuButton.setTranslateY(50);
        mainMenuButton.setMinSize(200,50);
        mainMenuButton.setStyle("-fx-font-size: 2em; ");
        // event handler for when its clicked and changes the color
        mainMenuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

        mainMenuButton.setFocusTraversable(false);
        quitButton.setFocusTraversable(false);

        root3.getChildren().addAll(mainMenuButton,quitButton,title, scoreTitle);

        return scoreScene;
    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(KeyEvent event){
        if(event.getCode() == KeyCode.DOWN){
            playerYpos += 20;
            recPlayer.setY(playerYpos);
        }
        if(event.getCode() == KeyCode.UP){
            playerYpos -= 20;
            recPlayer.setY(playerYpos);
        }
        if(event.getCode() == KeyCode.LEFT){
            playerXpos -= 20;
            recPlayer.setX(playerXpos);
        }
        if(event.getCode() == KeyCode.RIGHT){
            playerXpos += 20;
            recPlayer.setX(playerXpos);
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

