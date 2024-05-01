/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.LigaRepository;

/**
 *
 * @author Korisnik
 */
@Service
public class SOVratiSveLige extends ApstraktnaSistemskaOperacija {
    LigaRepository repository;
	
	@Autowired
	public SOVratiSveLige(LigaRepository igracRepo) {
		repository=igracRepo;
	}
	
	@Override
	protected void validate(Object o) throws Exception {
		
		
	}

	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		result = repository.findAll();
		
		
	}

}
