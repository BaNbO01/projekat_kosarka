package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.KoloRepository;


/**
 * Sistemska operacija za cuvanje kola nasledjuje ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOSacuvajKolo extends ApstraktnaSistemskaOperacija {
    
    /**
     * Repozitorijum za kolo
     */
	KoloRepository repository;
        
            /**
     * Konstruktor koji postavlja repozitorijum na vrednost prosledjenog
     * parametra
     *
     * @param igracRepo Repozitorijum igraca tipa KoloRepository
     */
	@Autowired
	public SOSacuvajKolo(KoloRepository igracRepo) {
		repository = igracRepo;	
	}
	
        /**
         *  Validacija igraca pre samog cuvanja
         * Za prosledjeni objekat, liga ne sme biti null
         * @param o Objekat nad kojim se vrsi validacija
         * @throws java.lang.IllegalArgumentException ukoliko je liga null ili ako objekat nije tipa Kolo
         */
	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Kolo k) {
			if(k.getLiga()==null)
				throw new IllegalArgumentException("Prosledjeno kolo mora da pripada nekoj ligi");
			
		}
		else
		{
			throw new IllegalArgumentException("Prosledjeni objekat nije tipa Kolo");
		}
		
	}

        
        /**
         * Cuvanje kola u sistemu
         * @param o Objekat koji se cuva
         * 
         */
	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		Kolo k = (Kolo)o;
		repository.save(k);
		
		
	}
}
