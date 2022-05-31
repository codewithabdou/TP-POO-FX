import java.io.IOException;

import application.Joueur;
import javafx.application.Application;
import javafx.stage.Stage;
import jeu.Authentification;
import jeu.Jeu;


public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage=new Stage();
        stage.setTitle("TP POO");
        stage.setResizable(false);
        stage.centerOnScreen();
        //Authentification auth = new Authentification(stage);
        Jeu game=new Jeu(stage, new Joueur("nom", "password", "ID") );

        
    }

    public static void main(String[] args) {
        launch();
    }
}
