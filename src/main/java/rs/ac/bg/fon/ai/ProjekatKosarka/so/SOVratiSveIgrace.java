package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;

/**
 * Sistemska operacija za vracanje igraca nasledjuje ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOVratiSveIgrace extends ApstraktnaSistemskaOperacija {

    /**
     * Repozitorijum za igrace
     */
    IgraciRepository repository;

    /**
     * Konstruktor koji postavlja repozitorijum na vrednost prosledjenog
     * parametra
     *
     * @param igracRepo Repozitorijum igraca tipa IgraciRepository
     */
    @Autowired
    public SOVratiSveIgrace(IgraciRepository igracRepo) {
        repository = igracRepo;
    }

    /**
     * Validacija pre samog vracanja igraca
     * Objekat mora da bude tipa Igraci
     * @param o Objekat nad kojim se vrsi validacija
     * @throws java.lang.IllegalArgumentException ukoliko prosledjeni objekat nije tipa Igraci 
     */
    @Override
    protected void validate(Object o) throws Exception {
        if (o instanceof Igraci i) {

        } else {
            throw new IllegalArgumentException("Prosledjeni objekat nije tipa Igrac");
        }

    }

    /**
     * Vracanje svih igraca iz baze
     * @param o Objekat cija se lista vraca
     * 
     */
    @Override
    protected void izvrsavanjeOperacije(Object o) throws Exception {
        result = repository.findAll();

    }

}
