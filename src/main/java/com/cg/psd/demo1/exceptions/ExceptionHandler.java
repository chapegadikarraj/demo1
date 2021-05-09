package com.cg.psd.demo1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> exceptionHandle(){
		System.out.println("********** Inside Exception Handler **********");
		return new ResponseEntity<String>("Some Internal Problem Has Occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Its for validation on RequestBody @Valid
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> exceptionMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		return new ResponseEntity<String>(ex.getBindingResult().getFieldError().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<String> generalException(Exception ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
