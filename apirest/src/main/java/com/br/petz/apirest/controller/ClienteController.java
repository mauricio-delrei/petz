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

import com.br.petz.apirest.dto.ClienteDTO;
import com.br.petz.apirest.exception.ResourceNotFoundException;
import com.br.petz.apirest.model.Cliente;
import com.br.petz.apirest.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping(path="/")
	@ResponseStatus(HttpStatus.OK)	
	public List<ClienteDTO>findAll(String nome){
		if(nome==null) {
		List<Cliente>clientes = clienteService.findAll();
		return ClienteDTO.converter(clientes);
		}else {
			List<Cliente>clientes = clienteService.findByName(nome);
			return ClienteDTO.converter(clientes);
		}	
		
	}		
	

	@GetMapping(path = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable("id") Long id) {
		Optional<Cliente> cliente = clienteService.findById(id);		
		return new ResponseEntity<ClienteDTO>(new ClienteDTO(cliente.get()),HttpStatus.OK);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@Valid @RequestBody Cliente clienteModel) {
		return clienteService.save(clienteModel);
	}

	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente clienteModel) {
		
		clienteService.save(clienteModel);
		return new ResponseEntity<>(HttpStatus.OK);
		

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {		
		clienteService.delete(id);
	}

}
