import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.GRAY;
import static javafx.scene.paint.Color.WHITE;
import java.util.Random;
import java.util.Scanner;

public class Maze extends Application implements EventHandler<KeyEvent> {
    private int moveCount = 0;
    private int size;
    private RandomMaze maze;
    private double startX = 775;//starting X position for the maze
    private double startY = 300;//starting Y position for the maze
    private Stage window;
    private double playerXpos = startX + 2;//player starting X position
    private double playerYpos = startY + 2;//player starting Y position
    private int playRow = 0;//this keeps track of what row the player is in
    private int playCol = 0;//this keeps track of what column the player is in
    private Rectangle recPlayer = new Rectangle(playerXpos, playerYpos, 16, 16);//player rectangle
    private Text moveCounterTitle = new Text(1675,300, ""+moveCount);
    private Image menuTitle = new Image("menuname.gif");
    private ImageView title = new ImageView(menuTitle);
    final URL resource = getClass().getResource("music.mp3");
    final Media media = new Media(resource.toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);
    private Random rand = new Random();
    private int winCol;
    private static int easyHigh;
    private static int mediumHigh;
    private static int highHigh;
    private int diffculty;



    @Override
    public void start(Stage stage) {
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
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

        title.setX(525);

        // scene is created
        Scene mainMenuScene = new Scene(root, 1920, 1080, Color.web("#272831"));
        mainMenuScene.getStylesheets().add("Styles.css");

        Button playButton = new Button("Play");
        playButton.setTranslateX(750);
        playButton.setTranslateY(300);
        playButton.setMinSize(400,100);
        // event handler for when its clicked and changes the color
        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(askSizeScene());
            }
        });

        Button scoreButton = new Button("Scores");
        scoreButton.setTranslateX(750);
        scoreButton.setTranslateY(500);
        scoreButton.setMinSize(400,100);
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

    public Scene askSizeScene(){
        Group root4;
        root4 = new Group();
        Scene askSizeScene = new Scene(root4,1920, 1080, Color.web("#272831"));
        askSizeScene.getStylesheets().add("Styles.css");

        title.setX(525);


        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setTranslateX(100);
        mainMenuButton.setTranslateY(50);
        mainMenuButton.setMinSize(200,50);
        mainMenuButton.setId("mainMenuButton");
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
        quitButton.setId("quitButton");
        // event handler for when its clicked and changes the color
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(1);
            }
        });

        Button easyButton = new Button("Easy");
        easyButton.setTranslateX(750);
        easyButton.setTranslateY(300);
        easyButton.setMinSize(400,100);
        easyButton.setId("easyButton");
        // event handler for when its clicked and changes the color
        easyButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                diffculty = 1;
                startX = 800;
                startY = 300;
                winCol = rand.nextInt(15);
                maze = new RandomMaze(15);
                maze.initialize();
                maze.createMaze();
                playerXpos = startX + 2;
                playerYpos = startY + 2;
                playCol = 0;
                playRow = 0;
                recPlayer.setX(startX + 2);
                recPlayer.setY(startY + 2);
                moveCount = 0;
                moveCounterTitle.setText(""+ moveCount);
                window.setScene(playGameScene());
            }
        });

        Button mediumButton = new Button("Medium");
        mediumButton.setTranslateX(750);
        mediumButton.setTranslateY(500);
        mediumButton.setMinSize(400,100);
        mediumButton.setId("mediumButton");
        // event handler for when its clicked and changes the color
        mediumButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                diffculty = 2;
                startX = 750;
                startY = 300;
                winCol = rand.nextInt(20);
                maze = new RandomMaze(20);
                maze.initialize();
                maze.createMaze();
                playerXpos = startX + 2;
                playerYpos = startY + 2;
                playCol = 0;
                playRow = 0;
                recPlayer.setX(startX + 2);
                recPlayer.setY(startY + 2);
                moveCount = 0;
                moveCounterTitle.setText(""+ moveCount);
                window.setScene(playGameScene());
            }
        });

        Button hardButton = new Button("Hard");
        hardButton.setTranslateX(750);
        hardButton.setTranslateY(700);
        hardButton.setMinSize(400,100);
        hardButton.setId("hardButton");
        // event handler for when its clicked and changes the color
        hardButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                diffculty = 3;
                startX = 650;
                startY = 300;
                winCol = rand.nextInt(30);
                maze = new RandomMaze(30);
                maze.initialize();
                maze.createMaze();
                playerXpos = startX + 2;
                playerYpos = startY + 2;
                playCol = 0;
                playRow = 0;
                recPlayer.setX(startX + 2);
                recPlayer.setY(startY + 2);
                moveCount = 0;
                moveCounterTitle.setText(""+ moveCount);
                window.setScene(playGameScene());
            }
        });



        mainMenuButton.setFocusTraversable(false);
        quitButton.setFocusTraversable(false);
        easyButton.setFocusTraversable(false);
        mediumButton.setFocusTraversable(false);
        hardButton.setFocusTraversable(false);

        root4.getChildren().addAll(mainMenuButton,quitButton,title, easyButton, mediumButton, hardButton);

        return askSizeScene;
    }



    public Scene playGameScene(){
        Group root2;
        root2 = new Group();
        Scene playGameScene = new Scene(root2,1920, 1080, Color.web("#272831"));
        playGameScene.getStylesheets().add("Styles.css");


        playGameScene.setOnKeyPressed(this);


        title.setX(525);


        Text movesTitle = new Text(1475,300,"Moves: ");
        movesTitle.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        movesTitle.setFill(WHITE);

        String scorePrint = "";

        if(diffculty ==1){
            scorePrint = "" + easyHigh;
        }
        if(diffculty ==2){
            scorePrint = "" + mediumHigh;
        }
        if(diffculty ==3){
            scorePrint = "" + highHigh;
        }

        Text highScore = new Text(100,300,"High Score: " + scorePrint);
        highScore.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        highScore.setFill(WHITE);

        moveCounterTitle.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        moveCounterTitle.setFill(WHITE);


        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setTranslateX(100);
        mainMenuButton.setTranslateY(50);
        mainMenuButton.setMinSize(200,50);
        mainMenuButton.setId("mainMenuButton");
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
        quitButton.setId("quitButton");
        // event handler for when its clicked and changes the color
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(1);
            }
        });

        mainMenuButton.setFocusTraversable(false);
        quitButton.setFocusTraversable(false);

        recPlayer.setFill(Color.web("#4D7EA8"));
        recPlayer.setStroke(BLACK);

        // draws the maze for level 1

        double gridPosX = startX;
        double gridPosY = startY;
        double tempX;
        double tempY;

        //for loop will cycle through the elements of the array containing the maze tiles
        //it will check where its walls are and draw a line if necessary
        for (int i = 0;i < maze.getSize();i++){
            for (int j = 0;j < maze.getSize();j++){
                if (j == winCol && i == maze.getSize()-1){
                    Rectangle winTile = new Rectangle(gridPosX, gridPosY, 20, 20);//makes a rect for the background
                    winTile.setFill(Color.rgb(200, 0, 0));
                    root2.getChildren().add(winTile);//adding rect to screen
                }
                else if (i == 0 & j == 0){
                    Rectangle startTile = new Rectangle(gridPosX, gridPosY, 20, 20);//makes a rect for the background
                    startTile.setFill(Color.rgb(0, 200, 0));
                    root2.getChildren().add(startTile);//adding rect to screen
                }
                else {
                    Rectangle mazerec = new Rectangle(gridPosX, gridPosY, 20, 20);//makes a rect for the background
                    mazerec.setFill(Color.web("#fcb731"));
                    root2.getChildren().add(mazerec);//adding rect to screen
                }
                tempX = gridPosX;
                tempY = gridPosY;

                if (maze.getMaze()[i][j].isUpWall()) {//checking to see if tile has a wall above
                    Line line = new Line(tempX,tempY,tempX+20,tempY);
                    line.setStrokeWidth(1);
                    root2.getChildren().add(line);

                }
                if (maze.getMaze()[i][j].isRightWall()) {//checking for wall to the right
                    tempX = gridPosX;
                    tempY = gridPosY;
                    Line line = new Line(tempX+20,tempY,tempX+20,tempY+20);
                    line.setStrokeWidth(1);
                    root2.getChildren().add(line);

                }
                if (maze.getMaze()[i][j].isDownWall()) {//checking for wall below
                    tempX = gridPosX;
                    tempY = gridPosY;
                    Line line = new Line(tempX,tempY+20,tempX+20,tempY+20);
                    line.setStrokeWidth(1);
                    root2.getChildren().add(line);

                }
                if (maze.getMaze()[i][j].isLeftWall()) {//checking for wall to the left
                    tempX = gridPosX;
                    tempY = gridPosY;
                    Line line = new Line(tempX,tempY,tempX,tempY+20);
                    line.setStrokeWidth(1);
                    root2.getChildren().add(line);

                }

                gridPosX+=20;//moving to the right by a rectangle length to prepare to draw the next
            }
            //resetting the grid x position and moving to no the next row
            gridPosX = startX;
            gridPosY += 20;
        }


        //adding the different scene elements
        root2.getChildren().addAll(mainMenuButton,quitButton,title,movesTitle, moveCounterTitle, recPlayer, highScore);

        return playGameScene;
    }

    public Scene scoreScene(){
        Group root3;
        root3 = new Group();
        Scene scoreScene = new Scene(root3,1920, 1080, Color.web("#272831"));
        scoreScene.getStylesheets().add("Styles.css");


        title.setX(525);

        Text scoreTitle = new Text(790,300,"High Scores");
        scoreTitle.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        scoreTitle.setFill(WHITE);
        scoreTitle.setUnderline(true);

        Text easyScoreTitle = new Text(800,450,"Easy High Score: " + easyHigh);
        easyScoreTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        easyScoreTitle.setFill(WHITE);

        Text mediumScoreTitle = new Text(775,550,"Medium High Score: " + mediumHigh);
        mediumScoreTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        mediumScoreTitle.setFill(WHITE);

        Text hardScoreTitle = new Text(795,650,"Hard High Score: " + highHigh);
        hardScoreTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        hardScoreTitle.setFill(WHITE);


        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setTranslateX(100);
        mainMenuButton.setTranslateY(50);
        mainMenuButton.setMinSize(200,50);
        mainMenuButton.setId("mainMenuButton");
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
        quitButton.setId("quitButton");
        // event handler for when its clicked and changes the color
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(1);
            }
        });

        mainMenuButton.setFocusTraversable(false);
        quitButton.setFocusTraversable(false);

        root3.getChildren().addAll(mainMenuButton,quitButton,title, scoreTitle, easyScoreTitle, mediumScoreTitle, hardScoreTitle);

        return scoreScene;
    }

    public Scene winnerScene() throws IOException{
        Group root3;
        root3 = new Group();
        Scene winnerScene = new Scene(root3,1920, 1080, Color.web("#272831"));
        winnerScene.getStylesheets().add("Styles.css");


        title.setX(525);

        Text winnerTitle = new Text(865,300,"Winner");
        winnerTitle.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        winnerTitle.setFill(WHITE);

        Text winnerScoreTitle = new Text(700,350,"Your Score Was: " + moveCount);
        winnerScoreTitle.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        winnerScoreTitle.setFill(WHITE);


        Button mainMenuButton = new Button("Play Again");
        mainMenuButton.setTranslateX(750);
        mainMenuButton.setTranslateY(500);
        mainMenuButton.setMinSize(400,100);
        // event handler for when its clicked and changes the color
        mainMenuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(askSizeScene());
            }
        });


        Button quitButton = new Button("Quit");
        quitButton.setTranslateX(750);
        quitButton.setTranslateY(700);
        quitButton.setMinSize(400,100);
        // event handler for when its clicked and changes the color
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(1);
            }
        });

        mainMenuButton.setFocusTraversable(false);
        quitButton.setFocusTraversable(false);

        if(diffculty == 1){
            if(moveCount < easyHigh){
                easyHigh = moveCount;
            }
        }
        if(diffculty == 2){
            if(moveCount < mediumHigh){
                mediumHigh = moveCount;
            }
        }
        if(diffculty == 3){
            if(moveCount < highHigh){
                highHigh = moveCount;
            }
        }

        System.out.println("testtt");
        PrintWriter write = new PrintWriter("highScores");

        write.print(easyHigh + "\t");
        write.print(mediumHigh + "\t");
        write.print(highHigh + "\t");

        write.close();

        root3.getChildren().addAll(mainMenuButton,quitButton,title, winnerTitle, winnerScoreTitle);

        return winnerScene;
    }







    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("highScores");
        //PrintWriter write = new PrintWriter("highScores");
        Scanner read = new Scanner(reader);
        int count = 1;
        while(read.hasNext()){
            if(count == 1){
                easyHigh = read.nextInt();
            }
            if(count == 2){
                mediumHigh = read.nextInt();
            }
            if(count == 3){
                highHigh = read.nextInt();
            }
            count ++;
        }
        launch(args);
    }

    @Override
    public void handle(KeyEvent event){
        if(event.getCode() == KeyCode.DOWN && !maze.getMaze()[playRow][playCol].isDownWall()){
            playerYpos += 20;
            recPlayer.setY(playerYpos);
            playRow++;
            moveCount++;
            moveCounterTitle.setText(""+moveCount);

        }
        if(event.getCode() == KeyCode.UP && !maze.getMaze()[playRow][playCol].isUpWall()){
            playerYpos -= 20;
            recPlayer.setY(playerYpos);
            playRow--;
            moveCount++;
            moveCounterTitle.setText(""+moveCount);
        }
        if(event.getCode() == KeyCode.LEFT && !maze.getMaze()[playRow][playCol].isLeftWall()){
            playerXpos -= 20;
            recPlayer.setX(playerXpos);
            playCol--;
            moveCount++;
            moveCounterTitle.setText(""+moveCount);
        }
        if(event.getCode() == KeyCode.RIGHT && !maze.getMaze()[playRow][playCol].isRightWall()){
            playerXpos += 20;
            recPlayer.setX(playerXpos);
            playCol++;
            moveCount++;
            moveCounterTitle.setText(""+moveCount);
        }
        if (playCol == winCol && playRow == maze.getSize() - 1){
            try {
                window.setScene(winnerScene());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}