// Programme: Affiche les regles dans un JTextArea
// Date: 18.06.12
// Tire de: http://www.java2s.com/Code/JavaAPI/javax.swing/JTextAreasetLineWrapbooleanwrap.htm

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class FenetreRegles extends JFrame {
	
	static String lesRegles = "Regles de la bataille navale: Chaque joueur a 5 bateaux qu'il place sur les 100 cases disponibles. \n Il peut les placer horizontalement ou verticalement, mais pas en diagonale."+
			"\nLes bateaux font de 2 a 5 cases:"+
			"\n-1 porte-avion: 5 cases"+
			"\n-1 croiseur: 4 cases"+
			"\n-1 contre-torpilleur: 3 cases"+
			"\n-1 sous-marin: 3 cases"+
			"\n-1 torpilleur: 2 cases"+

			"\nLes joueur donnent a tour de role les coordonnees d'une case de l'adversaire pour pouvoir toucher un de ses bateaux."+
			"\nLe joueur gagnant est celui qui a trouve tous les bateaux de l'autre joueur. "
			;

	public FenetreRegles(){
		setTitle("Regles");
		setSize(700,250);
		JTextArea reglesDuJeu = new JTextArea(lesRegles);
		setLocationRelativeTo(null);	// Met la fenetre au milieu de l'ecran
		setResizable(false);
		reglesDuJeu.setLineWrap(true);
		reglesDuJeu.setSize(new Dimension(800, 800));
		
		getContentPane().add(reglesDuJeu);
		reglesDuJeu.setEditable(false);
		setVisible(true);
	}
	
	public static void main (String args[]){
		FenetreRegles fen = new FenetreRegles();
	}
}
