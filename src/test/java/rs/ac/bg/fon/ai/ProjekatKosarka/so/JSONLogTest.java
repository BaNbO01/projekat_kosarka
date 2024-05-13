package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Log;

class JSONLogTest extends ApstraktnaSistemskaOperacijaTest {

	SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	JSONLog test;
	@Autowired
	ApplicationContext applicationContext;
	Log log;
	@BeforeEach
	void setUp() throws Exception {
		test = new JSONLog(applicationContext.getBean(Gson.class));
		log = new Log("SOVratiSveTimove", new Date(), true);
		test.setPath("src/test/resources/log.json");
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void testIzvrsiPrvoUnosenjeJedan() {
		try {
			 
			PrintWriter pw = new PrintWriter(new File(test.getPath()));
		       pw.close();
			test.setLog(log);
			test.izvrsi();
			BufferedReader br = new BufferedReader(new FileReader(test.getPath()));
			Gson gson = applicationContext.getBean(Gson.class);
			  Type type = new TypeToken<List<Log>>() {}.getType();
	         List<Log> lista = gson.fromJson(br, type);
	         assertEquals(1, lista.size());
	         assertEquals(log.getNazivSistemskeOperacije(), lista.get(0).getNazivSistemskeOperacije());
	         assertEquals(log.getUspesnoIzvrsenaOperacija(), lista.get(0).getUspesnoIzvrsenaOperacija());
	         assertEquals(formater.format(log.getVremeIzvrsavanja()), formater.format(lista.get(0).getVremeIzvrsavanja()));
	       
	         br.close();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	
	@Test
	void testIzvrsiPrvoUnosenjeVise() {
		try {
			PrintWriter pw = new PrintWriter(new File(test.getPath()));
		       pw.close();
			test.setLog(log);
			test.izvrsi();
			Log log2 = new Log();
			log2.setNazivSistemskeOperacije("SOVratiSveDrzave");
			log2.setUspesnoIzvrsenaOperacija(true);
			log2.setVremeIzvrsavanja(new Date());
			test.setLog(log2);
			test.izvrsi();
			BufferedReader br = new BufferedReader(new FileReader(test.getPath()));
			Gson gson = applicationContext.getBean(Gson.class);
			  Type type = new TypeToken<List<Log>>() {}.getType();
	         List<Log> lista = gson.fromJson(br, type);
	         assertEquals(2, lista.size());
	         
	         assertEquals(log.getNazivSistemskeOperacije(), lista.get(0).getNazivSistemskeOperacije());
	         assertEquals(log.getUspesnoIzvrsenaOperacija(), lista.get(0).getUspesnoIzvrsenaOperacija());
	         assertEquals(formater.format(log.getVremeIzvrsavanja()), formater.format(lista.get(0).getVremeIzvrsavanja()));
	         
	         
	         
	         assertEquals(log2.getNazivSistemskeOperacije(), lista.get(1).getNazivSistemskeOperacije());
	         assertEquals(log2.getUspesnoIzvrsenaOperacija(), lista.get(1).getUspesnoIzvrsenaOperacija());
	         assertEquals(formater.format(log2.getVremeIzvrsavanja()), formater.format(lista.get(1).getVremeIzvrsavanja()));
	         
	         
	  
	         br.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
	
	
	@Test
	void testIzvrsiPostojiVec() {
		try {
			Log log3 = new Log("SOVratiSveUtakmice",new Date(),true);
			Gson gson = applicationContext.getBean(Gson.class);
			PrintWriter pw = new PrintWriter(new File(test.getPath()));
			List<Log> listaLog = new ArrayList<>();
			listaLog.add(log3);
			gson.toJson(listaLog,pw);
			pw.close();
			
			test.setLog(log);
			test.izvrsi();
			Log log2 = new Log();
			log2.setNazivSistemskeOperacije("SOVratiSveDrzave");
			log2.setUspesnoIzvrsenaOperacija(true);
			log2.setVremeIzvrsavanja(new Date());
			test.setLog(log2);
			test.izvrsi();
			BufferedReader br = new BufferedReader(new FileReader(test.getPath()));
			  Type type = new TypeToken<List<Log>>() {}.getType();
	         List<Log> lista = gson.fromJson(br, type);
	         assertEquals(3, lista.size());
	         
	         
	         
	         assertEquals(log3.getNazivSistemskeOperacije(), lista.get(0).getNazivSistemskeOperacije());
	         assertEquals(log3.getUspesnoIzvrsenaOperacija(), lista.get(0).getUspesnoIzvrsenaOperacija());
	         assertEquals(formater.format(log3.getVremeIzvrsavanja()), formater.format(lista.get(0).getVremeIzvrsavanja()));
	         
	         
	         assertEquals(log.getNazivSistemskeOperacije(), lista.get(1).getNazivSistemskeOperacije());
	         assertEquals(log.getUspesnoIzvrsenaOperacija(), lista.get(1).getUspesnoIzvrsenaOperacija());
	         assertEquals(formater.format(log.getVremeIzvrsavanja()), formater.format(lista.get(1).getVremeIzvrsavanja()));
	         
	         
	         
	         assertEquals(log2.getNazivSistemskeOperacije(), lista.get(2).getNazivSistemskeOperacije());
	         assertEquals(log2.getUspesnoIzvrsenaOperacija(), lista.get(2).getUspesnoIzvrsenaOperacija());
	         assertEquals(formater.format(log2.getVremeIzvrsavanja()), formater.format(lista.get(2).getVremeIzvrsavanja()));
	         
	         
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
	
	
	

}
