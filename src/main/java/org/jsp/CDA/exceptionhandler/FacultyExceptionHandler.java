package org.jsp.CDA.exceptionhandler;

import org.jsp.CDA.exceptionclasses.InvalidFacultyIdException;
import org.jsp.CDA.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FacultyExceptionHandler {
	
	@ExceptionHandler(InvalidFacultyIdException.class)
	public ResponseEntity<?> invalidFacultyIdExceptionhandler(InvalidFacultyIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No faculty found in the database with given id...").body(e.getMessage()).build());
	}

}
