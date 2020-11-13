package com.br.petz.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.petz.apirest.exception.ResourceNotFoundException;
import com.br.petz.apirest.model.Cliente;
import com.br.petz.apirest.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
	public List<Cliente>findAll(){
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	
	public Optional<Cliente> findById(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw new ResourceNotFoundException("Cliente Não Encontrado");
		}
		return clienteRepository.findById(id);
	}
	
	public List<Cliente>findByName(String nome){
		return clienteRepository.findByNomeIgnoreCaseContaining	(nome);
	}
	
	
	public Cliente save(Cliente clienteModel) {
		return clienteRepository.save(clienteModel);
	}
	
	public void delete(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw new ResourceNotFoundException("Cliente Não Encontrado");
		}
		clienteRepository.deleteById(id);
	}
	
	public Cliente update(Cliente clienteModel) {
		
		return clienteRepository.save(clienteModel);
		
	}
	
	
	

}
