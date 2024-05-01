/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.TimRepository;

/**
 *
 * @author Korisnik
 */


@Service	
public class SOVratiSveTimove extends ApstraktnaSistemskaOperacija  {

	   TimRepository repository;
	
	@Autowired
	public SOVratiSveTimove(TimRepository igracRepo) {
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
