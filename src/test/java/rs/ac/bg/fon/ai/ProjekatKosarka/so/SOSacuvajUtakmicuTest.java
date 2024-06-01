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
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.KoloPK;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tim;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Utakmica;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.UtakmicaPK;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.TabelaRepository;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.UtakmicaRepository;

class SOSacuvajUtakmicuTest extends ApstraktnaSistemskaOperacijaTest {

	SOSacuvajUtakmicu test;
	@Autowired
	ApplicationContext applicationContext;
	Utakmica utakmica;
	@BeforeEach
	void setUp() throws Exception {
		test = new SOSacuvajUtakmicu(applicationContext.getBean(UtakmicaRepository.class), applicationContext.getBean(TabelaRepository.class));
		utakmica = new Utakmica();
		utakmica.setBrojKosevaTima1(82);
		utakmica.setBrojKosevaTima2(80);
		utakmica.setTimid1(new Tim(1L));
		utakmica.setTimid2(new Tim(2L));
		Kolo kolo = new Kolo();
	
		KoloPK pk = new KoloPK();
		pk.setKoloId(1);
		pk.setLigaId(1);
		kolo.setKoloPK(pk);
		kolo.setLiga(new Liga(pk.getLigaId()));
		UtakmicaPK utakmicaPK = new UtakmicaPK();
		utakmicaPK.setKoloId(pk.getKoloId());
		utakmicaPK.setLigaId(pk.getLigaId());
		utakmica.setKolo(kolo);
		utakmica.setUtakmicaPK(utakmicaPK);
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
		assertDoesNotThrow(()->test.validate(utakmica));
	}


	@Test
	@Sql(scripts = "/insert_utakmica_tabela.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacije() {
		try {
			test.izvrsavanjeOperacije(utakmica);
			
			UtakmicaRepository repositoryUtakmica = applicationContext.getBean(UtakmicaRepository.class);
			List<Utakmica> listaUtakmica = repositoryUtakmica.findAll();
			assertEquals(1, listaUtakmica.size());
			assertEquals(utakmica.getUtakmicaPK().getKoloId(), listaUtakmica.get(0).getUtakmicaPK().getKoloId());
			assertEquals(utakmica.getUtakmicaPK().getLigaId(), listaUtakmica.get(0).getUtakmicaPK().getLigaId());
			utakmica.setUtakmicaPK(listaUtakmica.get(0).getUtakmicaPK());
			TabelaRepository repositoryTabela = applicationContext.getBean(TabelaRepository.class);
			List<Tabela> listaTabela = repositoryTabela.findAll();
			assertEquals(2, listaTabela.size());
			assertEquals(utakmica.getTimid1(), listaTabela.get(0).getTimid());
			assertEquals(utakmica.getTimid2(),listaTabela.get(1).getTimid());
			assertEquals(2, listaTabela.get(0).getKosRazlika());
			assertEquals(-2, listaTabela.get(1).getKosRazlika());
			assertEquals(1, listaTabela.get(0).getBrojPobeda());
			assertEquals(0, listaTabela.get(1).getBrojPobeda());
			assertEquals(0, listaTabela.get(0).getBrojPoraza());
			assertEquals(1, listaTabela.get(1).getBrojPoraza());
			assertEquals(utakmica.getKolo().getLiga(), listaTabela.get(0).getLiga());
			assertEquals(utakmica.getKolo().getLiga(), listaTabela.get(1).getLiga());
			
			utakmica.setBrojKosevaTima1(80);
			utakmica.setBrojKosevaTima2(84);
			test.izvrsavanjeOperacije(utakmica);
			
			 listaUtakmica = repositoryUtakmica.findAll();
			assertEquals(1, listaUtakmica.size());
			assertEquals(utakmica.getUtakmicaPK().getKoloId(), listaUtakmica.get(0).getUtakmicaPK().getKoloId());
			assertEquals(utakmica.getUtakmicaPK().getLigaId(), listaUtakmica.get(0).getUtakmicaPK().getLigaId());
			repositoryTabela = applicationContext.getBean(TabelaRepository.class);
			listaTabela = repositoryTabela.findAll();
			assertEquals(2, listaTabela.size());
			assertEquals(utakmica.getTimid1(), listaTabela.get(0).getTimid());
			assertEquals(utakmica.getTimid2(),listaTabela.get(1).getTimid());
			
			
			
			assertEquals(-2, listaTabela.get(0).getKosRazlika());
			assertEquals(2, listaTabela.get(1).getKosRazlika());
			assertEquals(1, listaTabela.get(0).getBrojPobeda());
			assertEquals(1, listaTabela.get(1).getBrojPobeda());
			assertEquals(1, listaTabela.get(0).getBrojPoraza());
			assertEquals(1, listaTabela.get(1).getBrojPoraza());
			assertEquals(utakmica.getKolo().getLiga(), listaTabela.get(0).getLiga());
			assertEquals(utakmica.getKolo().getLiga(), listaTabela.get(1).getLiga());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			}
	}

}
