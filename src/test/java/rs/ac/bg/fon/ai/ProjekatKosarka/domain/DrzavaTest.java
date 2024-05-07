package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DrzavaTest {

	Drzava d1,d2;
	@BeforeEach
	void setUp() throws Exception {
		d1 = new Drzava();
		d2 = new Drzava();
	}

	@AfterEach
	void tearDown() throws Exception {
		d1 = null;
		d2 = null;
	}

	@Test
	void testDrzava() {
		Drzava drzava  = new Drzava();
		assertNotNull(drzava);
		assertEquals(null, drzava.getDrzavaId());
		assertEquals(null,drzava.getNaziv());
	}

	@Test
	void testDrzavaLong() {
		Drzava drzava  = new Drzava(1L);
		assertNotNull(drzava);
		assertEquals(1L,drzava.getDrzavaId());
		assertEquals(null,drzava.getNaziv());
	}

	@Test
	void testSetDrzavaId() {
		d1.setDrzavaId(1L);
		assertEquals(1L,d1.getDrzavaId());
	}

	@Test
	void testSetNaziv() {
		d1.setNaziv("Naziv");
		assertEquals("Naziv",d1.getNaziv());
	}

	@ParameterizedTest
	@CsvSource({
		
		"1,1,true",
		"1,2,false"
	})
	
	void testEqualsObject(Long id1,Long id2,boolean equal) {
		d1.setDrzavaId(id1);
		d2.setDrzavaId(id2);
		assertEquals(equal, d1.equals(d2));
	}

	@Test
	void testToString() {
		d1.setNaziv("Srbija");
	assertTrue(d1.toString().contains("Srbija"));
	}

}
