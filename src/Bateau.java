
public class Bateau {
	
	private int tailleBat;
	private String sensBateau;
<<<<<<< HEAD
	private int caseTouche;//compteur de case du bateau touché
=======
	private int caseTouche;//compteur de case du bateau touche
>>>>>>> f7fb05cb0b69d064c5afc5ecdfddc577feb87979
	private int x,y;
	private Case cases[];
	
	public Bateau() { 
	
	}
	
	public Bateau(int taille) {
		this.tailleBat = taille;
		cases = new Case[taille]; 
	
	}
	
<<<<<<< HEAD
	public Case getCase(int pos){
		return cases[pos];
	}
	/*
	 * Permet de modifier une case
	 * */
=======
	/**
	 * Permet de retourner la case souhaite
	 * @param pos
	 * @return
	 */
	public Case getCase(int pos){
		return cases[pos];
	}
	
	/**
	 * Permet de modifer une case
	 * @param pos
	 * @param cases
	 */
>>>>>>> f7fb05cb0b69d064c5afc5ecdfddc577feb87979
	public void setCase(int pos, Case cases){
		this.cases[pos]= cases ;
	}
	

	
	public int getTailleBat(){
		return tailleBat;
	}
	
<<<<<<< HEAD
	public void bateauTouche() {
		caseTouche++;
		System.out.println("Touché");
	}
	
	
=======
	/**
	 * Dans le cas ou une case du bateau est touche
	 */
	public void bateauTouche() {
		caseTouche++;
		System.out.println("Touche");
	}
	
	
	/**
	 * Retourne vrai si le bateau n'a plus de case
	 * @return
	 */
>>>>>>> f7fb05cb0b69d064c5afc5ecdfddc577feb87979
	public boolean estCoule(){
		if(caseTouche == tailleBat){
			return true;
		}
		else{ return false;}
	}
	
<<<<<<< HEAD
=======
	/**
	 * Permet de positionner le bateau verticalement ou horizontalement
	 * @param sensBateau
	 */
>>>>>>> f7fb05cb0b69d064c5afc5ecdfddc577feb87979
	public void setSensBateau(String sensBateau){
		this.sensBateau = sensBateau;
	}
	
<<<<<<< HEAD
=======
	/**
	 * Permet de connaitre le sens du bateau
	 * @return 
	 */
>>>>>>> f7fb05cb0b69d064c5afc5ecdfddc577feb87979
	public String getSensBateau(){
		return sensBateau;
	}

}
