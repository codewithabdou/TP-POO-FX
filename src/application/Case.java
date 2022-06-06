package application;

import java.io.Serializable;

public abstract class Case implements Serializable {

  protected int numero;
  protected int type;

  public String getNumero() {
    return String.valueOf(numero + 1);
  }

  public abstract void action(Plateau plateau, Joueur joueur);

}
