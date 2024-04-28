package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;


@Service
public class SOVratiIgraceFiltrirane extends ApstraktnaSistemskaOperacija{

	IgraciRepository repository;

	@Autowired
	public SOVratiIgraceFiltrirane(IgraciRepository igracRepo) {
		repository = igracRepo;		
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
		Igraci i = (Igraci)o;
		result = repository.findAllByCriteria(i.getIme(),i.getPrezime(),i.getVisina(),i.getPozicija(),i.getBroj());
		          
		
		
		
	}

	
	
}
