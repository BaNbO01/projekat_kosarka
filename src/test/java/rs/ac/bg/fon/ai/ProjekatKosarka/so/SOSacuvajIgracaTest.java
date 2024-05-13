package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Drzava;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Pozicija;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tim;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;

class SOSacuvajIgracaTest extends ApstraktnaSistemskaOperacijaTest {

	SOSacuvajIgraca test;
	Igraci i;
	@Autowired
	ApplicationContext applicationContext;
	@BeforeEach
	void setUp() throws Exception {
		test = new SOSacuvajIgraca(applicationContext.getBean(IgraciRepository.class));
		i = new Igraci();
		i.setBroj(5);
		i.setDatumRodjenja(new Date());
		i.setVisina(200.0);
		i.setPozicija(Pozicija.PG);
		i.setTimId(new Tim(1L));
		i.setPrezime("Zikic");
		i.setIme("Zika");
		i.setDrzavaId(new Drzava(1L));
		
	}
	

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void testValidatePogresanTip() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(new String()));
	}
	
	@Test
	void testValidateDrzavaNull() {
		i.setDrzavaId(null);
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(i));
	}
	
	@Test
	void testValidateImeBlank() {
		i.setIme("");
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(i));
	}
	
	@Test
	void testValidateImeManjeOdDvaKaraktera() {
		i.setIme("Z");
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(i));
	}
	
	@Test
	void testValidatePrezimeBlank() {
		i.setPrezime("");
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(i));
	}
	
	@Test
	void testValidatePrezimeManjeOdDvaKaraktera() {
		i.setPrezime("A");
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(i));
	}
	
	@Test
	void testValidate() {
		
		assertDoesNotThrow(()->test.validate(i));
	}

	@Test
	@Sql(scripts = "/save_igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		try {
			test.izvrsavanjeOperacije(i);
			IgraciRepository repository = applicationContext.getBean(IgraciRepository.class);
			List<Igraci> listaIgraci = (List<Igraci>)repository.findAll();
			assertEquals(1, listaIgraci.size());
			assertEquals("Zika", listaIgraci.get(0).getIme());
			i.setIme("Laza");
			test.izvrsavanjeOperacije(i);
			 listaIgraci = (List<Igraci>)repository.findAll();
			assertEquals(1, listaIgraci.size());
			assertEquals("Laza", listaIgraci.get(0).getIme());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
