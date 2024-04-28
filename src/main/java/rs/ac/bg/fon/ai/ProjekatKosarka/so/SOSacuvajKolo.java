package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Kolo;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.KoloRepository;
@Service
public class SOSacuvajKolo extends ApstraktnaSistemskaOperacija {
	KoloRepository repository;
	@Autowired
	public SOSacuvajKolo(KoloRepository igracRepo) {
		repository = igracRepo;	
	}
	
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

	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		Kolo k = (Kolo)o;
		repository.save(k);
		
		
	}
}
