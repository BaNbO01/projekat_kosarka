package rs.ac.bg.fon.ai.ProjekatKosarka.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LogTest {

	Log log1,log2;
	@BeforeEach
	void setUp() throws Exception {
		log1 = new Log();
		log2 = new Log();
	}

	@AfterEach
	void tearDown() throws Exception {
		log1 = null;
		log2 = null;
	}

	@Test
	void testLog() {
		log1 = new Log();
		assertNotNull(log1);
		assertEquals(null, log1.getNazivSistemskeOperacije());
		assertEquals(null, log1.getVremeIzvrsavanja());
		assertEquals(null, log1.getUspesnoIzvrsenaOperacija());
	}

	@Test
	void testLogStringDateBoolean() {
		Date d = new Date();
		log1 = new Log("Log",d,false);
		assertNotNull(log1);
		assertEquals("Log", log1.getNazivSistemskeOperacije());
		assertEquals(d, log1.getVremeIzvrsavanja());
		assertEquals(false, log1.getUspesnoIzvrsenaOperacija());
	}

	@Test
	void testSetNazivSistemskeOperacije() {
		log1.setNazivSistemskeOperacije("Log");
		assertEquals("Log", log1.getNazivSistemskeOperacije());
	}

	@Test
	void testSetVremeIzvrsavanja() {
		Date d = new Date();
		log1.setVremeIzvrsavanja(d);
		assertEquals(d, log1.getVremeIzvrsavanja());
	}

	@Test
	void testSetUspesnoIzvrsenaOperacija() {
		log1.setUspesnoIzvrsenaOperacija(false);
		assertEquals(false, log1.getUspesnoIzvrsenaOperacija());
	}

	@Test
	void testEqualsIstaLokacija() {
		log2 = log1;
		assertTrue(log1.equals(log2));
		
	}
	@Test
	void testEqualsRazlicitaKlasa() {
		
		assertFalse(log1.equals(new Object()));
		
	}
	@Test
	void testEqualsNull() {
		
		assertFalse(log1.equals(null));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"Log,02-03-2024 06:50:12,true,Log,02-03-2024 06:50:12,true,true",
		"Log,02-03-2024 06:50:12,true,Log,02-03-2024 06:50:12,false,false",
		"Log,02-03-2024 06:50:12,true,Log,02-03-2024 06:58:12,true,false",
		"Log,02-03-2024 06:50:12,true,Json,02-03-2024 06:50:12,true,false",
		"Log,02-03-2024 06:50:12,true,Json,02-03-2024 06:52:12,true,false",
		"Log,02-03-2024 06:50:12,true,Json,02-03-2024 06:50:12,false,false",
		"Log,02-03-2024 06:50:12,true,Log,02-03-2024 06:54:12,false,false",
		"Log,02-03-2024 06:50:12,true,Json,02-03-2024 07:50:12,false,false",
		
	})
	void testEqualsObject(String naziv1,String vreme1,boolean uspesnost1,String naziv2,String vreme2,boolean uspesno2,boolean equal) {
		try {
			log1.setNazivSistemskeOperacije(naziv1);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			Date vremeIz1 = formatter.parse(vreme1);
			log1.setVremeIzvrsavanja(vremeIz1);
			log1.setUspesnoIzvrsenaOperacija(uspesnost1);
			log2.setNazivSistemskeOperacije(naziv2);
			Date vremeIz2 = formatter.parse(vreme2);
			log2.setVremeIzvrsavanja(vremeIz2);
			log2.setUspesnoIzvrsenaOperacija(uspesno2);
			assertEquals(equal, log1.equals(log2));
		}catch(Exception e) {
			
		}
		
	}


	@Test
	void testToString() {
		log1.setNazivSistemskeOperacije("Log");
		Date d = new Date();
		log1.setVremeIzvrsavanja(d);
		log1.setUspesnoIzvrsenaOperacija(true);
		assertTrue(log1.toString().contains("Log"));
		assertTrue(log1.toString().contains(d.toString()));
		assertTrue(log1.toString().contains("true"));
	}

}
