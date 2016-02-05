import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlateauTest {

	
	@Test
	public void testPlacerBateau()
	{
		Plateau p1 = new Plateau(10);
		int i = 0;
		String sens = "v";
		for (Bateau bateau : p1.GetListeBateau()) {
			bateau.setSensBateau(sens);
			assertTrue(p1.PlacerBateau(i, 0, bateau));
			i++;
		}
	
	}
	
	@Test
	public void testTir()
	{
		Plateau p1 = new Plateau(10);
		int i = 0;
		String sens = "v";
		for (Bateau bateau : p1.GetListeBateau()) {
			bateau.setSensBateau(sens);
			p1.PlacerBateau(i, 0, bateau);
			i++;
		}
		i = 0;
		for (int j = 0; j < p1.GetListeBateau().length; j++) {
			p1.Tir(i, 0);
			i++;
		}
		for (Bateau bateau : p1.GetListeBateau()) {
			assertEquals(1, bateau.getCaseToucher());
		}
	}
	@Test
	public void testnombreAleatoire()
	{
		Plateau p1 = new Plateau(10);
		for (int i = 0; i < 10; i++) {
			assertTrue("Supérieur", p1.nombreAleatoire() < 10);;
		}
	}

}
