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
		
		Plateau p1 = new Plateau(10);
		p1.AfficherPlateau();
		
		System.out.println("Voulez vous commencer une partie sans paramétrage y/n : ");
		String PartieRapide = sc.nextLine();
		
		if(PartieRapide.toUpperCase().startsWith("N"))
		{
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
					
					p1.AfficherPlateau();
				}
			}			
		}else{
			p1.PlacerBateauAleatoire();
			p1.AfficherPlateau();
		}
		
		while (!p1.getPartieGagne()) {
			boolean bonTir = false;
			while (!bonTir) {
				
				System.out.println("Saisir les coordonnes de placement du tir: ");
				System.out.println(" Saisir x : ");
				int x = sc.nextInt();
	
				System.out.println(" Saisir y : ");
				int y = sc.nextInt();
				
				bonTir = p1.Tir(x, y);
				if(!bonTir)
				{
					System.out.println("Vos coordonné de tire dépasse le tableau");
				}
				
			}
			
			
			p1.AfficherPlateau();
			
		}
		System.out.println("La partie est terminer! Bien jouer vous avez gagné");
	}


}
