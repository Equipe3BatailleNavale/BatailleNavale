import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCaseToucher() {
		Case Case = new Case(1, 2);
		assertFalse(Case.getCaseToucher());
		Case.estTouche();
		assertTrue(Case.getCaseToucher());
	}

}
