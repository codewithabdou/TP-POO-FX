package application;

import java.io.File;
import java.io.Serializable;
import java.util.Random;

public class Joueur implements Serializable{
	
	private String nom ;
	private String password;
	private int meilleurScore=0 ;
	private String ID ;
	private int scoreActuel=0;
	
   
	public Joueur(String nom,String password, String ID) {
		this.nom = nom;
		this.password=password;
		this.ID = ID;
	}


	public int  lancerDes() {
		Random random = new Random(); 
		int  de1 = random.nextInt(6) +1  ;
		int  de2 = random.nextInt(6) +1  ;
		return (de1+de2) ;
	} ;
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getMeilleurScore() {
		return meilleurScore;
	}


	public void setMeilleurScore(int meilleurScore) {
		this.meilleurScore = meilleurScore;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public int getScoreActuel() {
		return scoreActuel;
	}


	public void setScoreActuel(int scoreActuel) {
		this.scoreActuel = scoreActuel;
	}


	public String getPassword() {
		return password;
	}

	
}