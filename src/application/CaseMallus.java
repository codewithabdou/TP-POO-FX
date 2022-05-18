package application;

public class CaseMallus extends Case {
	private final String couleur = "rouge";

	public CaseMallus(int num) {
		numero = num;
		this.type=2 ;
	}

	public void action(Plateau plateau, Joueur joueur) {
		//joueur.setScoreActuel(joueur.getScoreActuel() - 10);
		//plateau.setCaseActuelle(plateau.getCaseActuelle() - 2);
		System.out.println("vous venez de perdre -10 points " );
		System.out.println("vous venez de reculer de -2 cases " );

	}

	@Override
	public String toString() {
		return "CaseMallus [couleur=" + couleur + "]";
	};

}
