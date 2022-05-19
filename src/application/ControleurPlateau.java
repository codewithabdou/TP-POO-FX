package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControleurPlateau {
	private Case[] cases;
	private Plateau plateau ;
	@FXML
	private Stage stage ;
	private Scene scene ;
	private Parent root ;
	
	@FXML
	private Button button1 ,button2 ,button3 ,button4 ,button5 ,button6,button7,button8,button9,button10,button11 ,button12 ,button13 
	,button14 ,button15 ,button16,button17,button18,button19,button20,button21 ,button22 ,button23 ,button24 ,button25 ,button26,button27,
	button28,button29,button30, button31 ,button32 ,button33 ,button34 ,button35 ,button36,button37,button38,button39,button40 ,
	button41 ,button42 ,button43 ,button44 ,button45 ,button46,button47,button48,button49,button50,button51 ,button52 ,button53 
	,button54 ,button55 ,button56,button57,button58,button59,button60 ,button61 ,button62 ,button63 ,button64 ,button65 ,button66,button67,button68,
	button69,button70 ,button71 ,button72 ,button73 ,button74 ,button75 ,button76,button77,button78,button79,button80 ,button81 ,button82 ,
	button83 ,button84 ,button85 ,button86,button87,button88,button89,button90 ,button91 ,button92 ,button93 ,button94 ,button95 ,button96,button97,button98,
	button99,button100;
	private Integer  resultatDes ;
	@FXML 
	Button buttonLancerDes ;
	@FXML
	Label label ;
	
	public void init (Plateau plateau) {
		 this.cases=plateau.cases ;
		 this.plateau= plateau ;
		   String textFill ="-fx-text-fill: white ;  -fx-font-size: 18px; -fx-background-radius: 50px ;";
	         String[]styles= {"-fx-background-color: yellow ;","-fx-background-color: green ;","-fx-background-color: red ; ","-fx-background-color: gray ;","-fx-background-color: blue ;","-fx-background-color: pink ; ","-fx-background-color: orange ; ","-fx-background-color: black ;"} ;
			 button1.setStyle(styles[cases[0].type]+textFill+"-fx-rotate: 90;");
			 button1.setText("DEBUT");
			 button2.setStyle(styles[cases[1].type]+textFill+"-fx-rotate: 90;");
			 button2.setText(cases[1].getNumero());
			 button3.setStyle(styles[cases[2].type]+textFill);
			 button3.setText(cases[2].getNumero());
			 button4.setStyle(styles[cases[3].type]+textFill);
			 button4.setText(cases[3].getNumero());
			 button5.setStyle(styles[cases[4].type]+textFill);
			 button5.setText(cases[4].getNumero());
			 button6.setStyle(styles[cases[5].type]+textFill+"-fx-rotate: -45;");
			 button6.setText(cases[5].getNumero());
			 button7.setStyle(styles[cases[6].type]+textFill);
			 button7.setText(cases[6].getNumero());
			 button8.setStyle(styles[cases[7].type]+textFill);button8.setText(cases[7].getNumero());
			 button9.setText(cases[8].getNumero()); button9.setStyle(styles[cases[8].type]+textFill);
			 button10.setText(cases[9].getNumero()); button10.setStyle(styles[cases[9].type]+textFill);
			 button11.setText(cases[10].getNumero()); button11.setStyle(styles[cases[10].type]+textFill);
			 button12.setText(cases[11].getNumero()); button12.setStyle(styles[cases[11].type]+textFill);
			 button13.setText(cases[12].getNumero()); button13.setStyle(styles[cases[12].type]+textFill);
			 button14.setText(cases[13].getNumero()); button14.setStyle(styles[cases[13].type]+textFill+"-fx-rotate: 45;");
			 button15.setText(cases[14].getNumero()); button15.setStyle(styles[cases[14].type]+textFill); 
			 button16.setText(cases[15].getNumero()); button16.setStyle(styles[cases[15].type]+textFill);
			 button17.setText(cases[16].getNumero()); button17.setStyle(styles[cases[16].type]+textFill);
			 button18.setText(cases[17].getNumero()); button18.setStyle(styles[cases[17].type]+textFill);
			 button19.setText(cases[18].getNumero()); button19.setStyle(styles[cases[18].type]+textFill);
			 button20.setText(cases[19].getNumero()); button20.setStyle(styles[cases[19].type]+textFill);
			 button21.setText(cases[20].getNumero()); button21.setStyle(styles[cases[20].type]+textFill); 
			 button22.setText(cases[21].getNumero()); button22.setStyle(styles[cases[21].type]+textFill);
			 button23.setText(cases[22].getNumero()); button23.setStyle(styles[cases[22].type]+textFill);
			 button24.setText(cases[23].getNumero()); button24.setStyle(styles[cases[23].type]+textFill);
			 button25.setText(cases[24].getNumero()); button25.setStyle(styles[cases[24].type]+textFill); 
			 button26.setText(cases[25].getNumero()); button26.setStyle(styles[cases[25].type]+textFill);
			 button27.setText(cases[26].getNumero()); button27.setStyle(styles[cases[26].type]+textFill);
			 button28.setText(cases[27].getNumero()); button28.setStyle(styles[cases[27].type]+textFill+"-fx-rotate: -45;");
			 button29.setText(cases[28].getNumero()); button29.setStyle(styles[cases[28].type]+textFill);
			 button30.setText(cases[29].getNumero()); button30.setStyle(styles[cases[29].type]+textFill);
			 button31.setText(cases[30].getNumero()); button31.setStyle(styles[cases[30].type]+textFill);
			 button32.setText(cases[31].getNumero()); button32.setStyle(styles[cases[31].type]+textFill);
			 button33.setText(cases[32].getNumero()); button33.setStyle(styles[cases[32].type]+textFill);
			 button34.setText(cases[33].getNumero()); button34.setStyle(styles[cases[33].type]+textFill);
			 button35.setText(cases[34].getNumero()); button35.setStyle(styles[cases[34].type]+textFill); 
			 button36.setText(cases[35].getNumero()); button36.setStyle(styles[cases[35].type]+textFill);
			 button37.setText(cases[36].getNumero()); button37.setStyle(styles[cases[36].type]+textFill);
			 button38.setText(cases[37].getNumero()); button38.setStyle(styles[cases[37].type]+textFill);
			 button39.setText(cases[38].getNumero()); button39.setStyle(styles[cases[38].type]+textFill);
			 button40.setText(cases[39].getNumero()); button40.setStyle(styles[cases[39].type]+textFill);
			 button41.setText(cases[40].getNumero()); button41.setStyle(styles[cases[40].type]+textFill);
			 button42.setText(cases[41].getNumero()); button42.setStyle(styles[cases[41].type]+textFill);
			 button43.setText(cases[42].getNumero()); button43.setStyle(styles[cases[42].type]+textFill);
			 button44.setText(cases[43].getNumero()); button44.setStyle(styles[cases[43].type]+textFill);
			 button45.setText(cases[44].getNumero()); button45.setStyle(styles[cases[44].type]+textFill); 
			 button46.setText(cases[45].getNumero()); button46.setStyle(styles[cases[45].type]+textFill);
			 button47.setText(cases[46].getNumero()); button47.setStyle(styles[cases[46].type]+textFill);
			 button48.setText(cases[47].getNumero()); button48.setStyle(styles[cases[47].type]+textFill+"-fx-rotate: -45;");
			 button49.setText(cases[48].getNumero()); button49.setStyle(styles[cases[48].type]+textFill);
			 button50.setText(cases[49].getNumero()); button50.setStyle(styles[cases[49].type]+textFill);
			 button51.setText(cases[50].getNumero()); button51.setStyle(styles[cases[50].type]+textFill);
			 button52.setText(cases[51].getNumero()); button52.setStyle(styles[cases[51].type]+textFill);
			 button53.setText(cases[52].getNumero()); button53.setStyle(styles[cases[52].type]+textFill);
			 button54.setText(cases[53].getNumero()); button54.setStyle(styles[cases[53].type]+textFill+"-fx-rotate: 45;");
			 button55.setText(cases[54].getNumero()); button55.setStyle(styles[cases[54].type]+textFill); 
			 button56.setText(cases[55].getNumero()); button56.setStyle(styles[cases[55].type]+textFill);
			 button57.setText(cases[56].getNumero()); button57.setStyle(styles[cases[56].type]+textFill);
			 button58.setText(cases[57].getNumero()); button58.setStyle(styles[cases[57].type]+textFill);
			 button59.setText(cases[58].getNumero()); button59.setStyle(styles[cases[58].type]+textFill);
			 button60.setText(cases[59].getNumero()); button60.setStyle(styles[cases[59].type]+textFill);
			 button61.setText(cases[60].getNumero()); button61.setStyle(styles[cases[60].type]+textFill);
			 button62.setText(cases[61].getNumero()); button62.setStyle(styles[cases[61].type]+textFill);
			 button63.setText(cases[62].getNumero()); button63.setStyle(styles[cases[62].type]+textFill);
			 button64.setText(cases[63].getNumero()); button64.setStyle(styles[cases[63].type]+textFill);
			 button65.setText(cases[64].getNumero()); button65.setStyle(styles[cases[64].type]+textFill); 
			 button66.setText(cases[65].getNumero()); button66.setStyle(styles[cases[65].type]+textFill+"-fx-rotate: -45;");
			 button67.setText(cases[66].getNumero()); button67.setStyle(styles[cases[66].type]+textFill);
			 button68.setText(cases[67].getNumero()); button68.setStyle(styles[cases[67].type]+textFill);
			 button69.setText(cases[68].getNumero()); button69.setStyle(styles[cases[68].type]+textFill);
			 button70.setText(cases[69].getNumero()); button70.setStyle(styles[cases[69].type]+textFill);
			 button71.setText(cases[70].getNumero()); button71.setStyle(styles[cases[70].type]+textFill);
			 button72.setText(cases[71].getNumero()); button72.setStyle(styles[cases[71].type]+textFill);
			 button73.setText(cases[72].getNumero()); button73.setStyle(styles[cases[72].type]+textFill);
			 button74.setText(cases[73].getNumero()); button74.setStyle(styles[cases[73].type]+textFill);
			 button75.setText(cases[74].getNumero()); button75.setStyle(styles[cases[74].type]+textFill); 
			 button76.setText(cases[75].getNumero()); button76.setStyle(styles[cases[75].type]+textFill);
			 button77.setText(cases[76].getNumero()); button77.setStyle(styles[cases[76].type]+textFill);
			 button78.setText(cases[77].getNumero()); button78.setStyle(styles[cases[77].type]+textFill);
			 button79.setText(cases[78].getNumero()); button79.setStyle(styles[cases[78].type]+textFill);
			 button80.setText(cases[79].getNumero()); button80.setStyle(styles[cases[79].type]+textFill);
			 button81.setText(cases[80].getNumero()); button81.setStyle(styles[cases[80].type]+textFill);
			 button82.setText(cases[81].getNumero()); button82.setStyle(styles[cases[81].type]+textFill);
			 button83.setText(cases[82].getNumero()); button83.setStyle(styles[cases[82].type]+textFill+"-fx-rotate: 45;");
			 button84.setText(cases[83].getNumero()); button84.setStyle(styles[cases[83].type]+textFill);
			 button85.setText(cases[84].getNumero()); button85.setStyle(styles[cases[84].type]+textFill); 
			 button86.setText(cases[85].getNumero()); button86.setStyle(styles[cases[85].type]+textFill);
			 button87.setText(cases[86].getNumero()); button87.setStyle(styles[cases[86].type]+textFill);
			 button88.setText(cases[87].getNumero()); button88.setStyle(styles[cases[87].type]+textFill);
			 button89.setText(cases[88].getNumero()); button89.setStyle(styles[cases[88].type]+textFill);
			 button90.setText(cases[89].getNumero()); button90.setStyle(styles[cases[89].type]+textFill);
			 button91.setText(cases[90].getNumero()); button91.setStyle(styles[cases[90].type]+textFill);
			 button92.setText(cases[91].getNumero()); button92.setStyle(styles[cases[91].type]+textFill+"-fx-rotate: -45;");
			 button93.setText(cases[92].getNumero()); button93.setStyle(styles[cases[92].type]+textFill);
			 button94.setText(cases[93].getNumero()); button94.setStyle(styles[cases[93].type]+textFill);
			 button95.setText(cases[94].getNumero()); button95.setStyle(styles[cases[94].type]+textFill); 
			 button96.setText(cases[95].getNumero()); button96.setStyle(styles[cases[95].type]+textFill);
			 button97.setText(cases[96].getNumero()); button97.setStyle(styles[cases[96].type]+textFill);
			 button98.setText(cases[97].getNumero()); button98.setStyle(styles[cases[97].type]+textFill);
			 button99.setText(cases[98].getNumero()); button99.setStyle(styles[cases[98].type]+textFill);
			 button100.setText("FIN"); button100.setStyle(styles[cases[99].type]+textFill);

	}
	public void lancerDes(ActionEvent e) {
		Random random = new Random();
		resultatDes =random.nextInt(12)+1 ;
		label.setText(resultatDes.toString());
	}
	public void actionBouton(ActionEvent e) {
		 String str = ((Node) e.getSource()).getId() ;
	     String[] arrOfStr = str.split("on", 2);
	 if (plateau.getCaseActuelle()+resultatDes == Integer.parseInt(arrOfStr[1]))	
			 {
		     cases[Integer.parseInt(arrOfStr[1])].action(null, null);
			 System.out.println( cases[Integer.parseInt(arrOfStr[1])-1].toString());
			 this.plateau.setCaseActuelle(plateau.getCaseActuelle()+ resultatDes);
			 }
	
	 else 
	 {
		 System.out.println("ce n'est pas la bonne case");
	 }
	 
	}

}
