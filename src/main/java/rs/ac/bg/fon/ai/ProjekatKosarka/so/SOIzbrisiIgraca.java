package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;

@Service
public class SOIzbrisiIgraca extends ApstraktnaSistemskaOperacija {

	IgraciRepository repository;
	
	@Autowired
	public SOIzbrisiIgraca(IgraciRepository igracRepo) {
		repository = igracRepo;		
	}
	
	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Igraci i) {
			if(i.getIgracID()==null)
				throw new IllegalArgumentException("Igrac mora imati neki id da bi se obrisao");
			
		}
		else
		{
			throw new IllegalArgumentException("Prosledjeni objekat nije tipa Igrac");
		}
	
}

	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		Igraci i = (Igraci)o;
		repository.deleteById(i.getIgracID());
	}
		
		
	}
