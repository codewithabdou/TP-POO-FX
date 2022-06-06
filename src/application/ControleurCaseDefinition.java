package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import components.*;
import javafx.stage.Stage;

public class ControleurCaseDefinition {
    @FXML
    private Label definitionLabel;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button submitButton;
    private HBox answer;
    private String mot;
    private String word = "";
    private Joueur joueur;
    private Plateau plateau;
    private Stage stage;

    public void init(String definition, String mot, Joueur joueur, Plateau plateau, Stage stage) {
        this.joueur = joueur;
        this.plateau = plateau;
        this.stage = stage;
        definitionLabel.setText(definition);
        this.mot = mot;
        createAnswerField();
        onPressHandler();
    }

    private void createAnswerField() {
        answer = new HBox();
        for (int i = 0; i < mot.length(); i++) {
            LetterTextField letter = new LetterTextField();
            letter.setMaxLength(1);
            letter.setPrefWidth(50);
            letter.setPrefHeight(40);
            letter.setAlignment(Pos.CENTER);
            letter.setStyle(
                    "-fx-font-size: 25;-fx-border-width: 1;-fx-border-radius: 20;-fx-background-color: black;-fx-text-fill: #ffd700;");
            final int j = i;
            letter.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.compareTo("") != 0)
                    this.word = this.word.substring(0, j) + newValue + this.word.substring(j + 1);
                else
                    this.word = this.word.substring(0, j) + " " + this.word.substring(j + 1);
            });
            answer.getChildren().add(letter);
            word += " ";
        }
        answer.setAlignment(Pos.CENTER);
        answer.setPrefWidth(500);
        answer.setPrefHeight(50);
        answer.setSpacing(10);
        answer.setLayoutX((mainPane.getPrefWidth() - answer.getPrefWidth()) / 2);
        answer.setLayoutY(400);
        mainPane.getChildren().add(answer);
    }

    private void onPressHandler() {
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (isRightAnswer()) {
                    joueur.setScoreActuel(joueur.getScoreActuel() + 10);
                    plateau.setCaseActuelle(plateau.getCaseActuelle() + 2);
                } else {
                    joueur.setScoreActuel(joueur.getScoreActuel() - 10);
                }
                stage.close();
            }
        });
    }

    private boolean isRightAnswer() {
        return word.toLowerCase().trim().equals(mot.toLowerCase().trim());
    }

}
