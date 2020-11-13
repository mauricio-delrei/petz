package com.br.petz.apirest.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.petz.apirest.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet,Long>{
	
	List<Pet>findByNomeContaining(String nome);

}
