import java.io.IOException;

import application.Joueur;
import javafx.application.Application;
import javafx.stage.Stage;
import jeu.Jeu;


public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage=new Stage();
        stage.setTitle("TP POO");
        stage.setResizable(false);
        stage.centerOnScreen();
        Jeu game = new Jeu(stage,new Joueur("nom", "password", "ID"));
        
    }

    public static void main(String[] args) {
        launch();
    }
}
