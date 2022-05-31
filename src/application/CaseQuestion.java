package application;

public abstract class CaseQuestion extends Case {
	
    protected String mot;
    protected boolean dejaParcourue = false;

    public abstract void nouvelleQuestion(Plateau plateau);

    public boolean getIsParcourue() {
        return dejaParcourue;
    }

}
