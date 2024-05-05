package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GradPKTest {

	GradPK gradPK1,gradPK2;
	@BeforeEach
	void setUp() throws Exception {
		gradPK1 = new GradPK();
		gradPK2 = new GradPK();
	}

	@AfterEach
	void tearDown() throws Exception {
		gradPK1=null;
		gradPK2=null;
	}

	@Test
	void testGradPK() {
		GradPK gradPk = new GradPK();
		assertNotNull(gradPk);
		assertEquals(0,gradPk.getDrzavaID());
		assertEquals(0,gradPk.getGradID());
	}

	@Test
	void testGradPKLongLong() {
		GradPK gradPk = new GradPK(2, 3);
		assertEquals(2,gradPk.getGradID());
		assertEquals(3,gradPk.getDrzavaID());
	}

	@Test
	void testSetGradID() {
		gradPK1.setGradID(1);
		assertEquals(1,gradPK1.getGradID());
	}

	@Test
	void testSetDrzavaID() {
		gradPK1.setDrzavaID(1);
		assertEquals(1,gradPK1.getDrzavaID());
	}

	@ParameterizedTest
	@CsvSource({
		"1,2,1,2,true",
		"1,2,1,3,false",
		"1,2,3,2,false",
		"1,2,3,5,false"
		
	})
	void testEqualsObject(long gradId1,long drzavaId1,long gradId2,long drzavaId2,boolean equal) {
		gradPK1.setGradID(gradId1);
		gradPK1.setDrzavaID(drzavaId1);
		gradPK2.setDrzavaID(drzavaId2);
		gradPK2.setGradID(gradId2);
		assertEquals(equal, gradPK1.equals(gradPK2));
	}

	@Test
	void testToString() {
		gradPK1.setDrzavaID(1);
		gradPK1.setGradID(2);
		assertTrue(gradPK1.toString().contains("1"));
		assertTrue(gradPK1.toString().contains("2"));
	}

}
