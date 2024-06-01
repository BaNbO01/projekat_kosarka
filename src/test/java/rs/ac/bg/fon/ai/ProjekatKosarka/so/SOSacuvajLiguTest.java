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
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.LigaRepository;

class SOSacuvajLiguTest extends ApstraktnaSistemskaOperacijaTest{

	SOSacuvajLigu test;
	@Autowired
	ApplicationContext applicationContext;
	Liga liga;
	@BeforeEach
	void setUp() throws Exception {
		test = new SOSacuvajLigu(applicationContext.getBean(LigaRepository.class));
		liga = new Liga();
		liga.setNaziv("NBA");
		liga.setDrzavaId(new Drzava(13L));
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
		assertDoesNotThrow(()->test.validate(liga));
	}

	
	@Test
	@Sql(scripts = "/insert_drzava.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		try {
			test.izvrsavanjeOperacije(liga);
			LigaRepository repository = applicationContext.getBean(LigaRepository.class);
			List<Liga> listaLiga = repository.findAll();
			assertEquals(1, listaLiga.size());
			assertEquals(liga, listaLiga.get(0));
			assertEquals("NBA", listaLiga.get(0).getNaziv());
			liga.setNaziv("NCAA");
			test.izvrsavanjeOperacije(liga);
			listaLiga = repository.findAll();
			assertEquals(1, listaLiga.size());
			assertEquals(liga, listaLiga.get(0));
			assertEquals("NCAA", listaLiga.get(0).getNaziv());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
