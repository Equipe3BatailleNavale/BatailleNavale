import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class FenetreBataille extends JFrame{
	
	public FenetreBataille() {
		
        super();
 
        setSize(700, 300);
        setTitle("Grille de jeu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        Object[][] donnees = {
                {"vide", "vide", "vide"},
                {"Vide", "vide", "vide"},
                {"Vide", "vide", "vide"},
                
        };
 
        String[] entetes = {"A", "B", "C"};
 
        JTable tableau = new JTable(donnees, entetes);
        
 
        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);
 
        pack();
    }
 
    public static void main(String[] args) {
        new FenetreBataille().setVisible(true);
    }


}
