package application;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CaseImage extends CaseQuestion {
	private final String couleur = "rose";
	private String[] imagesUri;
	private int imageCorrecte;

	public CaseImage(int num, String[] imagesUri, int imageCorrecte, String mot) {
		numero = num;
		this.type = 5;
		this.imageCorrecte = imageCorrecte;
		this.mot = mot;
		this.imagesUri = imagesUri;
		this.dejaParcourue = false;
	}

	@Override
	public void action(Plateau plateau, Joueur joueur) {
		Parent root;
		if (dejaParcourue == true) {
			nouvelleQuestion(plateau);
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource("caseImage.fxml"));
		try {
			root = loader.load();
			ControleurCaseImage Cont = loader.getController();
			Scene scene = new Scene(root, 700, 600);
			Stage stage = new Stage();
			Cont.init(imagesUri, imageCorrecte, mot, stage, joueur, plateau);
			stage.setScene(scene);
			stage.show();
			dejaParcourue = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void nouvelleQuestion(Plateau plateau) {
		CaseImage c = plateau.initCaseImage(this.numero);
		this.imageCorrecte = c.imageCorrecte;
		this.mot = c.mot;
		this.imagesUri = c.imagesUri;
		this.dejaParcourue = false;
	}

	public String toString() {
		return "Case Image ";
	}

}