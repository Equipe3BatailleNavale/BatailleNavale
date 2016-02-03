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
		
		Plateau p1 = new Plateau();
		p1.AfficherPlateau();
		
		for (Bateau bateau : p1.GetListeBateau()) {
			
			System.out.println("Saisir les coordonnes de placement du bateau de taille : ");
			System.out.println(" Saisir x : ");
			int x = sc.nextInt();

			System.out.println(" Saisir y : ");
			int y = sc.nextInt();
			System.out
			.println(" Saisir le sens du bateau(h : horizontale / v : verticale)");
			sc.nextLine();
			String sens = sc.nextLine();
			bateau.setSensBateau(sens);
			
			p1.PlacerBateau(x, y, sens, bateau.getTailleBat());
			p1.AfficherPlateau();
		}
			
			
	}
		
//        super();
// 
//        setSize(700, 300);
//        setTitle("Grille de jeu");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        Object[][] donnees = {
//                {"vide", "vide", "vide"},
//                {"Vide", "vide", "vide"},
//                {"Vide", "vide", "vide"},
//                
//        };
// 
//        String[] entetes = {"A", "B", "C"};
// 
//        JTable tableau = new JTable(donnees, entetes);
//        
// 
//        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
//        getContentPane().add(tableau, BorderLayout.CENTER);
// 
//        pack();
//    }
// 
//    public static void main(String[] args) {
//        new FenetreBataille().setVisible(true);
//    }


}
