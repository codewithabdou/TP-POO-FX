package application;


import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CaseImage extends CaseQuestion {
	private final String couleur = "rose";
	private Image[] images;
	private int imageCorrecte;
	private Parent root;
	public CaseImage(int num ,Image[] images ,int imageCorrecte,String mot ) {
		numero = num;
		 this.type=5 ;
		 this.imageCorrecte= imageCorrecte;
		 this.mot=mot;
		 this.images=images ;
		 this.dejaParcourue = false ;
	}

	@Override
	public void action(Plateau plateau, Joueur joueur) {
		if (dejaParcourue ==true) {
			nouvelleQuestion(plateau);
		}
        FXMLLoader loader = new FXMLLoader(getClass().getResource("caseImage.fxml")) ; 
       	try {
			root = loader.load();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	   ControleurCaseImage Cont= loader.getController() ; 
	   Scene scene = new Scene( root,700,600);
	   Stage stage = new Stage ()  ;
	   Cont.init(images ,imageCorrecte,mot ,stage ,joueur,plateau );
	   stage.setScene(scene);
	   stage.show() ;
	   dejaParcourue= true ;

	}
	public void nouvelleQuestion(Plateau plateau){
	 
		CaseImage c = plateau.initCaseImage(this.numero) ;
		this.imageCorrecte= c.imageCorrecte ;
		this.mot=c.mot ;
		this.images =c.images ;
		this.dejaParcourue = false ;
	   
	}

	public String toString() {
		return "Case Image ";
	}


}