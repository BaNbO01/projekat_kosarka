package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Liga;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.LigaRepository;

@Service	
public class SOSacuvajLigu extends ApstraktnaSistemskaOperacija {

	LigaRepository repository;
	
	@Autowired
	public SOSacuvajLigu(LigaRepository repository) {
		this.repository = repository;
	}
	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Liga l) {
			if(l.getDrzavaId()==null)
				throw new IllegalArgumentException("Liga mora imati drzavu iz koje dolazi");
			if(l.getNaziv().isBlank()) {
				throw new IllegalArgumentException("Liga mora imati neki naziv");
			}
		}
		else {
			throw new IllegalArgumentException("Prosledjeni tip nije klase Liga");
		}
		
	}

	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		Liga liga = (Liga)o;
		repository.save(liga);
		
		
	}

}
