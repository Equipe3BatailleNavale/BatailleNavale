
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
	
	public boolean estTouche(){
		return caseTouche;
	}
	
	public int getEtatCase(){
		return etatCase;
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
