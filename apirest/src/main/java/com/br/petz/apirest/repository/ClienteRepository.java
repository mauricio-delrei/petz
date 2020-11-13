package com.br.petz.apirest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.petz.apirest.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long>{
	
	List<Cliente>findByNomeIgnoreCaseContaining(String nome);

}
