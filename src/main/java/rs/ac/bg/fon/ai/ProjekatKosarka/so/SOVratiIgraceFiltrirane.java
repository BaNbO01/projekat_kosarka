package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;

/**
 * Sistemska operacija za vracanje filtriranih igraca nasledjuje ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOVratiIgraceFiltrirane extends ApstraktnaSistemskaOperacija {

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
    public SOVratiIgraceFiltrirane(IgraciRepository igracRepo) {
        repository = igracRepo;
    }

    /**
     * Validacija pre samog vracanja igraca
     * Objekat mora biti tipa Igraci
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
     * Vracanje igraca po prosledjenim kriterijumima
     * Rezultat se pamti u promenljivu result
     * @param o Objekat za ciji tip se Filtrira
     * 
     */
    @Override
    protected void izvrsavanjeOperacije(Object o) throws Exception {
        Igraci i = (Igraci) o;
        result = repository.findAllByCriteria(i.getIme(), i.getPrezime(), i.getVisina(), i.getPozicija(), i.getBroj());

    }

}
