package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Plateau {

	private static int num = 0;
	private int ID;
	private int  caseActuelle = 0;
	Case[] cases = new Case[100];
    private String[] definitions = new String[10];
	private String[] motDefinitions = new String[10];
	private String[] images = new String[10];
	private String[] motImages = {"coffee","orange","eggs","ff","kkk"};
	private Integer  resultatDes ;
    
	public void initiallisation() {
		ID = num;
		num++;
		intDefinitions () ;
		Random random;
		int caseNumber;
		boolean jobDone = false;
		cases[0]=new CaseDepart();
		for (int i = 0; i < 5; i++) {
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (cases[caseNumber]==null) {
					cases[caseNumber]=new CaseBonus(caseNumber);
					jobDone = true;
				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (cases[caseNumber]==null) {
					cases[caseNumber]=new CaseImage(caseNumber);
					jobDone = true;
				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (cases[caseNumber]==null) {
					cases[caseNumber]=new CaseDefinition(caseNumber,definitions[i],motDefinitions[i]);
					jobDone = true;
				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (cases[caseNumber]==null) {
					cases[caseNumber]=new CaseMallus(caseNumber);
					jobDone = true;
				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (cases[caseNumber]==null) {
					cases[caseNumber]=new CaseSaut(caseNumber);
					jobDone = true;
				}
			}
			jobDone = false;
		}

		for (int i = 1; i != 99; i++) {
			if (cases[i]==null) {
				cases[i]=new CaseParcours(i);
			}
		}
		cases[99] = new CaseFin();
	
	   
	}
	
	public int getCaseActuelle() {
		return caseActuelle;
	}

	public void intDefinitions (){
        
		String file = "C://Users//CBS Computer//Desktop//definitions.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
        {   int i =0 ;
            String  mot , def;
            while ((mot= br.readLine()) != null) {
            motDefinitions[i]=mot;
			def= br.readLine() ;
			definitions[i]= def ;
			i++ ;
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
	public void setCaseActuelle(int caseActuelle) {
		this.caseActuelle = caseActuelle;
	}

}
