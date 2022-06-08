package jeu;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;

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
    private ArrayList<Plateau> plateauxList = new ArrayList<>();
    private Plateau currentPlateau;

    public Jeu(Stage stage, Joueur joueur) {
        this.stage = stage;
        this.joueur = joueur;
        loadPlateaux();
        loadMyPlateau();
        initializeView();
    }

    private void loadPlateaux() {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(new File("Plateaux.dat"))));
            boolean canRead = true;
            while (canRead) {
                try {
                    plateauxList.add((Plateau) in.readObject());
                } catch (ClassNotFoundException e) {
                    canRead = false;
                    e.printStackTrace();
                }
            }
            in.close();
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }

    private void loadMyPlateau() {
        for (Plateau plateau : plateauxList) {
            if (plateau.getID().compareTo(joueur.getID()) == 0) {
                currentPlateau = plateau;
            }
        }
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
        menuSubScenes.add(new MySubScene(WINDOW_WIDTH, (WINDOW_HEIGHT - 500) / 2, 500, 500));
        createLoadGameSubScene();
        createbestScoreSubScene();
    }

    private void createLoadGameSubScene() {
        /*
         * STYLING YA TAOUS
         */
        MySubScene oldGameSubScene = new MySubScene(WINDOW_WIDTH, (WINDOW_HEIGHT - 500) / 2, 500, 500);
        if (currentPlateau != null) {
            Label label = new Label("current position : " + (currentPlateau.getCaseActuelle() + 1));
            label.setFont(new Font("System", 25));
            label.setLayoutX(50);
            label.setLayoutY(200);
            oldGameSubScene.addToPane(label);
            Label label1 = new Label("current score : " + currentPlateau.getJoueur().getScoreActuel());
            label1.setFont(new Font("System", 25));
            label1.setLayoutX(50);
            label1.setLayoutY(280);
            oldGameSubScene.addToPane(label1);
            MyButton loadButton = new MyButton("load", 200, 350);
            loadButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    if (currentPlateau != null)
                        reprendre();
                }

            });
            oldGameSubScene.addToPane(loadButton);
        } else {
            Label label = new Label("No saved game available .");
            label.setFont(new Font("System", 25));
            label.setLayoutX(50);
            label.setLayoutY(200);
            oldGameSubScene.addToPane(label);
        }

        menuSubScenes.add(oldGameSubScene);
        root.getChildren().add(oldGameSubScene);
    }

    private void createbestScoreSubScene() {
        /*
         * TO-DO :
         * need more styling RIGLIHA TAOUS BADLI MM TA3BIR TE3 MIN MYKOUNCH KYN BEST
         * SCORE LMOHIM DABRI RASSEK
         */
        MySubScene bestScoreSubScene = new MySubScene(WINDOW_WIDTH, (WINDOW_HEIGHT - 500) / 2, 500, 500);
        Label bestPlayerName = new Label();
        Label bestPlayerScore = new Label();
        if (bestScore != null) {
            bestPlayerName.setText("Score owner :   " + "  " + bestScore.getName());
            bestPlayerScore.setText("Best Score :   " + "  " + bestScore.getScore());
        } else {
            bestPlayerName.setText("No finished games yet ");
            bestPlayerScore.setText("try to finish a game ");
        }
        bestPlayerName.setLayoutX(50);
        bestPlayerName.setLayoutY(200);
        bestPlayerScore.setLayoutX(50);
        bestPlayerScore.setLayoutY(250);
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
        joueur.setScoreActuel(0);
        Plateau plateau = new Plateau(joueur, plateauxList);
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

    private void reprendre() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenePlateau.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControleurPlateau ControleurPlateau = loader.getController();
        ControleurPlateau.init(currentPlateau);
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
        }
    }

    private void styleLabel(Label label) {
        label.setFont(Font.font("Verdana", 25));
    }

}
