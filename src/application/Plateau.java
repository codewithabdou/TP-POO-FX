package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Plateau implements Serializable {
	private Joueur joueur;
	private boolean isOver = false;
	private int caseActuelle = 0;
	Case[] cases = new Case[100];
	private String[] definitions = new String[10];
	private String[] motDefinitions = new String[10];
	private String[] images = new String[8];
	private String[] motImages = new String[8];
	private static Integer image = 0;
	private static Integer definition = 0;
	private String ID;
	private ArrayList<Plateau> plateaux;

	public Plateau(Joueur joueur, ArrayList<Plateau> plateaux) {
		this.plateaux = plateaux;
		this.joueur = joueur;
		this.ID = joueur.getID();
		try {
			initiallisation();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Plateau> getPlateaux() {
		return plateaux;
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
				if (caseNumber <= 97) {
					if (cases[caseNumber + 2] != null && cases[caseNumber] == null) {
						if (cases[caseNumber + 2].type != 2) {
							cases[caseNumber] = new CaseBonus(caseNumber);
							jobDone = true;
						}
					} else if (cases[caseNumber + 2] == null && cases[caseNumber] == null) {
						cases[caseNumber] = new CaseBonus(caseNumber);
						jobDone = true;
					}

				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (caseNumber <= 97) {
					if (cases[caseNumber + 2] != null && cases[caseNumber] == null) {
						if (cases[caseNumber + 2].type != 2) {
							cases[caseNumber] = initCaseImage(caseNumber);
							jobDone = true;
						}
					} else if (cases[caseNumber + 2] == null && cases[caseNumber] == null) {
						cases[caseNumber] = initCaseImage(caseNumber);
						jobDone = true;
					}

				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (caseNumber <= 95) {
					if (cases[caseNumber + 2] != null && cases[caseNumber] == null) {
						if (cases[caseNumber + 2].type != 2) {
							cases[caseNumber] = new CaseDefinition(caseNumber, definitions[i], motDefinitions[i]);
							definition++; // la derniere question prise ça nous servira pour genere une nouvelle
											// question
											// ;
							if (definition == 10)
								definition = 0;
							jobDone = true;
						}
					} else if (cases[caseNumber + 2] == null && cases[caseNumber] == null) {
						cases[caseNumber] = new CaseDefinition(caseNumber, definitions[i], motDefinitions[i]);
						definition++; // la derniere question prise ça nous servira pour genere une nouvelle question
										// ;
						if (definition == 10)
							definition = 0;
						jobDone = true;
					}

				}
			}
			jobDone = false;
			while (!jobDone) {
				random = new Random();
				caseNumber = random.nextInt(100);
				if (caseNumber >= 2) {
					if (cases[caseNumber - 2] != null && cases[caseNumber] == null) {
						if ((cases[caseNumber - 2].type != 4 && cases[caseNumber - 2].type != 5
								&& cases[caseNumber - 2].type != 1)) {
							cases[caseNumber] = new CaseMallus(caseNumber);
							jobDone = true;
						}
					} else if (cases[caseNumber - 2] == null && cases[caseNumber] == null) {
						cases[caseNumber] = new CaseMallus(caseNumber);
						jobDone = true;
					}
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
			images[i] = file1.toURI().toString();
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

		String[] imagesChoix = new String[4];
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
		if (image == 8)
			image = 0;
		return (c);
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public void setIsOver(boolean b) {
		isOver = b;
	}

	public boolean getIsOver() {
		return (isOver);
	}

	public String getDefinitions(int i) {
		return definitions[i];
	}

	public String getMotDefinitions(int i) {
		return motDefinitions[i];
	}

	public Integer getDefinition() {
		return definition;
	}

	public void setDefinition(Integer definition) {
		Plateau.definition = definition;
	}

	public String getID() {
		return ID;
	}
}
