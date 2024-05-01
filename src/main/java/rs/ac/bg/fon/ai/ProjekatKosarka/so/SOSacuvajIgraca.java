package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;

/**
 * Sistemska operacija za cuvanje igraca nasledjuje ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOSacuvajIgraca extends ApstraktnaSistemskaOperacija {

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
    public SOSacuvajIgraca(IgraciRepository igracRepo) {
        repository = igracRepo;
    }

    
    /**
     * Validacija igraca pre samog brisanja
     * Prosledjeni objekat ne sme biti null, ime i prezime ne smeju da imaju manje od 2 karaktera
     * 
     * @param o Objekat nad kojim se vrsi validacija
     * @throws java.lang.IllegalArgumentException ukoliko prosledjeni objekat
     * nije tipa Igraci, ako je drzava null, ako je njegovo ime ili prezime manje od karaktera
     */
    @Override
    protected void validate(Object o) throws Exception {
        if (o instanceof Igraci i) {
            if (i.getDrzavaId() == null) {
                throw new IllegalArgumentException("Igrac mora dolaziti iz neke zemlje");
            }
            if (i.getIme().isBlank() || i.getIme().length() < 2) {
                throw new IllegalArgumentException("Ime mora biti popunjeno i sadrzati bar 2 karaktera");
            }
            if (i.getPrezime().isBlank() || i.getPrezime().length() < 2) {
                throw new IllegalArgumentException("Ime mora biti popunjeno i sadrzati bar 2 karaktera");
            }

        } else {
            throw new IllegalArgumentException("Prosledjeni objekat nije tipa Igrac");
        }

    }

    /**
     * Cuvanje igraca u sistem
     * @param o Objekat koji se cuva
     * 
     */
    @Override
    protected void izvrsavanjeOperacije(Object o) throws Exception {
        Igraci i = (Igraci) o;
        repository.save(i);

    }

}
