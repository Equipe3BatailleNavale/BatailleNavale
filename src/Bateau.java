
public class Bateau {
	
	private int tailleBat;
	private String sensBateau;
	private String NomBateau;
	private int caseTouche;//compteur de case du bateau touché

	private int x,y;
	private Case cases[];
	
	public Bateau() { 
	
	}
	
	public Bateau(int taille) {
		this.tailleBat = taille;
		cases = new Case[taille];
		this.NomBateau = getNomBateau(taille);
	
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
	
	public int getCaseToucher(){
		return caseTouche;
	}
	
	public String getNomBateau(int taille)
	{
		String Nom;
		switch (taille)
		{
		  case 2:
		    Nom = "Torpilleur";
		    break;

		  case 3:
			  Nom = "Contre-torpilleur";
		    break;

		  case 4:
		    Nom = "Croiseur";
		    break;
		    
		  case 5:
			    Nom = "Porte-avion";
			    break;

		  default:
		    Nom = "Navire non valide.";

		}
		return Nom;
	}

}
