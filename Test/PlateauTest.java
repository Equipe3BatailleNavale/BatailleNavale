import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlateauTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestPlacerBateau() {
		Plateau plateau = new Plateau(4);
		
		assertTrue(plateau.PlacerBateau(1, 0, "v", 3)); 
	}

}
