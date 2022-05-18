package application;

public class CaseBonus extends  Case{
	   private  final String couleur= "vert";
	   
	@Override
	   
	   public void action(Plateau plateau , Joueur joueur) {
		   joueur.setScoreActuel(joueur.getScoreActuel()+10);
		   plateau.setCaseActuelle(plateau.getCaseActuelle()+2) ;
		   System.out.println("vous venez de gagner +10 points " );
		   System.out.println("vous venez d'avancer de +2 cases " );
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
