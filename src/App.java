import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import jeu.Authentification;


public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage=new Stage();
        stage.setTitle("TP POO");
        stage.setResizable(false);
        Authentification game = new Authentification(stage);
        
    }

    public static void main(String[] args) {
        launch();
    }
}
