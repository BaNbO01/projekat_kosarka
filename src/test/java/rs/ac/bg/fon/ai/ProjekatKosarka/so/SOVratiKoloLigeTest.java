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

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.KoloRepository;

class SOVratiKoloLigeTest extends ApstraktnaSistemskaOperacijaTest {

	SOVratiKoloLige test;
	@Autowired
	ApplicationContext applicationContext;

	@BeforeEach
	void setUp() throws Exception {
		test = new SOVratiKoloLige(applicationContext.getBean(KoloRepository.class));
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
	void testValidateLigaNull() {
		Kolo k = new Kolo();
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(k));
	}
	
	@Test
	void testValidate() {
		Kolo k = new Kolo();
		Liga l = new Liga();
		l.setLigaId(1L);
		k.setLiga(l);
		assertDoesNotThrow(()->test.validate(k));
	}
	@Test
	@Sql(scripts = "/insert_kolo_liga.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		
		
		try {
			Kolo k = new Kolo();
			Liga l = new Liga();
			l.setLigaId(1L);
			k.setLiga(l);
			test.izvrsavanjeOperacije(k);
			List<Kolo> listaKola = (List<Kolo>)test.getResult();
			assertEquals(3, listaKola.size());
			assertEquals(1, listaKola.get(0).getKoloPK().getKoloId());
			assertEquals(1, listaKola.get(0).getKoloPK().getLigaId());
			assertEquals(2, listaKola.get(1).getKoloPK().getKoloId());
			assertEquals(1, listaKola.get(1).getKoloPK().getLigaId());
			assertEquals(3, listaKola.get(2).getKoloPK().getKoloId());
			assertEquals(1, listaKola.get(2).getKoloPK().getLigaId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		}

}
