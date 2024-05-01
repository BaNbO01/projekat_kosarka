/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.TimRepository;

/**
 * Sistemska operacija za vracanje svih timova nasledjuje
 * ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */

@Service
public class SOVratiSveTimove extends ApstraktnaSistemskaOperacija {

    /**
     * Repozitorijum za tim
     */
    TimRepository repository;

     /**
     * Konstruktor koji postavlja repozitorijum na vrednost prosledjenog
     * parametra
     *
     * @param igracRepo Repozitorijum igraca tipa TimRepository
     */
    @Autowired
    public SOVratiSveTimove(TimRepository igracRepo) {
        repository = igracRepo;
    }

    /**
         * Validacija pre samog vracanja liga
         * @param  o Objekat nad kojim se vrsi validacija
         */
    @Override
    protected void validate(Object o) throws Exception {

    }
 /**
         * Vracanje liste svih timova
         * @param o Objekat tipa cija se lista vraca
         * 
         */
    @Override
    protected void izvrsavanjeOperacije(Object o) throws Exception {
        result = repository.findAll();

    }

}
