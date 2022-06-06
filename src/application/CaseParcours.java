package application;

public class CaseParcours extends Case {
	private final String couleur = "";

	public CaseParcours(int num) {
		numero = num;
		this.type = 3;
	}

	public void action(Plateau plateau, Joueur joueur) {
	}

	@Override
	public String toString() {
		return "Case Parcours ";
	}; // aucune action

}
