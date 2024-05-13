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

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tim;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.TimRepository;

class SOVratiSveTimoveTest extends ApstraktnaSistemskaOperacijaTest {

	SOVratiSveTimove test;
	@Autowired
	ApplicationContext applicationContext;
	@BeforeEach
	void setUp() throws Exception {
		test = new SOVratiSveTimove(applicationContext.getBean(TimRepository.class));
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	

	@Test
	@Sql(scripts = "/insert_timovi.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		try {
			test.izvrsavanjeOperacije(new Tim());
			List<Tim> listaTimova = (List<Tim>)test.getResult();
			assertEquals(2, listaTimova.size());
			assertEquals(1, listaTimova.get(0).getTimId());
			assertEquals(4, listaTimova.get(1).getTimId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
