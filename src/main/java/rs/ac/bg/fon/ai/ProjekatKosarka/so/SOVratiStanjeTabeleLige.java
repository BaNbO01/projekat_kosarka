/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.TabelaRepository;

/**
 * Sistemska operacija za vracanje stanja tabele nasledjuje ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOVratiStanjeTabeleLige extends ApstraktnaSistemskaOperacija {
    /**
     * Repozitorijum za tabela
     */
    TabelaRepository repository;
	
      /**
     * Konstruktor koji postavlja repozitorijum na vrednost prosledjenog
     * parametra
     *
     * @param igracRepo Repozitorijum igraca tipa TabelaRepository
     */
	@Autowired
	public SOVratiStanjeTabeleLige(TabelaRepository igracRepo) {
		repository=igracRepo;
	}
	
        /**
         * Validacija pre samog vracanja tabela
         * Objekat mora biti tipa Tabela
         * 
         * @param o Objekat nad kojim se vrsi validacija
         * @throws java.lang.IllegalArgumentException ukoliko objekat nije tipa Tabela
         */
	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Tabela t) {
			
		}
		else
		{
			throw new IllegalArgumentException("Prosledjeni objekat nije tipa Tabela");
		}
		
	}

        /**
         * Vraca lista tipa tabela iz baze odredjene lige
         * @param o Objekat nad kojim se vrsi sistemska operacija
         * 
         */
	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
            Tabela tabela = (Tabela)o;
		result = repository.returnLeagueStanding(tabela.getLiga().getLigaId());
		
		
	}

    
}
