package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Utakmica;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.UtakmicaRepository;

@Service
public class SOVratiUtakmiceKola extends ApstraktnaSistemskaOperacija {

	UtakmicaRepository repository;
	
	public SOVratiUtakmiceKola(UtakmicaRepository repository) {
		this.repository = repository;
	}

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

	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		Utakmica u = (Utakmica)o;
		result = repository.findAllMatchesInFixture(u.getKolo().getKoloPK().getKoloId(), u.getKolo().getKoloPK().getLigaId());
		
	}
}
