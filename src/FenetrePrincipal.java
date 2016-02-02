import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FenetrePrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pan = new JPanel();
	JButton boutonJouer = new JButton("Jouer");
	JButton boutonRegles = new JButton ("Regles");
	JButton boutonAPropos = new JButton("A Propos");
	JButton commentJouer = new JButton("Comment Jouer");
	

	public FenetrePrincipal(){
		setTitle("Bataille Navale"); // Titre de la fenetre
		
		setSize(400, 600);	// Definit la taille de la fenetre
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// Supprime la fenetre de la memoire lorsqu'elle est fermee
		
        setLocationRelativeTo(null);	// Met la fenetre au milieu de l'ecran
        
        pan.add(boutonJouer);	// Ajoute le bouton jouer au panneau
        
        pan.add(boutonRegles);	// Ajoute le bouton regles au panneau
        
        pan.add(boutonAPropos);
        
        pan.add(commentJouer);
        
        pan.setBackground(Color.LIGHT_GRAY);	// Met le fond de la fenetre en gris
        
        ListenerBoutonJouer listenerJouer = new ListenerBoutonJouer();
        boutonJouer.addActionListener(listenerJouer);
        
        ListenerBoutonRegles listenerRegles = new ListenerBoutonRegles();
        boutonRegles.addActionListener(listenerRegles);
        
        ListenerBoutonCommentJouer listenerCommentJouer = new ListenerBoutonCommentJouer();
        commentJouer.addActionListener(listenerCommentJouer);
        
        
        setContentPane(pan);
        
        
		setVisible(true);	// Permet de rendre la fenetre visible
		
		}
	
class ListenerBoutonJouer implements ActionListener {
		
		public void actionPerformed (ActionEvent clic) {
		
	
			
		}
}
	
	class ListenerBoutonRegles implements ActionListener {
		
		public void actionPerformed (ActionEvent clic) {
			new FenetreRegles();
	}
	
	}
	
	
	class ListenerBoutonCommentJouer implements ActionListener{
		
		public void actionPerformed (ActionEvent clic){
			
		}
	}
	
	
public static void main (String args[]){
		

		FenetrePrincipal numeroUne = new FenetrePrincipal();
		
		
	}

}
