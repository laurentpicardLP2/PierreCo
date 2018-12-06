package menu;

import java.util.Scanner;

public class GestionMenu {
	static Scanner scanner;
	
	public static int AffichMenu() {
		int choix=0;
		String saisie;
		boolean bSaisie = false;
		scanner = new Scanner(System.in);
		
		do {
			System.out.println("1.Uploader une video");
			System.out.println("2.Choisir une video");
			System.out.println("3.Quitter");
			System.out.print("Votre choix [1-3] : ");
			saisie = scanner.nextLine();
			
			if (saisie.matches("[1-3]")) {
				choix = Integer.parseInt(saisie);
				return choix;
			}
		}while(!bSaisie);
		return choix;
	}
	
	public static String showVideo() {
		int choix=0;
		String saisie;
		boolean bSaisie = false;
		scanner = new Scanner(System.in);
		
		do {
			System.out.println("1.NeryPool");
			System.out.println("2.Thovex");
			System.out.print("Votre choix [1-2] : ");
			saisie = scanner.nextLine();
			
			if (saisie.matches("[1-2]")) {
				choix = Integer.parseInt(saisie);
				switch(choix) {
					case 1 : return "NeryPool";
					case 2 : return "Thovex";
				}
			}
		}while(!bSaisie);
		return "";
		
	}
}
