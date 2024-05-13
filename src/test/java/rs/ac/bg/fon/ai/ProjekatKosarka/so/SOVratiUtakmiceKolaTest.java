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
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.KoloPK;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Utakmica;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.UtakmicaRepository;

class SOVratiUtakmiceKolaTest extends ApstraktnaSistemskaOperacijaTest {

	SOVratiUtakmiceKola test;
	@Autowired
	ApplicationContext applicationContext;
	@BeforeEach
	void setUp() throws Exception {
		test = new SOVratiUtakmiceKola(applicationContext.getBean(UtakmicaRepository.class));
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
	void testValidateKoloIdNull() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(new Utakmica()));
	}

	@Test
	void testValidate() {
		Utakmica u = new Utakmica();
		Kolo k = new Kolo();
		u.setKolo(k);
		
		assertDoesNotThrow(()->test.validate(u));
		
	}
	@Test
	@Sql(scripts = "/insert_utakmica_kolo.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		Utakmica u = new Utakmica();
		Kolo k = new Kolo();
		KoloPK pk = new KoloPK(1,1);
		k.setKoloPK(pk);
		u.setKolo(k);
		try {
			test.izvrsavanjeOperacije(u);
			List<Utakmica> listaUtakmica = (List<Utakmica>)test.getResult();
			assertEquals(2, listaUtakmica.size());
			assertEquals(1, listaUtakmica.get(0).getUtakmicaPK().getUtakmicaId());
			assertEquals(1, listaUtakmica.get(0).getUtakmicaPK().getKoloId());
			assertEquals(1, listaUtakmica.get(0).getUtakmicaPK().getLigaId());
			assertEquals(2, listaUtakmica.get(1).getUtakmicaPK().getUtakmicaId());
			assertEquals(1, listaUtakmica.get(1).getUtakmicaPK().getKoloId());
			assertEquals(1, listaUtakmica.get(1).getUtakmicaPK().getLigaId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
