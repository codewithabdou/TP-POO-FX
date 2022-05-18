package jeu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;

import application.Joueur;
import components.MyButton;
import components.MySubScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Authentification {
    private final int WINDOW_WIDTH = 1024;
    private final int WINDOW_HEIGHT = 780;
    private AnchorPane root;
    private Scene mainScene;
    private Stage stage;
    private MyButton inscrireButton;
    private MyButton identifierButton;
    private MySubScene inscrireSubScene;
    private MySubScene identifierSubScene;
    private ArrayList<Joueur> joueurs = new ArrayList<>();
    private final String FONT_PATH = "ressources/kenvector_future.ttf";

    // lazem nzidou fonction ta7kam l fichier te3 les joueurs w a y7othom f
    // arraylist te3 les joueurs

    public Authentification(Stage stage) {
        this.stage = stage;
        initializeView();
        createBackground();
        createButtons();
        createSubScenes();
        loadPlayers();
        for (Joueur joueur : joueurs) {
            System.out.println(joueur.getNom());
        }
    }

    private void initializeView() {
        root = new AnchorPane();
        mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(mainScene);
        stage.show();
    }

    private void createBackground() {
        Background background = new Background(new BackgroundImage(
                new Image("file:ressources/black.png", 256,
                        256, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null));
        root.setBackground(background);
    }

    private void createButtons() {
        inscrireButton = new MyButton("Sign up", 150, 380);
        inscrireButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (!identifierSubScene.getIsHidden())
                    identifierSubScene.move(WINDOW_WIDTH);
                inscrireSubScene.move(WINDOW_WIDTH);
            }
        });
        identifierButton = new MyButton("Sign in", 150, 300);
        identifierButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (!inscrireSubScene.getIsHidden())
                    inscrireSubScene.move(WINDOW_WIDTH);
                identifierSubScene.move(WINDOW_WIDTH);
            }
        });
        MyButton quitButton = new MyButton("Quit", 150, 460);
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
        root.getChildren().addAll(inscrireButton, identifierButton, quitButton);
    }

    private void createSubScenes() {
        createInscrireSubScene();
        createIdentifierSubScene();
    }

    private void createInscrireSubScene() {
        inscrireSubScene = new MySubScene(WINDOW_WIDTH, (WINDOW_HEIGHT - 500) / 2, 500, 500);
        Label usernameLabel = new Label("user name : ");
        usernameLabel.setLayoutX(30);
        usernameLabel.setLayoutY(120);
        try {
            usernameLabel.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            FONT_PATH)),
                    16));
        } catch (FileNotFoundException e) {
            usernameLabel.setFont(Font.font("Verdana", 16));
        }

        TextField usernameTextField = new TextField();
        usernameTextField.setLayoutX(240);
        usernameTextField.setLayoutY(115);
        try {
            usernameTextField.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            FONT_PATH)),
                    16));
        } catch (FileNotFoundException e) {
            usernameTextField.setFont(Font.font("Verdana", 16));
        }

        Label passwordLabel = new Label("password : ");
        passwordLabel.setLayoutX(30);
        passwordLabel.setLayoutY(170);
        try {
            passwordLabel.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            FONT_PATH)),
                    16));
        } catch (FileNotFoundException e) {
            passwordLabel.setFont(Font.font("Verdana", 16));
        }

        TextField passwordTextField = new TextField();
        passwordTextField.setLayoutX(240);
        passwordTextField.setLayoutY(165);
        try {
            passwordTextField.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            FONT_PATH)),
                    16));
        } catch (FileNotFoundException e) {
            passwordTextField.setFont(Font.font("Verdana", 16));
        }

        Label confirmationLabel = new Label("confirmation : ");
        confirmationLabel.setLayoutX(30);
        confirmationLabel.setLayoutY(220);
        try {
            confirmationLabel.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            FONT_PATH)),
                    16));
        } catch (FileNotFoundException e) {
            confirmationLabel.setFont(Font.font("Verdana", 16));
        }

        TextField confirmationTextField = new TextField();
        confirmationTextField.setLayoutX(240);
        confirmationTextField.setLayoutY(215);
        try {
            confirmationTextField.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            FONT_PATH)),
                    16));
        } catch (FileNotFoundException e) {
            confirmationTextField.setFont(Font.font("Verdana", 16));
        }

        MyButton confirmButton = new MyButton("Confirm", (500 - 190) / 2, 350);

        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evnet) {
                Joueur joueur = new Joueur(usernameTextField.getText(), passwordTextField.getText(),
                        UUID.randomUUID().toString());
                if (!verifyPlayerExistence(joueur)
                        && confirmationTextField.getText().compareTo(passwordTextField.getText()) == 0
                        && passwordTextField.getText().length() >= 8 && joueur.getNom().length() >= 3) {
                    ObjectOutputStream out;
                    try {
                        out = new ObjectOutputStream(
                                new BufferedOutputStream(new FileOutputStream(new File("Joueurs.dat"))));
                        for (Joueur joueur2 : joueurs) {
                            out.writeObject(joueur2);
                        }
                        out.writeObject(joueur);
                        out.close();
                        Jeu jeu = new Jeu(stage, joueur);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        });

        inscrireSubScene.addToPane(confirmButton);
        inscrireSubScene.addToPane(confirmationLabel);
        inscrireSubScene.addToPane(confirmationTextField);
        inscrireSubScene.addToPane(usernameLabel);
        inscrireSubScene.addToPane(usernameTextField);
        inscrireSubScene.addToPane(passwordLabel);
        inscrireSubScene.addToPane(passwordTextField);
        root.getChildren().add(inscrireSubScene);

    }

    private void createIdentifierSubScene() {
        identifierSubScene = new MySubScene(WINDOW_WIDTH, (WINDOW_HEIGHT - 500) / 2, 500, 500);
        Label usernameLabel = new Label("user name : ");
        usernameLabel.setLayoutX(30);
        usernameLabel.setLayoutY(120);
        try {
            usernameLabel.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            FONT_PATH)),
                    16));
        } catch (FileNotFoundException e) {
            usernameLabel.setFont(Font.font("Verdana", 16));
        }

        TextField usernameTextField = new TextField();
        usernameTextField.setLayoutX(240);
        usernameTextField.setLayoutY(115);
        try {
            usernameTextField.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            FONT_PATH)),
                    16));
        } catch (FileNotFoundException e) {
            usernameTextField.setFont(Font.font("Verdana", 16));
        }

        Label passwordLabel = new Label("password : ");
        passwordLabel.setLayoutX(30);
        passwordLabel.setLayoutY(170);
        try {
            passwordLabel.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            FONT_PATH)),
                    16));
        } catch (FileNotFoundException e) {
            passwordLabel.setFont(Font.font("Verdana", 16));
        }

        TextField passwordTextField = new TextField();
        passwordTextField.setLayoutX(240);
        passwordTextField.setLayoutY(165);
        try {
            passwordTextField.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            FONT_PATH)),
                    16));
        } catch (FileNotFoundException e) {
            passwordTextField.setFont(Font.font("Verdana", 16));
        }

        MyButton confirmButton = new MyButton("Continue", (500 - 190) / 2, 350);

        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evnet) {
                if (getSelectedPlayer(usernameTextField.getText()) != null) {
                    Joueur joueur = getSelectedPlayer(usernameTextField.getText());
                    if (joueur.getPassword().compareTo(passwordTextField.getText()) == 0) {
                        Jeu jeu = new Jeu(stage, joueur);
                    }
                }
            }
        });

        identifierSubScene.addToPane(confirmButton);
        identifierSubScene.addToPane(usernameLabel);
        identifierSubScene.addToPane(usernameTextField);
        identifierSubScene.addToPane(passwordLabel);
        identifierSubScene.addToPane(passwordTextField);
        root.getChildren().add(identifierSubScene);
    }

    private void loadPlayers() {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(new File("Joueurs.dat"))));
            boolean canRead = true;
            while (canRead) {
                try {
                    joueurs.add((Joueur) in.readObject());
                } catch (ClassNotFoundException e) {
                    canRead = false;
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    private boolean verifyPlayerExistence(Joueur joueur) {
        for (Joueur joueur2 : joueurs) {
            if (joueur2.getNom().compareTo(joueur.getNom()) == 0) {
                return true;
            }
        }
        return false;
    }

    private Joueur getSelectedPlayer(String name) {
        for (Joueur joueur : joueurs) {
            if (joueur.getNom().compareTo(name) == 0) {
                return joueur;
            }
        }
        return null;
    }

}
