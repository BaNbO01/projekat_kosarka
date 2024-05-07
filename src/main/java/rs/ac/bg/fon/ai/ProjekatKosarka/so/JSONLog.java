/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Log;

/**
 *
 * Klasa koja predstavlja sistemsku operaciju upisa podataka o izvrsenim sistemskim operacijama.
 * Cuva podatke u json formatu koristeci gson biblioteku Google-a
 * @author Boban Todic
 */
@Service
public class JSONLog {

    /**
     * Gson objekat za rad sa json-om
     */
    private Gson gson;

    /**
     * Objekat ciji se tip smesta u json fajl
     */
    private Log log;
    
    /**
     * Konstruktor koji postavlja vrednost gson objekta na vrednost prosledjenog parametra
     * @param gson 
     */
    public JSONLog(Gson gson) {
        this.gson = gson;
       
    }

    /**
     * Vraca objekat tipa Log
     * @return Log objekat
     */
    public Log getLog() {
        return log;
    }

    /**
     * Postavlja objekat Log na vrednost prosledjenog parametra
     * @param log objekat tipa Log
     */
    public void setLog(Log log) {
        this.log = log;
    }
    
    
/**
 * Metoda za upisivanje u json fajl
 * Prvo se pokusava citati iz fajla ako on postoji, na to se dodaje Log objekat koji je prosledjen
 * i smesta se u listu. Ta nova lista se pamti u json fajl
 * @throws Exception ukoliko dodje do problema prilikom serijalizacije objekta u json
 */
    public void izvrsi() throws Exception {
        List<Log> logovi = new ArrayList();
       try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/log.json"))){
           Type type = new TypeToken<List<Log>>() {}.getType();
           List<Log> lista = gson.fromJson(br, type);
           for (Log log1 : lista) {
               logovi.add(log1);
           }
       }catch(Exception e){
        
           
       }
       logovi.add(log);
        System.out.println("ok");
        try(PrintWriter pw = new PrintWriter(new File("src/main/resources/log.json"))){
            gson.toJson(logovi, pw);
            System.out.println("Uspesno upisano");
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        
        
    }
    
}
