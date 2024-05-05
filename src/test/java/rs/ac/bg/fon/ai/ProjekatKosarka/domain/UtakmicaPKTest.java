package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UtakmicaPKTest {

	UtakmicaPK utakmicaPK1,utakmicaPK2;
	@BeforeEach
	void setUp() throws Exception {
		utakmicaPK1 = new UtakmicaPK();
		utakmicaPK2 = new UtakmicaPK();
	}

	@AfterEach
	void tearDown() throws Exception {
		utakmicaPK1 = null;
		utakmicaPK2 = null;
	}

	@Test
	void testUtakmicaPK() {
		UtakmicaPK u = new UtakmicaPK();
		assertNotNull(u);
		assertEquals(0, u.getUtakmicaId());
		assertEquals(0, u.getKoloId());
		assertEquals(0, u.getLigaId());
	}

	@Test
	void testUtakmicaPKLongLongLong() {
		UtakmicaPK u = new UtakmicaPK(1,2,3);
		assertNotNull(u);
		assertEquals(1, u.getUtakmicaId());
		assertEquals(2, u.getKoloId());
		assertEquals(3, u.getLigaId());
	}

	@Test
	void testSetUtakmicaId() {
		utakmicaPK1.setUtakmicaId(5);
		assertEquals(5, utakmicaPK1.getUtakmicaId());
	}

	@Test
	void testSetKoloId() {
		utakmicaPK1.setKoloId(4);
		assertEquals(4, utakmicaPK1.getKoloId());
	}

	@Test
	void testSetLigaId() {
		utakmicaPK1.setLigaId(2);
		assertEquals(2, utakmicaPK1.getLigaId());
	}

	@Test
	void testEqualsIstaLokacija() {
		utakmicaPK2 = utakmicaPK1;
		assertTrue(utakmicaPK1.equals(utakmicaPK2));
		
	}
	@Test
	void testEqualsRazlicitaKlasa() {
		
		assertFalse(utakmicaPK1.equals(new Object()));
		
	}
	@Test
	void testEqualsNull() {
		
		assertFalse(utakmicaPK1.equals(null));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,2,3,1,2,3,true",
		"1,2,3,1,2,4,false",
		"1,2,3,1,4,3,false",
		"1,2,3,2,2,3,false",
		"1,2,3,1,4,5,false",
		"1,2,3,2,2,4,false",
		"1,2,3,4,5,6,false",
		"1,2,3,4,5,3,false"
		
	})
	void testEqualsObject(long utakmicaId1,long koloId1,long ligaId1,long utakmicaId2,long koloId2,long ligaId2,boolean equal) {
		utakmicaPK1.setUtakmicaId(utakmicaId1);
		utakmicaPK1.setKoloId(koloId1);
		utakmicaPK1.setLigaId(ligaId1);
		utakmicaPK2.setUtakmicaId(utakmicaId2);
		utakmicaPK2.setKoloId(koloId2);
		utakmicaPK2.setLigaId(ligaId2);
		assertEquals(equal, utakmicaPK1.equals(utakmicaPK2));
	}


	@Test
	void testToString() {
		utakmicaPK1.setKoloId(2);
		utakmicaPK1.setLigaId(3);
		utakmicaPK1.setUtakmicaId(1);
		assertTrue(utakmicaPK1.toString().contains("1"));
		assertTrue(utakmicaPK1.toString().contains("2"));
		assertTrue(utakmicaPK1.toString().contains("3"));
	}

}
