package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KoloPKTest {

	KoloPK koloPK1,koloPK2;
	@BeforeEach
	void setUp() throws Exception {
		koloPK1 = new KoloPK();
		koloPK2 = new KoloPK();
	}

	@AfterEach
	void tearDown() throws Exception {
		koloPK1 =null;
		koloPK2 = null;
	}

	@Test
	void testKoloPK() {
		KoloPK koloPk = new KoloPK();
		assertNotNull(koloPk);
		assertEquals(0,koloPk.getKoloId());
		assertEquals(0,koloPk.getLigaId());
	}

	@Test
	void testKoloPKLongLong() {
		KoloPK koloPk = new KoloPK(1,2);
		assertNotNull(koloPk);
		assertEquals(1,koloPk.getKoloId());
		assertEquals(2,koloPk.getLigaId());
	}

	@Test
	void testSetKoloId() {
		koloPK1.setKoloId(2);
		assertEquals(2, koloPK1.getKoloId());
	}

	@Test
	void testSetLigaId() {
		koloPK1.setLigaId(3);
		assertEquals(3, koloPK1.getLigaId());
	}

	@Test
	void testEqualsIstaLokacija() {
		koloPK2 = koloPK1;
		assertTrue(koloPK1.equals(koloPK2));
		
	}
	@Test
	void testEqualsRazlicitaKlasa() {
		
		assertFalse(koloPK1.equals(new Object()));
		
	}
	@Test
	void testEqualsNull() {
		
		assertFalse(koloPK1.equals(null));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,2,1,2,true",
		"1,2,1,3,false",
		"1,2,3,2,false",
		"1,2,3,5,false"
		
	})
	void testEqualsObject(long koloId1,long ligaId1,long koloId2,long ligaId2,boolean equal) {
		koloPK1.setKoloId(koloId1);
		koloPK1.setLigaId(ligaId1);
		koloPK2.setKoloId(koloId2);
		koloPK2.setLigaId(ligaId2);
		assertEquals(equal, koloPK1.equals(koloPK2));
	}

	@Test
	void testToString() {
		koloPK1.setKoloId(2);
		koloPK1.setLigaId(4);
		assertTrue(koloPK1.toString().contains("2"));
		assertTrue(koloPK1.toString().contains("4"));
	}

}
