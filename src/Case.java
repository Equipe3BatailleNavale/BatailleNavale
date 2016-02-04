
public class Case {
	protected static final int VIDE = 0; // case vide mais pas de tir deja fait
	protected static final int OCCUPE = 1; // bateau present
	protected static final int TOUCHE = 2; // bateau touché
	protected static final int MANQUE = 3; // bateau raté
	
	
	private int x,y;
	private boolean caseTouche;
	private int etatCase;
	public Case(int x,int y){
		
		this.x = x;
		this.y = y;
		this.etatCase = VIDE;
	}
	
	/**
	 * Permet de savoir si la case a etait touche
	 * @return
	 */
	public boolean estTouche(){
		this.caseTouche = true;
		return this.caseTouche;
	}
	/** 
	 * Permet de connaitre l'etat de la case
	 * @return
	 */
	public int getEtatCase(){
		return this.etatCase;
	}
	
	public boolean getCaseToucher(){
		return this.caseTouche;
	}
	
	public void setEtatCase(int etatCase){
		this.etatCase = etatCase;
	}
	
	public int getY(){
		return this.x; 
	}
	
	public int getX(){
		return this.y; 
	}

}
