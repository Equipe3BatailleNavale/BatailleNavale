import javax.swing.text.StyledEditorKit.BoldAction;

public class Plateau {
	
	private int taille = 0;
	private Case cases[][];
	private Bateau flottes[] = new Bateau[5];
	private boolean win = false;
	private int nbBateauxCoule = 0;

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
	
	public boolean getPartieGagne()
	{
		return this.win;
	}
	public void setPartieGagne(){
		this.win = true;
	}
	
	public void AfficherPlateau()
	{
		System.out.println("   0    1    2    3    4    5    6    7    8    9    X");
		for(int i =0; i<this.taille; i++)
		{
			System.out.print(i);
			for (int j = 0; j<this.taille;j++)
			{
				if(cases[i][j].getEtatCase() == Case.VIDE)
				{
					System.out.print(" eau ");
				}else if(cases[i][j].getEtatCase() == Case.OCCUPE){
					System.out.print(" Bat ");
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
					System.out.println("Bateau bien placé");
					
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
				x =  0 + (int)(Math.random() * ((9 - 0) + 1));
				y= 0 + (int)(Math.random() * ((9 - 0) + 1));
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
	
	public Bateau[] GetListeBateau()
	{
		return flottes;
	}
	
	public void Tir(int x, int y)
	{
		
		if((x >= 0 && x < this.taille) && (y >= 0 && y < this.taille))
		{
			if(cases[y][x].getEtatCase() == Case.VIDE)
			{
				cases[y][x].setEtatCase(Case.MANQUE);
				
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
								System.out.println("Le bateau" + bateau.getNomBateau() + " est coulé");
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
			}
			else if(cases[y][x].getEtatCase() == Case.TOUCHE || cases[y][x].getEtatCase() == Case.MANQUE)
			{
				System.out.println("Vous avez déja tiré sur cette case");
			}
			
		}
	}
}
