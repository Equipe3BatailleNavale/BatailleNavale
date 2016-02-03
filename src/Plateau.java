import javax.swing.text.StyledEditorKit.BoldAction;

public class Plateau {
	
	private int taille = 4;
	private Case cases[][] = new Case[taille][taille];
	private Bateau flottes[] = new Bateau[1];

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
	
	public void AfficherPlateau()
	{
		System.out.println("   0    1    2    3");
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
		
	}
	
	public boolean PlacerBateau(int x, int y, String sens, int taille){
		boolean placement = false;
		
		for (int k = 0; k < flottes.length; k++)
		{
			if(flottes[k].getTailleBat() == taille)
			{
				int caseLibre = 0;
				for (int i = 0; i < flottes[k].getTailleBat(); i++) {
					if (flottes[k].getSensBateau().toUpperCase().startsWith("H")){
						if (cases[x][y + i].getEtatCase() == Case.VIDE) {
							if (y + flottes[k].getTailleBat() <= 10) {
								caseLibre++;
							}
						} 
					} else if (flottes[k].getSensBateau().toUpperCase().startsWith("V")) {
						if (cases[x + i][y].getEtatCase() == Case.VIDE){
							if (x + flottes[k].getTailleBat() <= 10) {
								caseLibre++;
							}
						} 
					}
				}
				if (caseLibre == flottes[k].getTailleBat()) {
					placement = true;
					System.out.println("Bateau bien placé");
					
					for (int i = 0; i < flottes[k].getTailleBat(); i++) {
						if (flottes[k].getSensBateau().equals("h")) {
							cases[x][y+i].setEtatCase(Case.OCCUPE);
							flottes[k].setCase(i, cases[x][y+i]);
						} else {
							cases[x+i][y].setEtatCase(Case.OCCUPE);
							flottes[k].setCase(i, cases[x+i][y]);
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
	
	public boolean VerifBateauDansPlateau(int x, int y, int taille, String sens)
	{
		if(x >= 0 && x < this.taille && y >= 0 && y < this.taille)
		{
			if(sens.toUpperCase().startsWith("v"))
			{
				
			}
		}
		return true;
	}
}
