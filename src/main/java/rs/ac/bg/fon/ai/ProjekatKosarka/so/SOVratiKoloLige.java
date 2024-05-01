package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.KoloRepository;

@Service
public class SOVratiKoloLige extends ApstraktnaSistemskaOperacija{
	
	
	KoloRepository repository;
	
	public SOVratiKoloLige(KoloRepository repository) {
		this.repository = repository;
	}

	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Kolo k) {
			if(k.getLiga()==null)
				throw new IllegalArgumentException("Kolo se mora pretraziti preko lige, a ona je null");
		}
		else {
			throw new IllegalArgumentException("Prosledjeni objekat nije klase Kolo");
		}
		
	}

	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		Kolo k = (Kolo)o;
		result = repository.findAllFeaturesByLeage(k.getLiga().getLigaId());
		
	}
	
}
