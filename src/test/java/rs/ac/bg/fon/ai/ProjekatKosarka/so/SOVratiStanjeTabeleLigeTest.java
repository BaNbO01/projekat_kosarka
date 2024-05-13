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

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.TabelaRepository;

class SOVratiStanjeTabeleLigeTest extends ApstraktnaSistemskaOperacijaTest {

	SOVratiStanjeTabeleLige test;
	@Autowired
	ApplicationContext applicationContext;
	

	@BeforeEach
	void setUp() throws Exception {
		test = new SOVratiStanjeTabeleLige(applicationContext.getBean(TabelaRepository.class));
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
		Tabela t = new Tabela();
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(t));
	}
	
	@Test
	void testValidateLigaIdNull() {
		Tabela t = new Tabela();
		Liga l = new Liga();
		t.setLiga(l);
		assertThrows(java.lang.IllegalArgumentException.class, ()->test.validate(t));
	}
	
	@Test
	void testValidate() {
		Tabela t = new Tabela();
		Liga l = new Liga();
		t.setLiga(l);
		l.setLigaId(1L);
		assertDoesNotThrow(()->test.validate(t));
	}

	@Test
	@Sql(scripts = "/insert_utakmica_kolo.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		
		try {
			Tabela t = new Tabela();
			Liga l = new Liga();
			l.setLigaId(1L);
			t.setLiga(l);
			test.izvrsavanjeOperacije(t);
			List<Tabela> listaTabela = (List<Tabela>)test.getResult();
			assertEquals(4, listaTabela.size());
			assertEquals(6, listaTabela.get(0).getTabelaPK().getTabelaid());
			assertEquals(1, listaTabela.get(0).getTabelaPK().getLigaid());
			assertEquals(1, listaTabela.get(1).getTabelaPK().getTabelaid());
			assertEquals(1, listaTabela.get(1).getTabelaPK().getLigaid());
			assertEquals(4, listaTabela.get(2).getTabelaPK().getTabelaid());
			assertEquals(1, listaTabela.get(2).getTabelaPK().getLigaid());
			assertEquals(5, listaTabela.get(3).getTabelaPK().getTabelaid());
			assertEquals(1, listaTabela.get(3).getTabelaPK().getLigaid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}

}
