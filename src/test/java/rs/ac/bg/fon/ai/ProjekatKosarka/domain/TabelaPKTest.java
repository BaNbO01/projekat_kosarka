package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TabelaPKTest {

	TabelaPK tabelaPk1,tabelaPk2;
	@BeforeEach
	void setUp() throws Exception {
		tabelaPk1 = new TabelaPK();
		tabelaPk2 = new TabelaPK();
	}

	@AfterEach
	void tearDown() throws Exception {
		tabelaPk1 = null;
		tabelaPk2 = null;
	}

	@Test
	void testTabelaPK() {
		TabelaPK tab = new TabelaPK();
		assertNotNull(tab);
		assertEquals(0, tab.getLigaid());
		assertEquals(0, tab.getTabelaid());
	}

	@Test
	void testTabelaPKLongLong() {
		TabelaPK tab = new TabelaPK(2,3);
		assertNotNull(tab);

		assertEquals(2, tab.getTabelaid());
		assertEquals(3, tab.getLigaid());
	}

	@Test
	void testSetTabelaid() {
		tabelaPk1.setTabelaid(2);
		assertEquals(2, tabelaPk1.getTabelaid());
	}

	@Test
	void testSetLigaid() {
		tabelaPk1.setLigaid(2);
		assertEquals(2, tabelaPk1.getLigaid());
	}

	@Test
	void testEqualsIstaLokacija() {
		tabelaPk2 = tabelaPk1;
		assertTrue(tabelaPk1.equals(tabelaPk2));
		
	}
	@Test
	void testEqualsRazlicitaKlasa() {
		
		assertFalse(tabelaPk1.equals(new Object()));
		
	}
	@Test
	void testEqualsNull() {
		
		assertFalse(tabelaPk1.equals(null));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,2,1,2,true",
		"1,2,1,3,false",
		"1,2,3,2,false",
		"1,2,3,5,false"
		
	})
	void testEqualsObject(long tabelaId1,long ligaId1,long tabelaId2,long ligaId2,boolean equal) {
		tabelaPk1.setTabelaid(tabelaId1);
		tabelaPk1.setLigaid(ligaId1);
		tabelaPk2.setTabelaid(tabelaId2);
		tabelaPk2.setLigaid(ligaId2);
		assertEquals(equal, tabelaPk1.equals(tabelaPk2));
	}


	@Test
	void testToString() {
		tabelaPk1.setLigaid(2);
		tabelaPk1.setTabelaid(4);
		assertTrue(tabelaPk1.toString().contains("2"));
		assertTrue(tabelaPk1.toString().contains("4"));
	}

}
