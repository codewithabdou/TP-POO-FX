package application;

public class CaseMallus extends Case {
	private final String couleur = "rouge";

	public CaseMallus(int num) {
		numero = num;
		this.type=2 ;
	}

	public void action(Plateau plateau, Joueur joueur) {
		joueur.setScoreActuel(joueur.getScoreActuel() - 10);
		plateau.setCaseActuelle(plateau.getCaseActuelle() - 2);

	}

	@Override
	public String toString() {
		return "CaseMallus [couleur=" + couleur + "]";
	};

}
