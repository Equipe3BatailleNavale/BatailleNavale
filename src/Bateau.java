
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
	
	public Case getCase(int pos){
		return cases[pos];
	}
	/*
	 * Permet de modifier une case
	 * */
	public void setCase(int pos, Case cases){
		this.cases[pos]= cases ;
	}

	
	public int getTailleBat(){
		return tailleBat;
	}
	
	public void bateauTouche() {
		caseTouche++;
		System.out.println("Touché");
	}
	
	
	public boolean estCoule(){
		if(caseTouche == tailleBat){
			return true;
		}
		else{ return false;}
	}
	
	public void setSensBateau(String sensBateau){
		this.sensBateau = sensBateau;
	}
	
	public String getSensBateau(){
		return sensBateau;
	}

}
