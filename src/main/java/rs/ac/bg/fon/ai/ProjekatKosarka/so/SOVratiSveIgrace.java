package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;

@Service	
public class SOVratiSveIgrace extends ApstraktnaSistemskaOperacija  {

	IgraciRepository repository;
	
	@Autowired
	public SOVratiSveIgrace(IgraciRepository igracRepo) {
		repository=igracRepo;
	}
	
	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Igraci i) {
			
		}
		else
		{
			throw new IllegalArgumentException("Prosledjeni objekat nije tipa Igrac");
		}
		
	}

	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		result = repository.findAll();
		
		
	}

	
}
