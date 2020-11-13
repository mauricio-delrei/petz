package com.br.petz.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.petz.apirest.exception.ResourceNotFoundException;
import com.br.petz.apirest.model.Pet;
import com.br.petz.apirest.repository.PetRepository;

@Service
public class PetService {
	
	private final PetRepository petRepository;

	@Autowired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	
	public List<Pet>findAll(){
		return (List<Pet>) petRepository.findAll();
	}
	
	public List<Pet>findByName(String nome){
		return petRepository.findByNomeContaining(nome);
	}
	
	
	public Optional<Pet> findById(Long id) {
		if(!petRepository.existsById(id)) {
			throw new ResourceNotFoundException("Cliente Não Encontrado");
		}
		return petRepository.findById(id);
	}
	
	
	public Pet save(Pet petModel) {
		return petRepository.save(petModel);
	}
	
	public void delete(Long id) {
		
		if(!petRepository.existsById(id)) {
			throw new ResourceNotFoundException("Cliente Não Encontrado");
		}
		
		petRepository.deleteById(id);
	}
	
	public Pet update(Pet petModel) {
		
		return petRepository.save(petModel);
		
	}
	
	
	

}
