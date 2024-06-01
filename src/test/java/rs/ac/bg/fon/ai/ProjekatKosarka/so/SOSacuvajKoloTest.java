package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

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
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.KoloPK;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.KoloRepository;

class SOSacuvajKoloTest extends ApstraktnaSistemskaOperacijaTest {

	SOSacuvajKolo test;
	@Autowired
	ApplicationContext applicationContext;
	Kolo kolo;
	@BeforeEach
	void setUp() throws Exception {
		test = new SOSacuvajKolo(applicationContext.getBean(KoloRepository.class));
		kolo = new Kolo();
		Liga liga = new Liga();
		liga.setLigaId(1L);
		liga.setNaziv("NBA");
		liga.setDrzavaId(new Drzava(13L));
		kolo.setLiga(liga);
		KoloPK pk = new KoloPK();
		pk.setLigaId(liga.getLigaId());
		kolo.setKoloPK(pk);
		
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
	void testValidate() {
		
		assertDoesNotThrow(()->test.validate(kolo));
	}

	@Test
	@Sql(scripts = "/liga_insert.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		try {
			test.izvrsavanjeOperacije(kolo);
			KoloRepository repository = applicationContext.getBean(KoloRepository.class);
			List<Kolo> listaKolo = repository.findAll();
			assertEquals(1, listaKolo.size());
			assertEquals(kolo, listaKolo.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
