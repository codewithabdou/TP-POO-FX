package jeu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

    // lazem nzidou fonction ta7kam l fichier te3 les joueurs w a y7othom f arraylist te3 les joueurs

    public Authentification(Stage stage) {
        this.stage = stage;
        initializeView();
        createBackground();
        createButtons();
        createSubScenes();
    }

    private void initializeView() {
        root = new AnchorPane();
        mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(mainScene);
        stage.show();
    }

    private void createBackground() {
        Background background = new Background(new BackgroundImage(
                new Image("C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/black.png", 256,
                        256, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null));
        root.setBackground(background);
    }

    private void createButtons() {
        inscrireButton = new MyButton("S'inscrire", 150, 380);
        inscrireButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (!identifierSubScene.getIsHidden())
                    identifierSubScene.move(WINDOW_WIDTH);
                inscrireSubScene.move(WINDOW_WIDTH);
            }
        });
        identifierButton = new MyButton("S'identifier", 150, 300);
        identifierButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (!inscrireSubScene.getIsHidden())
                    inscrireSubScene.move(WINDOW_WIDTH);
                identifierSubScene.move(WINDOW_WIDTH);
            }
        });
        root.getChildren().addAll(inscrireButton, identifierButton);
    }

    private void createSubScenes() {
        createInscrireSubScene();
        createIdentifierSubScene();
    }

    private void createInscrireSubScene() {
        inscrireSubScene = new MySubScene(WINDOW_WIDTH, (WINDOW_HEIGHT - 500) / 2, 500, 500);
        Label usernameLabel = new Label("Nom d'utilisateur : ");
        usernameLabel.setLayoutX(30);
        usernameLabel.setLayoutY(120);
        try {
            usernameLabel.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            "C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/kenvector_future.ttf")),
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
                            "C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/kenvector_future.ttf")),
                    16));
        } catch (FileNotFoundException e) {
            usernameTextField.setFont(Font.font("Verdana", 16));
        }

        Label passwordLabel = new Label("Mot de passe : ");
        passwordLabel.setLayoutX(30);
        passwordLabel.setLayoutY(170);
        try {
            passwordLabel.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            "C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/kenvector_future.ttf")),
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
                            "C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/kenvector_future.ttf")),
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
                            "C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/kenvector_future.ttf")),
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
                            "C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/kenvector_future.ttf")),
                    16));
        } catch (FileNotFoundException e) {
            confirmationTextField.setFont(Font.font("Verdana", 16));
        }

        MyButton confirmButton = new MyButton("Confirmer", (500 - 190) / 2, 350);

        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evnet){
                // hna nverifou whd les conditions 
                //ida mverfyin najoutouh lel fichier te3na sinon ndiroulh message
                Jeu jeu = new Jeu(stage, usernameTextField.getText());

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
        Label usernameLabel = new Label("Nom d'utilisateur : ");
        usernameLabel.setLayoutX(30);
        usernameLabel.setLayoutY(120);
        try {
            usernameLabel.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            "C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/kenvector_future.ttf")),
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
                            "C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/kenvector_future.ttf")),
                    16));
        } catch (FileNotFoundException e) {
            usernameTextField.setFont(Font.font("Verdana", 16));
        }

        Label passwordLabel = new Label("Mot de passe : ");
        passwordLabel.setLayoutX(30);
        passwordLabel.setLayoutY(170);
        try {
            passwordLabel.setFont(Font.loadFont(
                    new FileInputStream(new File(
                            "C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/kenvector_future.ttf")),
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
                            "C:/Users/LENOVO/Desktop/TP-POO-FX/TP/ressources/kenvector_future.ttf")),
                    16));
        } catch (FileNotFoundException e) {
            passwordTextField.setFont(Font.font("Verdana", 16));
        }

        MyButton confirmButton = new MyButton("Continuer", (500 - 190) / 2, 350);

        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
           public void handle(ActionEvent evnet){
               // nverifou est ce que sah yexister fel arraylist te3na
               // ida yexister ncreeou object Jeu w ida myexistich beyna ndiroulh kch message w sayi
               Jeu jeu = new Jeu(stage, usernameTextField.getText());
           } 
        });

        identifierSubScene.addToPane(confirmButton);
        identifierSubScene.addToPane(usernameLabel);
        identifierSubScene.addToPane(usernameTextField);
        identifierSubScene.addToPane(passwordLabel);
        identifierSubScene.addToPane(passwordTextField);
        root.getChildren().add(identifierSubScene);
    }

}
