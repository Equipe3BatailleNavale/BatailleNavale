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

}
