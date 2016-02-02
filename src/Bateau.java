
public class Bateau {
	
	private int tailleBat;
	private String sensBateau;

	private int caseTouche;//compteur de case du bateau touché

	private int x,y;
	private Case cases[];
	
	public Bateau() { 
	
	}
	
	public Bateau(int taille) {
		this.tailleBat = taille;
		cases = new Case[taille]; 
	
	}

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
	public void setCase(int pos, Case cases){
		this.cases[pos]= cases ;
	}
	

	
	public int getTailleBat(){
		return tailleBat;
	}

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
	public boolean estCoule(){
		if(caseTouche == tailleBat){
			return true;
		}
		else{ return false;}
	}
	
	/**
	 * Permet de positionner le bateau verticalement ou horizontalement
	 * @param sensBateau
	 */

	public void setSensBateau(String sensBateau){
		this.sensBateau = sensBateau;
	}
	
	public String getSensBateau(){
		return sensBateau;
	}

}
