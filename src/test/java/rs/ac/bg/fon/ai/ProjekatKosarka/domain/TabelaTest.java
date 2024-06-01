package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TabelaTest {

	Tabela tabela1,tabela2;
	@BeforeEach
	void setUp() throws Exception {
		tabela1 = new Tabela();
		tabela2 = new Tabela();
	}

	@AfterEach
	void tearDown() throws Exception {
		tabela1 = null;
		tabela2 = null;
	}

	@Test
	void testTabela() {
		Tabela t = new Tabela();
		assertNotNull(t);
		assertEquals(null, t.getBrojPoraza());
		assertEquals(null, t.getBrojPobeda());
		assertEquals(null, t.getKosRazlika());
		assertEquals(null, t.getLiga());
		assertEquals(null, t.getTabelaPK());
		assertEquals(null, t.getTimid());
		
		
	}

	@Test
	void testTabelaTabelaPK() {
		TabelaPK pk = new TabelaPK(2,3);
		Tabela t = new Tabela(pk);
		assertNotNull(t);
		assertEquals(pk, t.getTabelaPK());
		assertEquals(null, t.getBrojPoraza());
		assertEquals(null, t.getBrojPobeda());
		assertEquals(null, t.getKosRazlika());
		assertEquals(null, t.getLiga());
		assertEquals(null, t.getTimid());
	}

	@Test
	void testTabelaLongLong() {
		Tabela t = new Tabela(2,3);
		TabelaPK pk = new TabelaPK(2,3);
		assertNotNull(t);
		assertEquals(pk, t.getTabelaPK());
		assertEquals(null, t.getBrojPoraza());
		assertEquals(null, t.getBrojPobeda());
		assertEquals(null, t.getKosRazlika());
		assertEquals(null, t.getLiga());
		assertEquals(null, t.getTimid());
	}

	@Test
	void testSetTabelaPK() {
		TabelaPK pk = new TabelaPK(2,3);
		tabela1.setTabelaPK(pk);
		assertEquals(pk, tabela1.getTabelaPK());
	}

	@Test
	void testSetBrojPobeda() {
		tabela1.setBrojPobeda(2);
		assertEquals(2, tabela1.getBrojPobeda());
	}

	@Test
	void testSetBrojPoraza() {
		tabela1.setBrojPoraza(3);
		assertEquals(3, tabela1.getBrojPoraza());
	}

	@Test
	void testSetKosRazlika() {
		tabela1.setKosRazlika(2);
		assertEquals(2, tabela1.getKosRazlika());
	}

	@Test
	void testSetLigaNull() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->tabela1.setLiga(null));
	}
	
	
	@Test
	void testSetLiga() {
		Liga l = new Liga();
		tabela1.setLiga(l);
		assertEquals(l, tabela1.getLiga());
	}

	@Test
	void testSetTimid() {
		Tim tim = new Tim();
		tabela1.setTimid(tim);
		assertEquals(tim, tabela1.getTimid());
	}


	@Test
	void testEqualsIstaLokacija() {
		tabela2 = tabela1;
		assertTrue(tabela1.equals(tabela2));
		
	}
	@Test
	void testEqualsRazlicitaKlasa() {
		
		assertFalse(tabela1.equals(new Object()));
		
	}
	@Test
	void testEqualsNull() {
		
		assertFalse(tabela1.equals(null));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,2,1,2,true",
		"1,2,1,3,false",
		"1,2,3,2,false",
		"1,2,3,5,false"
		
	})
	void testEqualsObject(long tabelaId1,long ligaId1,long tabelaId2,long ligaId2,boolean equal) {
		TabelaPK tabelaPk1 = new TabelaPK();
		TabelaPK tabelaPk2 = new TabelaPK();
		
		tabelaPk1.setTabelaid(tabelaId1);
		tabelaPk1.setLigaid(ligaId1);
		tabelaPk2.setTabelaid(tabelaId2);
		tabelaPk2.setLigaid(ligaId2);
		tabela1.setTabelaPK(tabelaPk1);
		tabela2.setTabelaPK(tabelaPk2);
		assertEquals(equal, tabela1.equals(tabela2));
	}



	@Test
	void testToString() {
		TabelaPK pk = new TabelaPK(2,3);
		
		tabela1.setTabelaPK(pk);
		tabela1.setBrojPobeda(5);
		tabela1.setBrojPoraza(1);
		tabela1.setKosRazlika(8);
		Liga l = new Liga(4L);
		
		Drzava d = new Drzava();
		d.setNaziv("Srbija");
		l.setNaziv("KLS");
		l.setDrzavaId(d);
		tabela1.setLiga(l);
		Tim tim = new Tim();
		
		tim.setNaziv("Partizan");
		tabela1.setTimid(tim);
		Grad g = new Grad();
		g.setNaziv("Beograd");
		tim.setGrad(g);
		
		assertTrue(tabela1.toString().contains("2"));
		assertTrue(tabela1.toString().contains("3"));
		assertTrue(tabela1.toString().contains("5"));
		assertTrue(tabela1.toString().contains("1"));
		assertTrue(tabela1.toString().contains("8"));
		assertTrue(tabela1.toString().contains("KLS"));
		assertTrue(tabela1.toString().contains("Beograd"));
		assertTrue(tabela1.toString().contains("Partizan"));
	}

}
