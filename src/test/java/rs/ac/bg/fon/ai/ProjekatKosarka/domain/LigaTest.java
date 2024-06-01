package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LigaTest {

	Liga liga1,liga2;
	@BeforeEach
	void setUp() throws Exception {
		liga1 = new Liga();
		liga2 = new Liga();
	}

	@AfterEach
	void tearDown() throws Exception {
		liga1 = null;
		liga2 = null;
	}

	@Test
	void testLiga() {
		Liga l = new Liga();
		assertNotNull(l);
		assertEquals(null, l.getDrzavaId());
		assertEquals(null, l.getLigaId());
		assertEquals(null, l.getNaziv());
	}

	@Test
	void testLigaLong() {
		Liga l = new Liga(1L);
		assertNotNull(l);
		assertEquals(null, l.getDrzavaId());
		assertEquals(1L, l.getLigaId());
		assertEquals(null, l.getNaziv());
	}

	@Test
	void testSetIdNull() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->liga1.setLigaId(null));
	}
	
	@Test
	void testSetLigaId() {
		liga1.setLigaId(1L);
		assertEquals(1L, liga1.getLigaId());
	}

	@Test
	void testSetNaziv() {
		liga1.setNaziv("KLS");
		assertEquals("KLS", liga1.getNaziv());
	}
	
	@Test
	void testSetNazivBlank() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->liga1.setNaziv(""));
	}

	
	@Test
	void testSetDrzavaIdNull() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->liga1.setDrzavaId(null));
	}
	
	@Test
	void testSetDrzavaId() {
		Drzava d = new Drzava();
		liga1.setDrzavaId(d);
		assertEquals(d, liga1.getDrzavaId());
	}
	
	@Test
	void testEqualsNull(){
		assertFalse(liga1.equals(null));
	}
	
	@Test
	void testEqualsIstaLokacija(){
		liga2=liga1;
		assertTrue(liga1.equals(liga2));
	}
	@Test
	void testEqualsRazlicitaKlasa(){
	
		assertFalse(liga1.equals(new Object()));
	}

	@ParameterizedTest
	@CsvSource({
		"1,1,true",
		"1,2,false"
		
	})
	void testEqualsObject(Long id1,Long id2, boolean equal) {
		liga1.setLigaId(id1);
		liga2.setLigaId(id2);
		assertEquals(equal,liga1.equals(liga2));
	}

	

	@Test
	void testToString() {
		Drzava d = new Drzava(5L);
		d.setNaziv("Srbija");
		liga1.setDrzavaId(d);
		liga1.setNaziv("KLS");
		assertTrue(liga1.toString().contains("Srbija"));
		assertTrue(liga1.toString().contains("KLS"));
	}

}
