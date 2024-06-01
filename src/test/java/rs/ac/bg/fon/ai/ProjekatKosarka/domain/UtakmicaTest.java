package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UtakmicaTest {

	Utakmica utakmica1,utakmica2;
	@BeforeEach
	void setUp() throws Exception {
		utakmica1 = new Utakmica();
		utakmica2 = new Utakmica();
	}

	@AfterEach
	void tearDown() throws Exception {
		utakmica1 = null;
		utakmica2 = null;
	}

	@Test
	void testUtakmica() {
		Utakmica u = new Utakmica();
		assertNotNull(u);
		assertEquals(null, u.getBrojKosevaTima1());
		assertEquals(null, u.getBrojKosevaTima2());
		assertEquals(null, u.getKolo());
		assertEquals(null, u.getTimid1());
		assertEquals(null, u.getTimid2());
		assertEquals(null, u.getUtakmicaPK());
	}

	@Test
	void testUtakmicaUtakmicaPK() {
		UtakmicaPK utakmicaPK = new UtakmicaPK();
		Utakmica u = new Utakmica(utakmicaPK);
		assertNotNull(u);
		assertEquals(utakmicaPK, u.getUtakmicaPK());
		assertEquals(null, u.getBrojKosevaTima1());
		assertEquals(null, u.getBrojKosevaTima2());
		assertEquals(null, u.getKolo());
		assertEquals(null, u.getTimid1());
		assertEquals(null, u.getTimid2());
		
	}

	@Test
	void testSetUtakmicaPK() {
		UtakmicaPK utakmicaPK = new UtakmicaPK();
		utakmica1.setUtakmicaPK(utakmicaPK);
		assertEquals(utakmicaPK, utakmica1.getUtakmicaPK());
	}

	@Test
	void testSetBrojKosevaTima1() {
		utakmica1.setBrojKosevaTima1(5);
		assertEquals(5, utakmica1.getBrojKosevaTima1());
	}

	@Test
	void testSetBrojKosevaTima2() {
		utakmica1.setBrojKosevaTima2(2);
		assertEquals(2, utakmica1.getBrojKosevaTima2());
	}
	
	@Test
	void testSetTimd1Null() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->utakmica1.setTimid1(null));
	}

	
	@Test
	void testSetTimd2Null() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->utakmica1.setTimid2(null));
	}
	
	@Test
	void testSetTimid1() {
		Tim tim = new Tim();
		utakmica1.setTimid1(tim);
		assertEquals(tim, utakmica1.getTimid1());
	}

	@Test
	void testSetTimid2() {
		Tim tim = new Tim();
		utakmica1.setTimid2(tim);
		assertEquals(tim, utakmica1.getTimid2());
	}

	
	@Test
	void testSetKoloNull() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->utakmica1.setKolo(null));
	}
	
	@Test
	void testSetKolo() {
		Kolo k = new Kolo();
		utakmica1.setKolo(k);
		assertEquals(k, utakmica1.getKolo());
	}

	@Test
	void testEqualsIstaLokacija() {
		utakmica2 = utakmica1;
		assertTrue(utakmica1.equals(utakmica2));
		
	}
	@Test
	void testEqualsRazlicitaKlasa() {
		
		assertFalse(utakmica1.equals(new Object()));
		
	}
	@Test
	void testEqualsNull() {
		
		assertFalse(utakmica1.equals(null));
		
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
		UtakmicaPK utakmicaPK1 = new UtakmicaPK();
		UtakmicaPK utakmicaPK2 = new UtakmicaPK();
		utakmicaPK1.setUtakmicaId(utakmicaId1);
		utakmicaPK1.setKoloId(koloId1);
		utakmicaPK1.setLigaId(ligaId1);
		utakmicaPK2.setUtakmicaId(utakmicaId2);
		utakmicaPK2.setKoloId(koloId2);
		utakmicaPK2.setLigaId(ligaId2);
		utakmica1.setUtakmicaPK(utakmicaPK1);
		utakmica2.setUtakmicaPK(utakmicaPK2);
		assertEquals(equal, utakmica1.equals(utakmica2));
	}

	@Test
	void testToString() {
		UtakmicaPK utakmicaPk = new UtakmicaPK(1,2,3);
		utakmica1.setUtakmicaPK(utakmicaPk);
		utakmica1.setBrojKosevaTima1(80);
		utakmica1.setBrojKosevaTima2(75);
		Tim tim = new Tim();
		tim.setNaziv("Partizan");
		Grad g = new Grad();
		g.setNaziv("Beograd");
		tim.setGrad(g);
		
		utakmica1.setTimid1(tim);
		Tim tim2 = new Tim();
		tim2.setNaziv("Vojvodina");
		Grad g2 = new Grad();
		g2.setNaziv("Novi Sad");
		tim2.setGrad(g2);
		utakmica1.setTimid2(tim2);
		Kolo k = new Kolo(new KoloPK(2, 3));
		assertTrue(utakmica1.toString().contains("1"));
		assertTrue(utakmica1.toString().contains("2"));
		assertTrue(utakmica1.toString().contains("3"));
		assertTrue(utakmica1.toString().contains("Vojvodina"));
		assertTrue(utakmica1.toString().contains("Novi Sad"));
		assertTrue(utakmica1.toString().contains("Partizan"));
		assertTrue(utakmica1.toString().contains("Beograd"));
		assertTrue(utakmica1.toString().contains("80"));
		assertTrue(utakmica1.toString().contains("75"));
	}

}
