import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BateauTest {
	
	protected Bateau bateau;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestBateauToucher() {
		bateau = new Bateau(5);
		bateau.bateauTouche();
		assertEquals(bateau.getCaseToucher(), 1);
	}


	@Test
	public void TestEstCoule() {
		bateau = new Bateau(5);
		for(int i = 0; i<5; i++)
		{
			bateau.bateauTouche();
		}
		assertTrue(bateau.estCoule());
	}

}
