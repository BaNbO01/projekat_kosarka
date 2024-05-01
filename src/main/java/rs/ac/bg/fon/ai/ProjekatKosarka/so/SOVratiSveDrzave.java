/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.so;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.ai.ProjekatKosarka.repo.DrzavaRepository;

/**
 *
 * @author Korisnik
 */


@Service	
public class SOVratiSveDrzave extends ApstraktnaSistemskaOperacija  {

	DrzavaRepository repository;
	
	@Autowired
	public SOVratiSveDrzave(DrzavaRepository drzavaRepo) {
		repository=drzavaRepo;
	}
	
	@Override
	protected void validate(Object o) throws Exception {
		
		
	}

	@Override
	protected void izvrsavanjeOperacije(Object o) throws Exception {
		result = repository.findAll();
		
		
	}

	
}

