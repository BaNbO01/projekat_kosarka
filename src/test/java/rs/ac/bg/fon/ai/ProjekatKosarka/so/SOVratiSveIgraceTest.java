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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;


class SOVratiSveIgraceTest extends ApstraktnaSistemskaOperacijaTest {

	SOVratiSveIgrace test;
	@Autowired
	ApplicationContext context;
	@BeforeEach
	void setUp() throws Exception {
		IgraciRepository repository = context.getBean(IgraciRepository.class);
		test = new SOVratiSveIgrace(repository);
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void testValidateCorrect() {
		assertDoesNotThrow(()->test.validate(new Igraci()));
	}
	
	@Test
	void testValidateIncorect() {
		assertThrows(java.lang.IllegalArgumentException.class,()->test.validate(new String()));
	}

	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		 try {
			test.izvrsavanjeOperacije(new Igraci());
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(4, listaIgraci.size());
			assertEquals(4,listaIgraci.get(0).getIgracID());
			assertEquals(7,listaIgraci.get(1).getIgracID());
			assertEquals(8,listaIgraci.get(2).getIgracID());
			assertEquals(9,listaIgraci.get(3).getIgracID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
		
	}

}
