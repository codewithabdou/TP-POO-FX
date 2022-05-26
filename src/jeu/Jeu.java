package jeu;

import java.io.IOException;
import java.util.ArrayList;

import application.ControllerJeu;
import application.Joueur;
import components.MyButton;
import components.MySubScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class Jeu {
    private final int WINDOW_WIDTH = 1024;
    private final int WINDOW_HEIGHT = 780;
    private AnchorPane root;
    private Scene mainScene;
    private Stage stage;
    private ArrayList<MyButton> menuButtons = new ArrayList<>();
    private ArrayList<MySubScene> menuSubScenes = new ArrayList<>();
    private Joueur joueur; // nom joueur mnbe3d tetremplaca b object Joueur;

    /*
     * hna fi hed screen n7otto l menu te3na
     * li yji fih : new game / load game / best score / changer compte / quit
     */

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
        MySubScene bestScoreSubScene = new MySubScene(WINDOW_WIDTH, (WINDOW_HEIGHT - 500) / 2, 500, 500);
        menuSubScenes.add(bestScoreSubScene);
        root.getChildren().addAll(newGameSubScene, oldGameSubScene, bestScoreSubScene);
    }

    private void onPressHandler() {
        for (MyButton button : menuButtons) {
            button.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    if (button.equals(menuButtons.get(3))) {
                        Authentification authentification = new Authentification(stage);
                    } else if (button.equals(menuButtons.get(4))) {
                        ControllerJeu jeu=new ControllerJeu();
                        try {
                            jeu.commencer(stage);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } else {
                        for (MySubScene subScene : menuSubScenes) {
                            if (!subScene.getIsHidden() || subScene.equals(menuSubScenes.get(menuButtons.indexOf(button)))){
                                subScene.move(WINDOW_WIDTH);
                                System.out.println(menuSubScenes.indexOf(subScene));
                            }
                        }
                    }
                }
            });

        }
    }


}
