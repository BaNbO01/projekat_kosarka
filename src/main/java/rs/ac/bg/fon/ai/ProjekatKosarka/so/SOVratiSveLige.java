/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.LigaRepository;

/**
 * Sistemska operacija za vracanje svih liga nasledjuje ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOVratiSveLige extends ApstraktnaSistemskaOperacija {
    /**
     * Repozitorijum za ligu
     */
    LigaRepository repository;
	
    
     /**
     * Konstruktor koji postavlja repozitorijum na vrednost prosledjenog
     * parametra
     *
     * @param igracRepo Repozitorijum igraca tipa LigaRepository
     */
	@Autowired
	public SOVratiSveLige(LigaRepository igracRepo) {
		repository=igracRepo;
	}
	/**
         * Validacija pre samog vracanja liga
         * @param  o Objekat nad kojim se vrsi validacija
         */
	@Override
	protected void validate(Object o) throws Exception {
		
		
	}

        /**
         * Vracanje liste svih liga
         * @param o Objekat tipa cija se lista vraca
         * 
         */
	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		result = repository.findAll();
		
		
	}

}
