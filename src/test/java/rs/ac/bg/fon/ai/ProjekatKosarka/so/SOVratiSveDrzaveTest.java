package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig.TransactionMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Drzava;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.DrzavaRepository;


class SOVratiSveDrzaveTest extends ApstraktnaSistemskaOperacijaTest {

	
	SOVratiSveDrzave test;
	@Autowired
	ApplicationContext context;

	
	@BeforeEach
	void setUp() throws Exception {
		DrzavaRepository repository = context.getBean(DrzavaRepository.class);
		test = new SOVratiSveDrzave(repository);
	}

	@AfterEach
	
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	@Sql(scripts = "/insert_drzava.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		try {
			test.izvrsavanjeOperacije(new Drzava());
			List<Drzava> listaDrzava = (List<Drzava>) test.getResult();
			assertEquals(2, listaDrzava.size());
			Drzava d1 = new Drzava();
			d1.setDrzavaId(13L);
			d1.setNaziv("SAD");
			Drzava d2 = new Drzava();
			d2.setDrzavaId(14L);
			d2.setNaziv("Francuska");
			assertEquals(d1, listaDrzava.get(0));
			assertEquals(d2, listaDrzava.get(1));
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}

	}
}
