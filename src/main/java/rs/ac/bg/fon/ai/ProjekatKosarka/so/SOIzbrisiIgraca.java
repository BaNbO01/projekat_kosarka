package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;


/**
 * Sistemska operacija za brisanje igraca nasledjuje ApstraktnuSistemskuOperaciju
 * @author Boban Todic
 */
@Service
public class SOIzbrisiIgraca extends ApstraktnaSistemskaOperacija {

    /**
     * Repozitorijum za igrace
     */
	IgraciRepository repository;
	
        /**
         * Konstruktor koji postavlja repozitorijum na vrednost prosledjenog parametra
         * @param igracRepo Repozitorijum igraca tipa IgraciRepository
         */
	@Autowired
	public SOIzbrisiIgraca(IgraciRepository igracRepo) {
		repository = igracRepo;		
	}
	
        /**
         * Validacija igraca pre samog brisanja
         * Prosledjeni objekat mora biti tipa Igraci
         * @param o Objekat nad kojim se vrsi validacija
         * @throws java.lang.IllegalArgumentException ukoliko objekat nije tipa Igraci
         */
	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Igraci i) {
		}
		else
		{
			throw new IllegalArgumentException("Prosledjeni objekat nije tipa Igrac");
		}
	
}

        /**
         * Brisanje igraca iz sistema
         * @param o Objekat koji se brise
         *
         */
	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		Igraci i = (Igraci)o;
		repository.deleteById(i.getIgracID());
	}
		
		
	}
