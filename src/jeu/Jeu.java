package jeu;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import application.ControleurPlateau;
import application.Joueur;
import application.Plateau;
import components.MyButton;
import components.MySubScene;
import components.Score;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Jeu {
    private final int WINDOW_WIDTH = 1024;
    private final int WINDOW_HEIGHT = 780;
    private AnchorPane root;
    private Scene mainScene;
    private Stage stage;
    private ArrayList<MyButton> menuButtons = new ArrayList<>();
    private ArrayList<MySubScene> menuSubScenes = new ArrayList<>();
    private Joueur joueur;
    private Score bestScore;
    private final String FONT_PATH = "ressources/kenvector_future.ttf";


    public Jeu(Stage stage, Joueur joueur) {
        this.stage = stage;
        this.joueur = joueur;
        initializeView();
    }

    private void initializeView() {
        root = new AnchorPane();
        mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(mainScene);
        createBackground();
        loadBestScore();
        createMenu();
        stage.show();
    }

    private void createBackground() {
        Background background = new Background(new BackgroundImage(
                new Image("file:ressources/black.png", 256,
                        256, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null));
        root.setBackground(background);
    }

    private void createMenu() {
        createButtons();
        createSubScenes();
        onPressHandler();
    }

    private void createButtons() {
        MyButton newGameButton = new MyButton("new game", 150, 200);
        menuButtons.add(newGameButton);
        MyButton oldGameButton = new MyButton("load game", 150, 280);
        menuButtons.add(oldGameButton);
        MyButton bestScoreButton = new MyButton("Score", 150, 360);
        menuButtons.add(bestScoreButton);
        MyButton changeProfilButton = new MyButton("deconnect", 150, 440);
        menuButtons.add(changeProfilButton);
        MyButton quitButton = new MyButton("Quit", 150, 520);
        menuButtons.add(quitButton);
        root.getChildren().addAll(newGameButton, oldGameButton, bestScoreButton, changeProfilButton, quitButton);
    }

    private void createSubScenes() {
        MySubScene newGameSubScene = new MySubScene(WINDOW_WIDTH, (WINDOW_HEIGHT - 500) / 2, 500, 500);
        menuSubScenes.add(newGameSubScene);
        MySubScene oldGameSubScene = new MySubScene(WINDOW_WIDTH, (WINDOW_HEIGHT - 500) / 2, 500, 500);
        menuSubScenes.add(oldGameSubScene);
        createbestScoreSubScene();
        root.getChildren().addAll(newGameSubScene, oldGameSubScene);
    }

    private void createbestScoreSubScene() {
        /*
         * TO-DO :
         * need more styling
         */
        MySubScene bestScoreSubScene = new MySubScene(WINDOW_WIDTH, (WINDOW_HEIGHT - 500) / 2, 500, 500);
        Label bestPlayerName = new Label("Score owner :   " + "  " + bestScore.getName());
        if(bestScore.getName().compareTo("name")==0) bestPlayerName.setText("Score owner :   unknown  " );
        bestPlayerName.setLayoutX(50);
        bestPlayerName.setLayoutY(150);
        Label bestPlayerScore = new Label("Best Score :   " + "  " + bestScore.getScore());
        bestPlayerScore.setLayoutX(50);
        bestPlayerScore.setLayoutY(200);
        styleLabel(bestPlayerName);
        styleLabel(bestPlayerScore);
        bestScoreSubScene.addToPane(bestPlayerName);
        bestScoreSubScene.addToPane(bestPlayerScore);
        menuSubScenes.add(bestScoreSubScene);
        root.getChildren().add(bestScoreSubScene);
    }

    private void onPressHandler() {
        for (MyButton button : menuButtons) {
            button.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    if (button.equals(menuButtons.get(3))) {
                        Authentification authentification = new Authentification(stage);
                    } else if (button.equals(menuButtons.get(4))) {
                        stage.close();
                    } else if (button.equals(menuButtons.get(0))) {
                        commencer();
                    } else {
                        for (MySubScene subScene : menuSubScenes) {
                            if (!subScene.getIsHidden()
                                    || subScene.equals(menuSubScenes.get(menuButtons.indexOf(button)))) {
                                subScene.move(WINDOW_WIDTH);
                            }
                        }
                    }
                }
            });

        }
    }

    private void commencer() {
        Plateau plateau = new Plateau(joueur);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenePlateau.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControleurPlateau ControleurPlateau = loader.getController();
        ControleurPlateau.init(plateau);
        stage.setResizable(true);
        stage.setScene(new Scene(root));
        stage.setFullScreen(true);
    }

    private void loadBestScore() {
        ObjectInputStream file;
        try {
            file = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(new File("score.dat"))));
            try {
                bestScore = (Score) file.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void styleLabel(Label label){
        label.setFont(Font.font("Verdana", 25));
    }

}
