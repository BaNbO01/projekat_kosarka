package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GradTest {

	Grad g1,g2;
	
	@BeforeEach
	void setUp() throws Exception {
		
		g1 = new Grad();
		g2 = new Grad();
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testGrad() {
		Grad grad = new Grad();
		assertNotNull(grad);
		assertEquals(null,grad.getGradPK());
		assertEquals(null,grad.getDrzava());
		assertEquals(null,grad.getNaziv());
	}

	@Test
	void testSetGradPK() {
		GradPK pk1 = new GradPK(1,2);
		g1.setGradPK(pk1);
		assertEquals(pk1, g1.getGradPK());
	}

	@Test
	void testSetDrzava() {
		Drzava d = new Drzava();
		g1.setDrzava(d);
		assertEquals(d, g1.getDrzava());
	}

	@Test
	void testSetNaziv() {
		g1.setNaziv("Beograd");
		assertEquals("Beograd", g1.getNaziv());
	}

	@Test
	void testToString() {
		g1.setDrzava(new Drzava());
		g1.setNaziv("Beograd");
		g1.setGradPK(new GradPK());
		assertTrue(g1.toString().contains("Beograd"));
	}

	@ParameterizedTest
	@CsvSource({
		"1,2,1,2,true",
		"1,2,1,3,false",
		"1,2,3,2,false",
		"1,2,3,5,false"
		
		
	})
	void testEqualsObject(long gradId1,long drzavaId1,long gradId2,long drzavaId2,boolean equal) {
		GradPK gradPK1 = new GradPK();
		GradPK gradPK2 = new GradPK();
		gradPK1.setGradID(gradId1);
		gradPK1.setDrzavaID(drzavaId1);
		gradPK2.setDrzavaID(drzavaId2);
		gradPK2.setGradID(gradId2);
		g1.setGradPK(gradPK1);
		g2.setGradPK(gradPK2);
		assertEquals(equal, g1.equals(g2));
	}

}
