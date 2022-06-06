package application;

import java.util.Random;

public class CaseSaut extends Case {
	private final String couleur = "orange";
	private int nb;

	public CaseSaut(int num) {
		numero = num;
		this.type = 6;
	}

	public void action(Plateau plateau, Joueur joueur) {
		Random random = new Random();
		nb = random.nextInt(100);
		plateau.setCaseActuelle(nb);
	}

	@Override
	public String toString() {
		return "Case Saut ";
	};

}
