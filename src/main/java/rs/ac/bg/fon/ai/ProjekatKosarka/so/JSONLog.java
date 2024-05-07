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
 * @author Korisnik
 */
@Service
public class JSONLog {

    private Gson gson;

    private Log log;
    
    public JSONLog(Gson gson) {
        this.gson = gson;
       
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }
    
    

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
