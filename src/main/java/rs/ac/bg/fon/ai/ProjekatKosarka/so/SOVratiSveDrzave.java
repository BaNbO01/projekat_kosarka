/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.DrzavaRepository;

/**
 * Sistemska operacija za vracanje drzava nasledjuje ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOVratiSveDrzave extends ApstraktnaSistemskaOperacija {

    /**
     * Repozitorijum za drzavu
     */
    DrzavaRepository repository;

    /**
     * Konstruktor koji postavlja repozitorijum na vrednost prosledjenog
     * parametra
     *
     * @param drzavaRepo Repozitorijum igraca tipa DrzavaRepository
     */
    @Autowired
    public SOVratiSveDrzave(DrzavaRepository drzavaRepo) {
        repository = drzavaRepo;
    }

    /**
     * Validacija pre samog vracanja drzava
     * 
     * @param o  Objekat nad kojim se vrsi validacija
     * 
     */
    @Override
    protected void validate(Object o) throws Exception {

    }

    /**
     * Vracanje liste svih drzava
     * @param o Objekat tipa Object
     * 
     */
    @Override
    protected void izvrsavanjeOperacije(Object o) throws Exception {
        result = repository.findAll();

    }

}
