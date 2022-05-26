package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerJeu {

@FXML
private Button ButtonCommencer ;
@FXML
private Button ButtonQuitter ;
@FXML
private Button ButtonReprendre ;
@FXML
private Stage stage ;
private Scene scene ;
private Parent root ;
@FXML
private AnchorPane scenePane ;

public void commencer(Stage stage) throws IOException {
	Plateau plateau=new Plateau() ;
	plateau.initiallisation();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("scenePlateau.fxml")) ; 
	root = loader.load();
	ControleurPlateau ControleurPlateau = loader.getController() ;
	ControleurPlateau.init( plateau);
	this.stage=stage; 
	scene = new Scene(root);
	stage.setScene(scene);
	
	
}
public void quitter(ActionEvent e )
	{
		Alert alert =new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Sortir");
		alert.setHeaderText("Quitter le jeu ");
		alert.setContentText("veux tu vraiment quitter le jeu ?");
		
		if (alert.showAndWait().get() == ButtonType.OK)
		{
			stage =(Stage)scenePane.getScene().getWindow() ;
			stage.close();
		}
	}
	

}
