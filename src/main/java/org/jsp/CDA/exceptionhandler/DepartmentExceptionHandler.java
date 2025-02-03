package org.jsp.CDA.exceptionhandler;

import org.jsp.CDA.exceptionclasses.InvalidDepartmentIdException;
import org.jsp.CDA.exceptionclasses.InvalidDepartmentNameException;
import org.jsp.CDA.exceptionclasses.NoDepartmentFoundException;
import org.jsp.CDA.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DepartmentExceptionHandler {
	
	@ExceptionHandler(NoDepartmentFoundException.class)
	public ResponseEntity<?> noDepartmentFoundExceptionhandler(NoDepartmentFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No depart found in the database...").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(InvalidDepartmentIdException.class)
	public ResponseEntity<?> invalidDepartmentIdExceptionhandler(InvalidDepartmentIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No depart found in the database with given id...").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(InvalidDepartmentNameException.class)
	public ResponseEntity<?> invalidDepartmentNameExceptionhandler(InvalidDepartmentNameException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No depart found in the database with given name...").body(e.getMessage()).build());
	}


}
