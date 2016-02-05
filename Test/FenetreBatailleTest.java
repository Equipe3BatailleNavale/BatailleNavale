import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FenetreBatailleTest {
	
	@Test
	public void testverifWinner() {
		Plateau p1 = new Plateau(10);
		Plateau p2 = new Plateau(10);
		
		for (Bateau bateau : p2.GetListeBateau()) {
			if (bateau.getTailleBat() == 3 || bateau.getTailleBat() == 6)
			{
				bateau.bateauTouche();
			}
			FenetreBataille.verifWinner(p2, p1, 20);
			
		}
	}

}
