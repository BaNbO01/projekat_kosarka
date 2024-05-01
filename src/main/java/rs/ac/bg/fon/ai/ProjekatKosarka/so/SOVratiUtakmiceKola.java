package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Utakmica;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.UtakmicaRepository;

/**
 * Sistemska operacija za vracanje svih utakmica odredjenog kola nasledjuje ApstraktnuSistemskuOperaciju
 *
 * @author Boban Todic
 */
@Service
public class SOVratiUtakmiceKola extends ApstraktnaSistemskaOperacija {

      /**
     * Repozitorijum za utakmicu
     */
	UtakmicaRepository repository;
	
         /**
     * Konstruktor koji postavlja repozitorijum na vrednost prosledjenog
     * parametra
     *
     * @param repository Repozitorijum igraca tipa UtakmicaRepository
     */
	public SOVratiUtakmiceKola(UtakmicaRepository repository) {
		this.repository = repository;
	}

        /**
         * Validacija pre samog vracanja liga
         * Objekat mora biti tipa Utakmica i njegovo kolo ne sme biti null
         * @param  o Objekat nad kojim se vrsi validacija
         * @throws java.lang.IllegalArgumentException ukoliko objekat nije tipa Utakmica ili ako je njegovo kolo null
         */
	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Utakmica u) {
			if(u.getKolo()==null ) {
				throw new IllegalArgumentException("Prosledjeni objekat utakmica nije validan");
			}
		}
		else {
			throw new IllegalArgumentException("Prosledjeni objekat nije klase Utakmica");
		}
		
	}

         /**
         * Vracanje liste svih utakmica odredjene lige
         * @param o Objekat tipa cija se lista vraca
         * 
         */
	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		Utakmica u = (Utakmica)o;
		result = repository.findAllMatchesInFixture(u.getKolo().getKoloPK().getKoloId(), u.getKolo().getKoloPK().getLigaId());
		
	}
}
