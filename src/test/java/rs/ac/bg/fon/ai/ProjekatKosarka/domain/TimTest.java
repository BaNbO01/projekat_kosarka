package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TimTest {

	Tim tim1,tim2;
	@BeforeEach
	void setUp() throws Exception {
		tim1 = new Tim();
		tim2 = new Tim();
	}

	@AfterEach
	void tearDown() throws Exception {
		tim1 = null;
		tim2 = null;
	}

	@Test
	void testTim() {
		Tim tim = new Tim();
		assertNotNull(tim);
		assertEquals(null, tim.getGrad());
		assertEquals(null, tim.getIgraciList());
		assertEquals(null, tim.getNaziv());
		assertEquals(null, tim.getTimId());
	}

	@Test
	void testTimLong() {
		Tim tim = new Tim(2L);
		assertNotNull(tim);
		assertEquals(2L, tim.getTimId());
		assertEquals(null, tim.getGrad());
		assertEquals(null, tim.getIgraciList());
		assertEquals(null, tim.getNaziv());
		
	}

	@Test
	void testSetTimIdNull() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->tim1.setTimId(null));
	}
	
	@Test
	void testSetTimId() {
		tim1.setTimId(2L);
		assertEquals(2L, tim1.getTimId());
	}

	@Test
	void testSetNaziv() {
		tim1.setNaziv("Partizan");
		assertEquals("Partizan",tim1.getNaziv());
	}

	@Test
	void testSetGrad() {
		Grad g = new Grad();
		tim1.setGrad(g);
		assertEquals(g, tim1.getGrad());
	}

	@Test
	void testSetIgraciList() {
		List<Igraci> igraci = new ArrayList<>();
			
			tim1.setIgraciList(igraci);
			assertEquals(igraci, tim1.getIgraciList());
	}

	@Test
	void testEqualsNull(){
		assertFalse(tim1.equals(null));
	}
	
	@Test
	void testEqualsIstaLokacija(){
		tim2=tim1;
		assertTrue(tim1.equals(tim2));
	}
	@Test
	void testEqualsRazlicitaKlasa(){
	
		assertFalse(tim1.equals(new Object()));
	}

	@ParameterizedTest
	@CsvSource({
		"1,1,true",
		"1,2,false"
		
	})
	void testEqualsObject(Long id1,Long id2, boolean equal) {
		tim1.setTimId(id1);
		tim2.setTimId(id2);
		assertEquals(equal,tim1.equals(tim2));
	}


	@Test
	void testToString() {
		Grad grad = new Grad();
		grad.setNaziv("Beograd");
		tim1.setGrad(grad);
		tim1.setNaziv("Partizan");
		assertTrue(tim1.toString().contains("Partizan"));
		assertTrue(tim1.toString().contains("Beograd"));
	}

}
