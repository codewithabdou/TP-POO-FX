package jeu;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Jeu {
    private final int WINDOW_WIDTH = 1024;
    private final int WINDOW_HEIGHT = 780;
    private AnchorPane root;
    private Scene mainScene;
    private Stage stage;
    private String nomJoueur; //nom joueur mnbe3d tetremplaca b object Joueur;

    /*
        hna fi hed screen n7otto l menu te3na 
        li yji fih : new game / load game / best score / changer compte / quit
    */

    public Jeu(Stage stage,String nomJoueur){
        this.stage=stage;
        this.nomJoueur=nomJoueur;
        initializeView();
        sayhello();
    }

    private void initializeView() {
        root = new AnchorPane();
        mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(mainScene);
        stage.show();
    }

    private void sayhello(){
        Label helloLabel = new Label("HELLO "+nomJoueur);
        root.getChildren().addAll(helloLabel);
    }

    
}
