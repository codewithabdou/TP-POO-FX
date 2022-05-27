package application;

public class CaseBonus extends  Case{
	   private  final String couleur= "vert";
	   
	@Override
	   
	   public void action(Plateau plateau , Joueur joueur) {
		   joueur.setScoreActuel(joueur.getScoreActuel()+10);
		   plateau.setCaseActuelle(plateau.getCaseActuelle()+2) ;
	   };

	   @Override
	public String toString() {
		return "CaseBonus [couleur=" + couleur + "]";
	}

	public CaseBonus(int num){
		   numero=num;
			this.type = 1;
	   }
}
