import javax.swing.text.StyledEditorKit.BoldAction;

public class Plateau {
	
	private int taille = 0;
	private Case cases[][];
	private Bateau flottes[] = new Bateau[5];
	private boolean win = false;
	private int nbBateauxCoule = 0;
	private String nomJoueurEnnemie;
	private String nomJoueur;

	public Plateau(int taille) {
		this.taille = taille;
		
		this.cases = new Case[taille][taille];
		
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				cases[i][j] = new Case(i, j);
			}
		}
		for (int i = 0; i < this.flottes.length; i++) {
			if (i == 2)
				this.flottes[i] = new Bateau(6);
			if (i == 0)
				this.flottes[i] = new Bateau(3);
			else if (i > 0 && i != 2)
				this.flottes[i] = new Bateau(i + 1);
		}
	}
	
	public int getTaillePlateau()
	{
		return this.taille;
	}
	public void setNomJoueurEnnemie(String nom)
	{
		if(nom.startsWith("V"))
			this.nomJoueurEnnemie = nom + " avez";
		else{this.nomJoueurEnnemie = "Le " + nom + " a";}
	}
	
	public void setNomJoueur(String nom)
	{
		if(nom.startsWith("V"))
			this.nomJoueur = nom + " avez";
		else{this.nomJoueur = "Le " + nom + " a";}
	}
	
	public String getNomJoueur()
	{
		return this.nomJoueur;
	}
	
	public boolean getPartieGagne()
	{
		return this.win;
	}
	public void setPartieGagne(){
		this.win = true;
	}
	
	public Bateau[] GetListeBateau()
	{
		return flottes;
	}
	
	
	
	public void AfficherPlateau(int Ia)
	{
		for (int i = 0; i < this.taille; i++) {
			if (i < 10)
				System.out.print("    " + i);
			else
				System.out.print("   " + i);
		}
		System.out.println("    X");
		for(int i =0; i<this.taille; i++)
		{
			if(i < 10)
			System.out.print(" "+i);
			else{System.out.print(i);}
			for (int j = 0; j<this.taille;j++)
			{
				if(cases[i][j].getEtatCase() == Case.VIDE)
				{
					System.out.print(" ~~~ ");
				}else if(cases[i][j].getEtatCase() == Case.OCCUPE){
					if(Ia == 0){System.out.print(" Bat ");}
					else{System.out.print(" ~~~ ");}
				}else if(cases[i][j].getEtatCase() == Case.TOUCHE){
					System.out.print("  X  ");
				}else if(cases[i][j].getEtatCase() == Case.MANQUE){
					System.out.print("raté ");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Y");
	}
	
	public boolean PlacerBateau(int x, int y, Bateau bateau){
		boolean placement = false;
		
		for (int k = 0; k < flottes.length; k++)
		{
			if(flottes[k].getNomBateau() == bateau.getNomBateau())
			{
				String nom = flottes[k].getNomBateau();
				int caseLibre = 0;
				String sensBateau = bateau.getSensBateau();
				String upperCase = sensBateau.toUpperCase();
				
				for (int i = 0; i < bateau.getTailleBat(); i++) {
					if (upperCase.startsWith("H")){
						if (x + bateau.getTailleBat() <= this.taille ) {
							if (cases[y][x+i].getEtatCase() == Case.VIDE) {
								caseLibre++;
							}
						} 
					} else if (upperCase.startsWith("V")) {
						if (y + bateau.getTailleBat() <= this.taille){
							if (cases[y+i][x].getEtatCase() == Case.VIDE) {
								caseLibre++;
							}
						} 
					}
				}
				if (caseLibre == bateau.getTailleBat()) {
					placement = true;
					//System.out.println("Bateau bien placé");
					
					for (int i = 0; i < bateau.getTailleBat(); i++) {
						if (sensBateau.startsWith("h")) {
							cases[y][x+i].setEtatCase(Case.OCCUPE);
							flottes[k].setCase(i, cases[y][x+i]);
						} else {
							cases[y+i][x].setEtatCase(Case.OCCUPE);
							flottes[k].setCase(i, cases[y+i][x]);
						}
					}
				}
			}
	}
		return placement;

}
	
	public void PlacerBateauAleatoire()
	{
		int x = 0, y = 0, sensOrdi;
		String sens;
		
		for (Bateau bateau : this.flottes) {
			boolean placement = false;
			
			while (!placement) {
				x = nombreAleatoire();
				y = nombreAleatoire();
				sensOrdi = 0 + (int)(Math.random() * ((1 - 0) + 1));
				
				if (sensOrdi == 0)
				{
					sens = "h";
				}
				else {
					sens = "v";
				}
				bateau.setSensBateau(sens);
				
				placement = PlacerBateau(x, y, bateau);	
			}
		}
	}

	public int nombreAleatoire() {
		return (int)(Math.random() * this.taille);
	}
	public boolean Tir(int x, int y)
	{
		boolean tir = false;
		
		if((x >= 0 && x < this.taille) && (y >= 0 && y < this.taille))
		{
			if(cases[y][x].getEtatCase() == Case.VIDE)
			{
				cases[y][x].setEtatCase(Case.MANQUE);
				System.out.println(this.nomJoueurEnnemie+" manqué la cible");
				return tir = true;
				
			}else if(cases[y][x].getEtatCase() == Case.TOUCHE || cases[y][x].getEtatCase() == Case.MANQUE)
			{
				System.out.println(this.nomJoueurEnnemie + " déja tiré sur cette case");
				return tir = false;
			}
			else if(cases[y][x].getEtatCase() == Case.OCCUPE)
			{
				for (Bateau bateau : this.flottes) {
					for (int i = 0; i < bateau.getTailleBat(); i++) {
						if (bateau.getCase(i).getX() == x && (bateau.getCase(i).getY() == y)) 
						{
							bateau.bateauTouche();
							if(bateau.estCoule())
							{
								System.out.println("Le " + bateau.getNomBateau() + " est coulé que ");
								this.nbBateauxCoule += 1;
							}
						}
					}
					if(this.nbBateauxCoule == this.flottes.length)
					{
						this.win = true;
					}
				}
				cases[y][x].setEtatCase(Case.TOUCHE);
				System.out.println(this.nomJoueurEnnemie+ " touché la cible");
				return tir = true;
			}
			
		}
		return tir;
	}
	
	public boolean TirAleatoire()
	{
		boolean retour;
		boolean bontTir = false;
		int x = 0, y = 0;
		while (!bontTir){
			x =  nombreAleatoire();
			y =  nombreAleatoire();		
			bontTir = Tir(x, y);
			
		}
		if (cases[y][x].getEtatCase() == 2)
			retour = true;
		else
			retour = false;
		return retour;
	}
}
