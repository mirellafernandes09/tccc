package package com.example.gestaosla.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.itb.projeto.pizzaria3d.rest.exception.ResourceNotFoundException;

@ControllerAdvice
public class CustomAdvicehandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handlerResourceNotFoundException(ResourceNotFoundException e){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		
	}
	

}