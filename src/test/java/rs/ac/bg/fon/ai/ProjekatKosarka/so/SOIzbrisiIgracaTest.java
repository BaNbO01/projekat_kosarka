package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;

class SOIzbrisiIgracaTest extends ApstraktnaSistemskaOperacijaTest {

	SOIzbrisiIgraca test;
	@Autowired
	ApplicationContext applicationContext;

	@BeforeEach
	void setUp() throws Exception {
		test = new SOIzbrisiIgraca(applicationContext.getBean(IgraciRepository.class));
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
	void testValidateIgracIdNull() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(new Igraci()));
	}
	
	@Test
	void testValidate() {
		Igraci i = new Igraci(1L);
		assertDoesNotThrow(()->test.validate(i));
	}

	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		try {
			Igraci i = new Igraci(1L);
			test.izvrsavanjeOperacije(i);
			IgraciRepository repository = applicationContext.getBean(IgraciRepository.class);
			assertEquals(Optional.empty(), repository.findById(i.getIgracID()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
