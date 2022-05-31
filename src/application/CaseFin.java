package application;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import components.Score;

public class CaseFin extends Case {

    public CaseFin() {
        numero = 99;
        type = 7;
    }

    private final String couleur = "noir";

    public void action(Plateau plateau, Joueur joueur) {
        plateau.setIsOver(true);
        Score score;
        ObjectInputStream file;
        try {
            file = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(new File("score.dat"))));
            try {
                score = (Score) file.readObject();
                if (score.getScore() < joueur.getScoreActuel()) {
                    file.close();
                    score = new Score(joueur.getScoreActuel(), joueur.getNom());
                    ObjectOutputStream file1;
                    try {
                        file1 = new ObjectOutputStream(
                                new BufferedOutputStream(new FileOutputStream(new File("score.dat"))));
                        file1.writeObject(score);
                        file1.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Case Fin ";
    };

}