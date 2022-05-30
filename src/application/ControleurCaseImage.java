package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControleurCaseImage {
    @FXML
    private Label mot;
    @FXML
    private ImageView Image1, image2, image3, image4;
    @FXML
    private Button boutonReponse;
    private int reponse;
    private Stage stage;
    Boolean reussir = false;
    Plateau plateau;
    Joueur joueur;

    public void init(Image[] images, int reponse, String word, Stage stage, Joueur joueur, Plateau plateau) {
        this.reponse = reponse;
        this.stage = stage;
        this.joueur = joueur;
        this.plateau = plateau;
        mot.setText(word);
        Image1.setImage(images[0]);
        image2.setImage(images[1]);
        image3.setImage(images[2]);
        image4.setImage(images[3]);
        boutonReponse.setDisable(true);
        imagePressedHandler();

    }

    public void imagePressedHandler() {
        ImageView[] images = { Image1, image2, image3, image4 };
        for (int i = 0; i < 4; i++) {
            int j = i;
            images[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent evenet) {
                    images[j].setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.9), 10, 0, 0, 0);");
                    ;
                    boutonReponse.setDisable(false);
                    if (reponse == j) {
                        reussir = true;
                    }
                }
            });
        }
    }

    public void soumetre(ActionEvent e) {

        if (this.reussir == true) {
            joueur.setScoreActuel(joueur.getScoreActuel() + 10);
            plateau.setCaseActuelle(plateau.getCaseActuelle() + 2);
        } else {
            joueur.setScoreActuel(joueur.getScoreActuel() - 10);
        }
        stage.close();
    }
}
