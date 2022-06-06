package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jeu.Jeu;

public class ControleurGagner {
  AnchorPane anchorPane;
  @FXML
  Label score;
  @FXML
  Button retour;
  private Joueur joueur;
  private Stage stage, stage2;

  public void init(Joueur joueur, Stage stage, Stage stage2) {
    this.joueur = joueur;
    this.stage = stage;
    this.stage2 = stage2;
    score.setText(((Integer) (joueur.getScoreActuel())).toString());

  }

  public void retour(ActionEvent e) {
    stage.close();
    stage2.close();
    Jeu game = new Jeu(new Stage(), joueur);
  }
}
