package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Igraci;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.IgraciRepository;

@Service
public class SOSacuvajIgraca extends ApstraktnaSistemskaOperacija {
	
	IgraciRepository repository;
	@Autowired
	public SOSacuvajIgraca(IgraciRepository igracRepo) {
		repository = igracRepo;	
	}
	
	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Igraci i) {
			if(i.getDrzavaId()==null)
				throw new IllegalArgumentException("Igrac mora dolaziti iz neke zemlje");
			if(i.getIme().isBlank() || i.getIme().length()<2)
				throw new IllegalArgumentException("Ime mora biti popunjeno i sadrzati bar 2 karaktera");
			if(i.getPrezime().isBlank() || i.getPrezime().length()<2)
				throw new IllegalArgumentException("Ime mora biti popunjeno i sadrzati bar 2 karaktera");
			
		}
		else
		{
			throw new IllegalArgumentException("Prosledjeni objekat nije tipa Igrac");
		}
		
	}

	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		Igraci i = (Igraci)o;
		repository.save(i);
		
		
	}

}
