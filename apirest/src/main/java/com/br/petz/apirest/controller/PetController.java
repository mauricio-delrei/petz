package com.br.petz.apirest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.petz.apirest.dto.PetDTO;
import com.br.petz.apirest.model.Pet;
import com.br.petz.apirest.service.PetService;

@RestController
@RequestMapping(value = "/pets")
public class PetController {

	private final PetService petService;

	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}

	@GetMapping(path="/")
	@ResponseStatus(HttpStatus.OK)
	public List<PetDTO>findAll(String nome){
		if(nome==null) {
		List<Pet>pets = petService.findAll();
		return PetDTO.converter(pets);
		}else {
			List<Pet>pets = petService.findByName(nome);
			return PetDTO.converter(pets);
		}	
		
	}		

	@GetMapping(path = "/{id}")
	public ResponseEntity<PetDTO> findById(@PathVariable("id") Long id) {
		Optional<Pet> pet = petService.findById(id);
		return new ResponseEntity<PetDTO>(new PetDTO(pet.get()),HttpStatus.OK);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pet save(@Valid @RequestBody Pet petModel) {
		return petService.save(petModel);
	}

	@PutMapping
	public ResponseEntity<Pet> update(@RequestBody Pet petModel) {
		
		petService.save(petModel);
		return new ResponseEntity<>(HttpStatus.OK);
		

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		petService.delete(id);
	}

}
