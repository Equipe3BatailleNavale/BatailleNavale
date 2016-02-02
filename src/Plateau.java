
public class Plateau {
	
	
	private Case cases[][] = new Case[2][2];
	private Bateau flottes[] = new Bateau[1];

	public Plateau() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				cases[i][j] = new Case(i, j);
			}
		}
		for (int i = 0; i < 1; i++) {
			if (i == 0)
				flottes[i] = new Bateau(3);
			/*else if (i > 0)
				flottes[i] = new Bateau(i + 1);*/
		}
	}

}
