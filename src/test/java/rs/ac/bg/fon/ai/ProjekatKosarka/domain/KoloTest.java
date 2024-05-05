package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KoloTest {

	Kolo kolo1,kolo2;
	@BeforeEach
	void setUp() throws Exception {
		kolo1 = new Kolo();
		kolo2 = new Kolo();
	}

	@AfterEach
	void tearDown() throws Exception {
		kolo1 = null;
		kolo2 = null;
	}

	@Test
	void testKolo() {
		Kolo k = new Kolo();
		assertNotNull(k);
		assertEquals(null, k.getKoloPK());
		assertEquals(null, k.getLiga());
	}

	@Test
	void testKoloKoloPK() {
		KoloPK pk = new KoloPK();
		Kolo k = new Kolo(pk);
		
		assertNotNull(k);
		assertEquals(pk, k.getKoloPK());
		assertEquals(null, k.getLiga());
		
	}

	@Test
	void testSetKoloPK() {
		KoloPK pk = new KoloPK();
		kolo1.setKoloPK(pk);
		assertEquals(pk, kolo1.getKoloPK());
	}

	@Test
	void testSetLiga() {
		Liga l = new Liga();
		kolo1.setLiga(l);
		assertEquals(l, kolo1.getLiga());
	}

	@Test
	void testEqualsIstaLokacija() {
		kolo2 = kolo1;
		assertTrue(kolo1.equals(kolo2));
		
	}
	@Test
	void testEqualsRazlicitaKlasa() {
		
		assertFalse(kolo1.equals(new Object()));
		
	}
	@Test
	void testEqualsNull() {
		
		assertFalse(kolo1.equals(null));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,2,1,2,true",
		"1,2,1,3,false",
		"1,2,3,2,false",
		"1,2,3,5,false"
		
	})
	void testEqualsObject(long koloId1,long ligaId1,long koloId2,long ligaId2,boolean equal) {
		KoloPK koloPK1 = new KoloPK();
		KoloPK koloPK2 = new KoloPK();
		koloPK1.setKoloId(koloId1);
		koloPK1.setLigaId(ligaId1);
		koloPK2.setKoloId(koloId2);
		koloPK2.setLigaId(ligaId2);
		kolo1.setKoloPK(koloPK1);
		kolo2.setKoloPK(koloPK2);
		assertEquals(equal, kolo1.equals(kolo2));
	}

	@Test
	void testToString() {
		KoloPK kolopk = new KoloPK(1, 2);
		kolo1.setKoloPK(kolopk);
		assertTrue(kolo1.toString().contains("1"));
		
	}

}
