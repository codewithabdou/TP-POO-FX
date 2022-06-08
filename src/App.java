import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import application.Joueur;
import components.Score;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jeu.Authentification;
import jeu.Jeu;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage = new Stage();
        stage.setTitle("TP POO");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("English Dice");
        /*Image icon = new Image("C:\\Users\\LENOVO\\Desktop\\TP-POO-FX\\ressources\\de6.PNG");
        stage.getIcons().add(icon);*/
        Authentification auth = new Authentification(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
