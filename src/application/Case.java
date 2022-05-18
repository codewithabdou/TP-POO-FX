package application;

public abstract class Case {

    protected int numero ;
    protected  int type ;
    public String getNumero() {
		return String.valueOf(numero+1) ;
	}
	public abstract void action (Plateau plateau , Joueur joueur);
}
