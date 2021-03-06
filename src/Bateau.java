
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
		this.cases = new Case[taille];
		setNomBateau(taille);
	
	}

	/**
	 * Permet de retourner la case souhaite
	 * @param pos
	 * @return
	 */
	public Case getCase(int pos){
		return this.cases[pos];
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
		return this.tailleBat;
	}

	/**
	 * Dans le cas ou une case du bateau est touche
	 */
	public void bateauTouche() {
		this.caseTouche += 1;
	}
	
	
	/**
	 * Retourne vrai si le bateau n'a plus de case
	 * @return
	 */
	public boolean estCoule(){
		if(this.caseTouche == this.tailleBat){
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
	
	public String getNomBateau()
	{
		return this.NomBateau;
	}
	
	public void setNomBateau(int taille)
	{
		switch (taille)
		{
		  case 2:
		    this.NomBateau = "Torpilleur";
		    break;

		  case 3:
			  this.NomBateau = "Contre-torpilleur";
		    break;

		  case 4:
			  this.NomBateau = "Croiseur";
		    break;
		    
		  case 5:
			  this.NomBateau = "Porte-avion";
			    break;
			    
		  case 6:
			  this.NomBateau = "Tank";
			  break;
			  
		  default:
			  this.NomBateau = "Navire non valide.";

		}
	}

}
