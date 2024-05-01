/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Drzava;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Utakmica;

/**
 *
 * @author Korisnik
 */

@Configuration
public class AppConfig {
    
    @Bean
    public List<Utakmica> listaUtakmica(){
        return new ArrayList<>();
    }

    @Bean
    public List<Liga> listaLiga(){
        return new ArrayList<>();
    }
    
    
    @Bean
    public List<Igraci> igraciLista(){
        return new ArrayList<>();
    }
    
    
    @Bean
    public List<Drzava> listaDrzava(){
        return new ArrayList<>();
    }
    @Bean
    public Boolean modal(){
        return true;
    }
    
  
    
    @Bean
    public List<Tabela> listaTabela(){
        return new ArrayList<>();
    }
    
}
