
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
		etatCase = VIDE;
	}
	
	/**
	 * Permet de savoir si la case a etait touche
	 * @return
	 */
	public boolean estTouche(){
		caseTouche = true;
		return caseTouche;
	}
	/** 
	 * Permet de connaitre l'etat de la case
	 * @return
	 */
	public int getEtatCase(){
		return etatCase;
	}
	
	public boolean getCaseToucher(){
		return caseTouche;
	}
	
	public void setEtatCase(int etatCase){
		this.etatCase = etatCase;
	}
	
	public int getX(){
		return x; 
	}
	
	public int getY(){
		return y; 
	}

}
