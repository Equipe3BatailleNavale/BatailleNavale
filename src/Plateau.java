import javax.swing.text.StyledEditorKit.BoldAction;

public class Plateau {
	
	private int taille = 4;
	private Case cases[][] = new Case[taille][taille];
	private Bateau flottes[] = new Bateau[1];
	private boolean win = false;
	private int nbBateauxCoule = 0;

	public Plateau(int taille) {
		this.taille = taille;
		
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				cases[i][j] = new Case(i, j);
			}
		}
		for (int i = 0; i < 1; i++) {
			if (i == 0)
				flottes[i] = new Bateau(3);
			else if (i > 0)
				flottes[i] = new Bateau(i + 1);
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
		System.out.println("   0    1    2    3     X");
		for(int i =0; i<4; i++)
		{
			System.out.print(i);
			for (int j = 0; j<4;j++)
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
	
	public boolean PlacerBateau(int x, int y, String sens, int taille){
		boolean placement = false;
		
		for (int k = 0; k < flottes.length; k++)
		{
			if(flottes[k].getTailleBat() == taille)
			{
				int caseLibre = 0;
				for (int i = 0; i < taille; i++) {
					if (flottes[k].getSensBateau().toUpperCase().startsWith("H")){
						if (x + taille <= this.taille ) {
							if (cases[y][x+i].getEtatCase() == Case.VIDE) {
								caseLibre++;
							}
						} 
					} else if (flottes[k].getSensBateau().toUpperCase().startsWith("V")) {
						if (y + taille <= this.taille){
							if (cases[y+i][x].getEtatCase() == Case.VIDE) {
								caseLibre++;
							}
						} 
					}
				}
				if (caseLibre == taille) {
					placement = true;
					System.out.println("Bateau bien placé");
					
					for (int i = 0; i < taille; i++) {
						if (flottes[k].getSensBateau().equals("h")) {
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
