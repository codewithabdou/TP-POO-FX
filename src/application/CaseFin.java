package application;

public class CaseFin extends Case {

    public CaseFin(){
        numero=99;
        type=7 ;
     }

    private  final String couleur="noir";
    public void action(Plateau plateau , Joueur joueur ){
    	System.out.println("vous");
    }
    @Override
    public String toString() {
        return "CaseFin [couleur=" + couleur + "]";
    };
    

}