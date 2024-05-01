/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.domain.Tabela;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.TabelaRepository;


@Service
public class SOVratiStanjeTabeleLige extends ApstraktnaSistemskaOperacija {
    
    TabelaRepository repository;
	
	@Autowired
	public SOVratiStanjeTabeleLige(TabelaRepository igracRepo) {
		repository=igracRepo;
	}
	
	@Override
	protected void validate(Object o) throws Exception {
		if(o instanceof Tabela t) {
			if(t.getLiga()==null || t.getLiga().getLigaId()==null)
                         throw new IllegalArgumentException("Prosledjeni objekat nije validan");   
		}
		else
		{
			throw new IllegalArgumentException("Prosledjeni objekat nije tipa Tabela");
		}
		
	}

	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
            Tabela tabela = (Tabela)o;
		result = repository.returnLeagueStanding(tabela.getLiga().getLigaId());
		
		
	}

    
}
