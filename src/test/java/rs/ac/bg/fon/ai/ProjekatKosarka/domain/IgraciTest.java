package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class IgraciTest {

	Igraci igraci1,igraci2;
	@BeforeEach
	void setUp() throws Exception {
		igraci1 = new Igraci();
		igraci2 = new Igraci();
	}

	@AfterEach
	void tearDown() throws Exception {
		igraci1 = null;
		igraci2 = null;
	}

	@Test
	void testIgraci() {
		Igraci i1 = new Igraci();
		assertNotNull(i1);
		assertEquals(null, i1.getBroj());
		assertEquals(null, i1.getDatumRodjenja());
		assertEquals(null, i1.getIme());
		assertEquals(null, i1.getPrezime());
		assertEquals(null, i1.getPozicija());
		assertEquals(null, i1.getDrzavaId());
		assertEquals(null, i1.getVisina());
		assertEquals(null, i1.getTimId());
		assertEquals(null, i1.getIgracID());
	}

	@Test
	void testIgraciLong() {
		Igraci i1 = new Igraci(2L);
		assertNotNull(i1);
		assertEquals(null, i1.getBroj());
		assertEquals(null, i1.getDatumRodjenja());
		assertEquals(null, i1.getIme());
		assertEquals(null, i1.getPrezime());
		assertEquals(null, i1.getPozicija());
		assertEquals(null, i1.getDrzavaId());
		assertEquals(null, i1.getVisina());
		assertEquals(null, i1.getTimId());
		assertEquals(2L, i1.getIgracID());
	}

	
	@Test
	void testSetIdNull() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->igraci1.setIgracID(null));
	}
	
	@Test
	void testId() {
		igraci1.setIgracID(2L);
		assertEquals(2L, igraci1.getIgracID());
	}
	
	
	
	@Test
	void testSetIme() {
		igraci1.setIme("Boban");
		assertEquals("Boban", igraci1.getIme());
	}
	
	@Test
	void testSetImePrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->igraci1.setIme(""));
	}
	
	@Test
	void testSetImeManjeOdDvaKaraktera() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->igraci1.setIme("p"));
	}

	@Test
	void testSetPrezimePrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->igraci1.setPrezime(""));
	}
	
	@Test
	void testSetPrezimeManjeOdDvaKaraktera() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->igraci1.setPrezime("p"));
	}
	@Test
	void testSetBroj() {
		igraci1.setBroj(2);
		assertEquals(2, igraci1.getBroj());
	}

	@Test
	void testSetDatumRodjenja() {
		Date d = new Date();
		igraci1.setDatumRodjenja(d);
		assertEquals(d, igraci1.getDatumRodjenja());
	}

	@Test
	void testSetVisina() {
		igraci1.setVisina(200.0);
		assertEquals(200.0, igraci1.getVisina());
	}

	@Test
	void testSetPozicija() {
		igraci1.setPozicija(Pozicija.PF);
		assertEquals(Pozicija.PF, igraci1.getPozicija());
	}

	@Test
	void testSetDrzavaId() {
		Drzava d = new Drzava(2L);
		igraci1.setDrzavaId(d);
		assertEquals(d, igraci1.getDrzavaId());
	}

	@Test
	void testSetTimId() {
		Tim tim = new Tim();
		igraci1.setTimId(tim);
		assertEquals(tim,igraci1.getTimId());
	}
	@Test
	void testEqualsNull(){
		assertFalse(igraci1.equals(null));
	}
	
	@Test
	void testEqualsIstaLokacija(){
		igraci2=igraci1;
		assertTrue(igraci1.equals(igraci2));
	}
	@Test
	void testEqualsRazlicitaKlasa(){
	
		assertFalse(igraci1.equals(new Object()));
	}

	@ParameterizedTest
	@CsvSource({
		"1,1,true",
		"1,2,false"
		
	})
	void testEqualsObject(Long id1,Long id2, boolean equal) {
		igraci1.setIgracID(id1);
		igraci2.setIgracID(id2);
		assertEquals(equal,igraci1.equals(igraci2));
	}

	@Test
	void testToString() {
		igraci1.setIme("Boban");
		igraci1.setPrezime("Todic");
		igraci1.setBroj(2);
		Date d = new Date();
		String s = d.toString();
		igraci1.setDatumRodjenja(d);
		igraci1.setVisina(200.0);
		
		igraci1.setDrzavaId(new Drzava());
		igraci1.getDrzavaId().setNaziv("Srbija");
		igraci1.setIgracID(10L);
		assertTrue(igraci1.toString().contains("Boban"));
		assertTrue(igraci1.toString().contains("Todic"));
		assertTrue(igraci1.toString().contains("Srbija"));
		assertTrue(igraci1.toString().contains("10"));
		assertTrue(igraci1.toString().contains("200.0"));
		assertTrue(igraci1.toString().contains(s));
		assertTrue(igraci1.toString().contains("2"));
	}

}
