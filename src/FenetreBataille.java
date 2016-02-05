import java.awt.BorderLayout;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Point;

import java.util.Scanner;

public class FenetreBataille /*extends JFrame*/{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		Plateau p1 = new Plateau(12);
		Plateau p2 = new Plateau(12);
		
		p2.setNomJoueurEnnemie("Vous");
		p1.setNomJoueurEnnemie("joueur2 ");
		
		p2.setNomJoueur("joueur2");
		p1.setNomJoueur("Vous");
		
		System.out.println("Le plateau que " + p1.getNomJoueur());
		p1.AfficherPlateau(0);
		
		
		System.out.println("Voulez vous commencer une partie sans paramétrage y/n : ");
		String PartieRapide = sc.nextLine();
		
		if(PartieRapide.toUpperCase().startsWith("N"))
		{
			demandePlacementBateau(sc, p1);			
		}else{
			p1.PlacerBateauAleatoire();
			p1.AfficherPlateau(0);
		}
			p2.PlacerBateauAleatoire();
			
			System.out.println("Le plateau que le " + p2.getNomJoueur());
			p2.AfficherPlateau(0);
			
			demandeDeTire(sc,p2, p1);
			
	}

	
	private static void demandeDeTire(Scanner sc, Plateau p2, Plateau p1) {
		int decompteTire = 20;
		while (decompteTire>0) {
			boolean bonTir = false;
			while (!bonTir) {
				
				System.out.println("Saisir les coordonnes de placement du tir: ");
				System.out.println(" Saisir x : ");
				int x = sc.nextInt();
	
				System.out.println(" Saisir y : ");
				int y = sc.nextInt();
				
				bonTir = p2.Tir(x, y);
				if(!bonTir)
				{
					System.out.println("Vos coordonné de tire dépasse le tableau");
				}				
			}
				p1.TirAleatoire();
				p2.AfficherPlateau(1);
				
			decompteTire--;
			
		}
		verifWinner(p2, p1, decompteTire);
	}


	private static void verifWinner(Plateau p2, Plateau p1, int decompteTire) {
		int nbBatCouleJoueur1 = 0;
		int nbBatCouleIa = 0;
		
		if(decompteTire == 0)
		{		
			for (Bateau bateau : p1.GetListeBateau()) {
				if(bateau.estCoule())
					nbBatCouleJoueur1++;
			}
			for (Bateau bateau : p2.GetListeBateau()) {
				if(bateau.estCoule())
					nbBatCouleIa++;
			}
			if(nbBatCouleJoueur1 > nbBatCouleIa)
				System.out.println("Vous avez perdu cette partie !");
			else if(nbBatCouleJoueur1<nbBatCouleIa)
				System.out.println("Vous avez gagné cette partie !");
			else
				System.out.println("Vous êtes à égalité!");
		}
	}

	private static void demandePlacementBateau(Scanner sc, Plateau p1) {
		for (Bateau bateau : p1.GetListeBateau()) {
			boolean placementBateau = false;
				while (placementBateau == false) {
				
					System.out.println("Saisir les coordonnes de placement du bateau: " + bateau.getNomBateau());
					System.out.println(" Saisir x : ");
					int x = sc.nextInt();
	
					System.out.println(" Saisir y : ");
					int y = sc.nextInt();
					System.out
					.println(" Saisir le sens du bateau(h : horizontale / v : verticale)");
					sc.nextLine();
					String sens = sc.nextLine();
					bateau.setSensBateau(sens);
					
					placementBateau = p1.PlacerBateau(x, y, bateau);
					if(!placementBateau)
					{
						System.out.println("Le bateau dépasse le tableau veuillez entrer les bonnes coordonnées");
					}
					
					p1.AfficherPlateau(0);
				}
			}
	}


}
