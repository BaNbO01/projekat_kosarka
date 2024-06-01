package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.KoloRepository;

/**
 * Sistemska operacija za vracanje kola konkretne lige nasledjuje
 * ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOVratiKoloLige extends ApstraktnaSistemskaOperacija {

    /**
     * Repozitorijum za kolo
     */
    KoloRepository repository;

    /**
     * Konstruktor koji postavlja repozitorijum na vrednost prosledjenog
     * parametra
     *
     * @param repository Repozitorijum igraca tipa KoloRepository
     */
    public SOVratiKoloLige(KoloRepository repository) {
        this.repository = repository;
    }

    /**
     * Validacija igraca pre samog cuvanja
     * Prosledjeni objekat mora biti tipa Kolo
     * @param o Objekat nad kojim se vrsi validacija
     * @throws java.lang.IllegalArgumentException ukoliko prosledjeni objekat nije tipa Kolo
     */
    @Override
    protected void validate(Object o) throws Exception {
        if (o instanceof Kolo k) {
           
        } else {
            throw new IllegalArgumentException("Prosledjeni objekat nije klase Kolo");
        }

    }

    /**
     * Vraca sva kola odredjene lige
     * @param o Objekat tipa cija se lista vraca
     * 
     */
    @Override
    protected void izvrsavanjeOperacije(Object o) throws Exception {
        Kolo k = (Kolo) o;
        result = repository.findAllFeaturesByLeage(k.getLiga().getLigaId());

    }

}
