package application;

import java.io.File;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ControleurPlateau {
	private Case[] cases;
	private Plateau plateau;
	private Joueur joueur;
	@FXML
	private Stage stage;
	@FXML
	ImageView de1, de2;
	@FXML
	private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11,
			button12, button13, button14, button15, button16, button17, button18, button19, button20, button21,
			button22, button23, button24, button25, button26, button27,
			button28, button29, button30, button31, button32, button33, button34, button35, button36, button37,
			button38, button39, button40,
			button41, button42, button43, button44, button45, button46, button47, button48, button49, button50,
			button51, button52, button53, button54, button55, button56, button57, button58, button59, button60,
			button61, button62, button63, button64, button65, button66, button67, button68,
			button69, button70, button71, button72, button73, button74, button75, button76, button77, button78,
			button79, button80, button81, button82,
			button83, button84, button85, button86, button87, button88, button89, button90, button91, button92,
			button93, button94, button95, button96, button97, button98,
			button99, button100;
	private Integer resultatDes;
	@FXML
	Button buttonLancerDes;
	@FXML
	Label label, maPosition, score;
	@FXML
	Rectangle rectangle;
	@FXML
	AnchorPane anchorPane;

	private AnimationTimer timer;

	public void init(Plateau plateau) {
		this.cases = plateau.cases;
		this.plateau = plateau;
		this.joueur = plateau.getJoueur();
		initView();
		initButtons();
	}

	private void initView() {
		maPosition.setStyle("-fx-font-size:25px ;-fx-background-color: #FFD700 ;");
		score.setStyle("-fx-font-size:25px ;-fx-background-color: #FFD700 ;");
		label.setTextFill(Color.BLACK);
		maPosition.setText("1");
		score.setText("0");
		rectangle.setArcWidth(500.0);
		rectangle.setArcHeight(450.0);
		rectangle.setFill(Color.GOLD);
		label.setTextFill(Color.GOLD);
		label.setStyle("-fx-font-size:25px ;");
		buttonLancerDes.setStyle("-fx-background-color: #FFD700 ;");
		anchorPane.setStyle("-fx-background-color: #050505");
	}

	private void initButtons() {
		Button[] buttons = { button1, button2, button3, button4, button5, button6, button7, button8, button9, button10,
				button11, button12, button13, button14, button15, button16, button17, button18, button19, button20,
				button21, button22, button23, button24, button25, button26, button27,
				button28, button29, button30, button31, button32, button33, button34, button35, button36, button37,
				button38, button39, button40, button41, button42, button43, button44, button45, button46, button47,
				button48, button49, button50,
				button51, button52, button53, button54, button55, button56, button57, button58, button59, button60,
				button61, button62, button63, button64, button65, button66, button67, button68,
				button69, button70, button71, button72, button73, button74, button75, button76, button77, button78,
				button79, button80, button81, button82, button83, button84, button85, button86, button87, button88,
				button89, button90, button91, button92,
				button93, button94, button95, button96, button97, button98, button99, button100 };
		buttonPressedHandler(buttons);
		gameLoop(buttons);
	}

	private void initBouton(Button bouton, int i) {
		String textFill = "-fx-text-fill: white ;  -fx-font-size: 18px;-fx-background-radius: 50px ; -outer-shadow-color: rgba(0, 0, 0, 0.85); -fx-effect: dropshadow(three-pass-box, -outer-shadow-color, 5, 0, 0, 2); ";
		String[] styles = { "-fx-background-color: yellow ;", "-fx-background-color: green ;",
				"-fx-background-color: red ; ", "-fx-background-color: gray ;", "-fx-background-color: blue ;",
				"-fx-background-color: pink ; ", "-fx-background-color: orange ; ", "-fx-background-color: black ;" };
		bouton.setText(cases[i].getNumero());
		bouton.setStyle(styles[cases[i].type] + textFill);
	}

	public void lancer(ActionEvent e) {
		Random random = new Random();
		buttonLancerDes.setDisable(true);
		Integer d1 = random.nextInt(6) + 1;
		Integer d2 = random.nextInt(6) + 1;
		File file = new File("ressources/de" + (d1) + ".PNG");
		de1.setImage(new Image(file.toURI().toString()));
		File file2 = new File("ressources/de" + (d2) + ".PNG");
		de2.setImage(new Image(file2.toURI().toString()));
		resultatDes = d1 + d2;
		label.setText(resultatDes.toString());
		if (plateau.getCaseActuelle() + resultatDes > 99) {
			resultatDes = 99 - resultatDes + (99 - plateau.getCaseActuelle()) - plateau.getCaseActuelle();
		}

	}

	private void buttonPressedHandler(Button[] boutons) {
		for (int i = 0; i < boutons.length; i++) {
			int j = i;
			boutons[i].setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent evenet) {
					if ((plateau.getCaseActuelle() + resultatDes) == j) {
						plateau.setCaseActuelle(plateau.getCaseActuelle() + resultatDes);
						buttonLancerDes.setDisable(false);
					}
				}
			});
		}
	}

	private void gameLoop(Button[] buttons) {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (!plateau.getIsOver()) {
					for (int i = 0; i < 100; i++) {
						initBouton(buttons[i], i);
					}
					styleCaseActuelle(buttons);
					cases[plateau.getCaseActuelle()].action(plateau, joueur);
					maPosition.setText(((Integer) (plateau.getCaseActuelle() + 1)).toString());
					score.setText(((Integer) (joueur.getScoreActuel())).toString());
				} else
					buttonLancerDes.setDisable(true);
			}

		};
		timer.start();
	}

	private void styleCaseActuelle(Button[] buttons) {
		buttons[plateau.getCaseActuelle()]
				.setStyle("-fx-text-fill: red ; -fx-font-size:20px; -fx-background-radius:50px ;");
	}

}
