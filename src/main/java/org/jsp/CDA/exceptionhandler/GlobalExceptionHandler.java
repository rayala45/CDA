package org.jsp.CDA.exceptionhandler;

import org.jsp.CDA.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> runtimeExceptionhandler(RuntimeException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("Something went wrong.....").body(e.getMessage()).build());
	}

}
