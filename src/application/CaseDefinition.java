package application;

import java.util.Scanner;

public class CaseDefinition extends CaseQuestion {

	private final String couleur = "bleu";
	private String definition;

	@Override
	public void action(Plateau plateau, Joueur joueur) {
		/*Scanner sc = new Scanner(System.in);
		if (dejaParcourue = true) {
			nouvelleQuestion(plateau);
		}
		System.out.println("la definition :" + this.definition);
		System.out.println("Entrer le mot : ");
		if (this.mot.equalsIgnoreCase(sc.nextLine())) {
			joueur.setScoreActuel(joueur.getScoreActuel() + 20);
			plateau.setCaseActuelle(plateau.getCaseActuelle() + 4);
			System.out.println("vous venez de gagner +20 points ");
			System.out.println("vous venez d'avancer de +4 cases ");
		} else {
			joueur.setScoreActuel(joueur.getScoreActuel() - 10);
			System.out.println("vous venez de perdre -10 points ");
		}
		dejaParcourue = true;
		sc.close();*/

	};

	public void nouvelleQuestion(Plateau plateau) {

	};

	// public void verifieReponse() {} ;
	public CaseDefinition(int num, String def, String mot) {
		this.numero = num;
		this.definition = def;
		this.mot = mot;
		this.type = 4;
	}

	@Override
	public String toString() {
		return "CaseDefinition [couleur=" + couleur + "]";
	}

}