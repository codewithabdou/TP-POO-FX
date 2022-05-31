package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javafx.scene.image.Image;

public class Plateau {
	private Joueur joueur;
	private boolean isOver = false;
	private int caseActuelle = 0;
	Case[] cases = new Case[100];
	private String[] definitions = new String[10];
	private String[] motDefinitions = new String[10];
	private Image[] images = new Image[8];
	private String[] motImages = new String[8];
	private static Integer image = 0;

	public Plateau(Joueur joueur) {
		this.joueur = joueur;
		try {
			initiallisation();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initiallisation() throws IOException {

		intDefinitions();
		initImages();
		Random random;
		int caseNumber;
		boolean jobDone = false;
		cases[0] = new CaseDepart();
		for (int i = 0; i < 5; i++) {
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (cases[caseNumber] == null) {
					cases[caseNumber] = new CaseBonus(caseNumber);
					jobDone = true;
				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (cases[caseNumber] == null) {
					cases[caseNumber] = initCaseImage(caseNumber);
					jobDone = true;
				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (cases[caseNumber] == null) {
					cases[caseNumber] = new CaseDefinition(caseNumber, definitions[i], motDefinitions[i]);
					jobDone = true;
				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (cases[caseNumber] == null) {
					cases[caseNumber] = new CaseMallus(caseNumber);
					jobDone = true;
				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (cases[caseNumber] == null) {
					cases[caseNumber] = new CaseSaut(caseNumber);
					jobDone = true;
				}
			}
			jobDone = false;
		}

		for (int i = 1; i != 99; i++) {
			if (cases[i] == null) {
				cases[i] = new CaseParcours(i);
			}
		}
		cases[99] = new CaseFin();
		
	}

	public int getCaseActuelle() {
		return caseActuelle;
	}

	public void initImages() throws IOException {
		String file = "src//application//motImages.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		Integer i = 0;
		String mo;
		while ((mo = br.readLine()) != null) {
			motImages[i] = mo;
			File file1 = new File("ressources//images//image" + (i + 1) + ".PNG");
			Image myImage = new Image(file1.toURI().toString());
			images[i] = myImage;
			i++;
		}
		br.close();
	}

	public void intDefinitions() {

		String file = "definitions.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int i = 0;
			String mot, def;
			while ((mot = br.readLine()) != null) {
				motDefinitions[i] = mot;
				def = br.readLine();
				definitions[i] = def;
				i++;
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void setCaseActuelle(int caseActuelle) {
		this.caseActuelle = caseActuelle;
	}

	public CaseImage initCaseImage(int ID) {
		String mot;
		Random random = new Random();
		mot = motImages[image];

		Image[] imagesChoix = new Image[4];
		int j = random.nextInt(4);
		imagesChoix[j] = images[image];
		int m = 0;
		int p = random.nextInt(8);
		while (m < 4) {
			if ((m != j)) {
				if (p != image)
					imagesChoix[m] = images[p];
				else {
					p = (p + 1) % 8;
					imagesChoix[m] = images[p];
				}
			}
			p = (p + 1) % 8;
			m++;
		}
		CaseImage c = new CaseImage(ID, imagesChoix, j, mot);
		image++;
		return (c);
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public void setIsOver(boolean b) {
		isOver = b;
	}

	public boolean getIsOver() {
		return isOver;
	}

}
