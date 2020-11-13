package com.br.petz.apirest.exception;

public class ResourceNotFoundException extends RuntimeException{	
	

	//@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResourceNotFoundException(String mensagem) {
		super(mensagem);
	}
}
