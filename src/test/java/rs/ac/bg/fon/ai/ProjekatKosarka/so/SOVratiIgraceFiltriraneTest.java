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

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Pozicija;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;

class SOVratiIgraceFiltriraneTest extends ApstraktnaSistemskaOperacijaTest{

	SOVratiIgraceFiltrirane test;
	@Autowired
	ApplicationContext applicationContext;
	Igraci igraci;
	@BeforeEach
	void setUp() throws Exception {
		test = new SOVratiIgraceFiltrirane(applicationContext.getBean(IgraciRepository.class));
		igraci = new Igraci();
		igraci.setPozicija(Pozicija.PF);
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
		assertDoesNotThrow(()->test.validate(new Igraci()));
	}
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijeSamoPozicija() {
		try {
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(2, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(Pozicija.PF, listaIgraci.get(1).getPozicija());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIIme() {
		try {
			igraci.setIme("Goran");
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getIme(), listaIgraci.get(0).getIme());
			igraci.setIme("Zika");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setIme("Goran");
			igraci.setPozicija(Pozicija.C);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIPrezime() {
		try {
			igraci.setPrezime("Tomic");
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getPrezime(), listaIgraci.get(0).getPrezime());
			igraci.setPrezime("Zikic");
			test.izvrsavanjeOperacije(igraci);
			 listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setPrezime("Tomic");
			igraci.setPozicija(Pozicija.C);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIBroj() {
		try {
			igraci.setBroj(6);
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getBroj(), listaIgraci.get(0).getBroj());
			igraci.setBroj(25);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setBroj(6);
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIVisina() {
		try {
			igraci.setVisina(206.0);
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getVisina(), listaIgraci.get(0).getVisina());
			igraci.setVisina(210.0);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIImeIPrezime() {
		try {
			igraci.setIme("Goran");
			igraci.setPrezime("Tomic");
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getIme(), listaIgraci.get(0).getIme());
			assertEquals(igraci.getPrezime(), listaIgraci.get(0).getPrezime());
			igraci.setPrezime("Dodic");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setPrezime("Tomic");
			igraci.setIme("Zika");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setIme("Goran");
			igraci.setPrezime("Tomic");
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIImeIBroj() {
		try {
			igraci.setIme("Goran");
			igraci.setBroj(4);
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getIme(), listaIgraci.get(0).getIme());
			assertEquals(igraci.getBroj(), listaIgraci.get(0).getBroj());
			igraci.setBroj(2);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setBroj(4);
			igraci.setIme("Zika");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setBroj(4);
			igraci.setIme("Goran");
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIImeIVisina() {
		try {
			igraci.setIme("Goran");
			igraci.setVisina(206.0);
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getIme(), listaIgraci.get(0).getIme());
			assertEquals(igraci.getVisina(), listaIgraci.get(0).getVisina());
			igraci.setVisina(210.0);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setIme("Zika");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setIme("Goran");
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIPrezimeIBroj() {
		try {
			igraci.setPrezime("Tomic");
			igraci.setBroj(4);
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getPrezime(), listaIgraci.get(0).getPrezime());
			assertEquals(igraci.getBroj(), listaIgraci.get(0).getBroj());
			igraci.setBroj(2);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setBroj(4);
			igraci.setPrezime("Zikic");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setBroj(4);
			igraci.setPrezime("Zikic");
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIPrezimeIVisina() {
		try {
			igraci.setPrezime("Tomic");
			igraci.setVisina(206.0);
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getPrezime(), listaIgraci.get(0).getPrezime());
			assertEquals(igraci.getVisina(), listaIgraci.get(0).getVisina());
			igraci.setPrezime("Zikic");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(210.0);
			igraci.setPrezime("Tomic");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setPrezime("Tomic");
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIBrojIVisina() {
		try {
			igraci.setVisina(206.0);
			igraci.setBroj(4);
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getVisina(), listaIgraci.get(0).getVisina());
			assertEquals(igraci.getBroj(), listaIgraci.get(0).getBroj());
			igraci.setBroj(2);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setBroj(4);
			igraci.setVisina(210.0);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setBroj(4);
			igraci.setVisina(206.0);
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIImeIPrezimeIBroj() {
		try {
			igraci.setIme("Goran");
			igraci.setBroj(4);
			igraci.setPrezime("Tomic");
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getIme(), listaIgraci.get(0).getIme());
			assertEquals(igraci.getBroj(), listaIgraci.get(0).getBroj());
			assertEquals(igraci.getPrezime(), listaIgraci.get(0).getPrezime());
			igraci.setBroj(2);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setBroj(4);
			igraci.setIme("Zika");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setBroj(4);
			igraci.setIme("Goran");
			igraci.setPrezime("Dodic");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setBroj(4);
			igraci.setIme("Goran");
			igraci.setPrezime("Tomic");
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIImeIPrezimeIVisina() {
		try {
			igraci.setIme("Goran");
			igraci.setVisina(206.0);
			igraci.setPrezime("Tomic");
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getIme(), listaIgraci.get(0).getIme());
			assertEquals(igraci.getVisina(), listaIgraci.get(0).getVisina());
			assertEquals(igraci.getPrezime(), listaIgraci.get(0).getPrezime());
			igraci.setVisina(203.0);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setIme("Zika");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setIme("Goran");
			igraci.setPrezime("Dodic");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setIme("Goran");
			igraci.setPrezime("Tomic");
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}

	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIPrezimeIVisinaIBroj() {
		try {
			igraci.setBroj(4);
			igraci.setVisina(206.0);
			igraci.setPrezime("Tomic");
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getBroj(), listaIgraci.get(0).getBroj());
			assertEquals(igraci.getVisina(), listaIgraci.get(0).getVisina());
			assertEquals(igraci.getPrezime(), listaIgraci.get(0).getPrezime());
			igraci.setVisina(203.0);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setBroj(5);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setBroj(4);
			igraci.setPrezime("Dodic");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setPrezime("Tomic");
			igraci.setBroj(4);
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijePozicijaIImeIVisinaIBroj() {
		try {
			igraci.setBroj(4);
			igraci.setVisina(206.0);
			igraci.setIme("Goran");
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getBroj(), listaIgraci.get(0).getBroj());
			assertEquals(igraci.getVisina(), listaIgraci.get(0).getVisina());
			assertEquals(igraci.getIme(), listaIgraci.get(0).getIme());
			igraci.setVisina(203.0);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setBroj(5);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setBroj(4);
			igraci.setIme("Zika");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setIme("Goran");
			igraci.setBroj(4);
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	@Sql(scripts = "/igraci.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED))
	@Sql(scripts = "/delete_all_data.sql",config = @SqlConfig(transactionMode = TransactionMode.ISOLATED),executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	void testIzvrsavanjeOperacijeSviParametri() {
		try {
			igraci.setBroj(4);
			igraci.setVisina(206.0);
			igraci.setIme("Goran");
			igraci.setPrezime("Tomic");
			test.izvrsavanjeOperacije(igraci);
			List<Igraci> listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(1, listaIgraci.size());
			assertEquals(Pozicija.PF, listaIgraci.get(0).getPozicija());
			assertEquals(igraci.getBroj(), listaIgraci.get(0).getBroj());
			assertEquals(igraci.getVisina(), listaIgraci.get(0).getVisina());
			assertEquals(igraci.getIme(), listaIgraci.get(0).getIme());
			assertEquals(igraci.getPrezime(), listaIgraci.get(0).getPrezime());
			igraci.setVisina(203.0);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setBroj(5);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setBroj(4);
			igraci.setIme("Marko");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setIme("Goran");
			igraci.setBroj(4);
			igraci.setPrezime("Zikic");
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			igraci.setVisina(206.0);
			igraci.setIme("Goran");
			igraci.setBroj(4);
			igraci.setPrezime("Tomic");
			igraci.setPozicija(Pozicija.C);
			test.izvrsavanjeOperacije(igraci);
			listaIgraci = (List<Igraci>)test.getResult();
			assertEquals(0, listaIgraci.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	
}
