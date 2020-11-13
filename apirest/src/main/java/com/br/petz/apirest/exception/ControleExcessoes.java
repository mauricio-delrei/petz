package com.br.petz.apirest.exception;

import java.sql.SQLException;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ControllerAdvice
public class ControleExcessoes extends ResponseEntityExceptionHandler{


	@ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class})
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String mensagem = "";
		if(ex instanceof MethodArgumentNotValidException) {
			List<ObjectError>list = ((MethodArgumentNotValidException)ex).getBindingResult().getAllErrors();
		    for (ObjectError objectError : list) {
		    	mensagem += objectError.getDefaultMessage() + "\n";
				
			}
		}else {
			mensagem = ex.getMessage();
		}
		
		ObjetoErro objetoErro = new ObjetoErro();
		objetoErro.setErro(mensagem);
		objetoErro.setCodigo(status.value() + "==>" + status.getReasonPhrase());
		
		return new ResponseEntity<>(objetoErro, headers, status);
	}
	
	@ExceptionHandler({DataIntegrityViolationException.class, ConstraintViolationException.class,
		             SQLException.class})
	protected ResponseEntity<Object>handleExceptionDataIntegry(Exception ex){
		
		String mensagem = "";
		
		if(ex instanceof DataIntegrityViolationException) {
			mensagem = ((DataIntegrityViolationException)ex).getCause().getCause().getMessage();
		}else if(ex instanceof ConstraintViolationException){
			mensagem = ((ConstraintViolationException)ex).getCause().getCause().getMessage();			
		}else if(ex instanceof SQLException){
				mensagem = ((SQLException)ex).getCause().getCause().getMessage();				
		}else{
			mensagem = ex.getMessage();
		}
		
		ObjetoErro objetoErro = new ObjetoErro();
		objetoErro.setErro(mensagem);
		objetoErro.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR + "==>" + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		
		return new ResponseEntity<>(objetoErro, HttpStatus.INTERNAL_SERVER_ERROR);
		
		

	}
}
