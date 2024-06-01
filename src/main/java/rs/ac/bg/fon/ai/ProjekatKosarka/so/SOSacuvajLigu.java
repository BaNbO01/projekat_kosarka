package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.LigaRepository;

/**
 * Sistemska operacija za cuvanje lige nasledjuje ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOSacuvajLigu extends ApstraktnaSistemskaOperacija {

    /**
     * Repozitorijum za ligu
     */
    LigaRepository repository;

    /**
     * Konstruktor koji postavlja repozitorijum na vrednost prosledjenog
     * parametra
     *
     * @param repository Repozitorijum igraca tipa LigaRepository
     */
    @Autowired
    public SOSacuvajLigu(LigaRepository repository) {
        this.repository = repository;
    }

    /**
     * Validacija igraca pre samog cuvanja
     * Objekat mora biti tipa Liga
     * @param o Objekat nad kojim se vrsi validacija
     * @throws java.lang.IllegalArgumentException ukoliko objekat nije tipa Liga
     * 
     */
    @Override
    protected void validate(Object o) throws Exception {
        if (o instanceof Liga l) {
          
        } else {
            throw new IllegalArgumentException("Prosledjeni tip nije klase Liga");
        }

    }

    /**
     * Cuvanje lige u sistemu
     * @param o Objekat koji se cuva
     */
    @Override
    protected void izvrsavanjeOperacije(Object o) throws Exception {
        Liga liga = (Liga) o;
        repository.save(liga);

    }

}
