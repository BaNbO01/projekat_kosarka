package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.LigaRepository;

class SOVratiSveLigeTest extends ApstraktnaSistemskaOperacijaTest {

	SOVratiSveLige test;
	@Autowired
	ApplicationContext applicationContext;

	@BeforeEach
	void setUp() throws Exception {
		test = new SOVratiSveLige(applicationContext.getBean(LigaRepository.class));
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	

	@Test
	@Sql(scripts = "/liga_insert.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		try {
			test.izvrsavanjeOperacije(new Liga());
			List<Liga> listaLiga = (List<Liga>)test.getResult();
			assertEquals(3, listaLiga.size());
			assertEquals(1, listaLiga.get(0).getLigaId());
			assertEquals(2, listaLiga.get(1).getLigaId());
			assertEquals(3, listaLiga.get(2).getLigaId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
