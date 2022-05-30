package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CaseDefinition extends CaseQuestion {

	private final String couleur = "bleu";
	private String definition;
	private Parent root;

	@Override
	public void action(Plateau plateau, Joueur joueur) {

		if (dejaParcourue == true) {
			nouvelleQuestion(plateau);
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource("caseDefinition.fxml"));
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ControleurCaseDefinition Controler = loader.getController();
		Scene scene = new Scene(root, 700, 600);
		Stage stage = new Stage();
		Controler.init(definition,mot,joueur,plateau,stage);
		stage.setScene(scene);
		stage.show();
		dejaParcourue = true;

	};

	public void nouvelleQuestion(Plateau plateau) {
		
	};

	public CaseDefinition(int num, String def, String mot) {
		this.numero = num;
		this.definition = def;
		this.mot = mot;
		this.type = 4;
	}

	@Override
	public String toString() {
		return "Case Definition";
	}

}