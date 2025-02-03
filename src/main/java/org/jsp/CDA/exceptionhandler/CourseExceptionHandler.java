package org.jsp.CDA.exceptionhandler;

import org.jsp.CDA.exceptionclasses.DuplicateCourseException;
import org.jsp.CDA.exceptionclasses.InvalidCourseIdException;
import org.jsp.CDA.exceptionclasses.NoCoursesFoundException;
import org.jsp.CDA.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseExceptionHandler {
	
	@ExceptionHandler(DuplicateCourseException.class)
	public ResponseEntity<?> duplicateCourseExceptionhandler(DuplicateCourseException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("course already exist...").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(InvalidCourseIdException.class)
	public ResponseEntity<?> invalidCourseIdExceptionhandler(InvalidCourseIdException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("invalid course id  ...").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(NoCoursesFoundException.class)
	public ResponseEntity<?> noCoursesFoundExceptionhandler(NoCoursesFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("no courses found in the database...").body(e.getMessage()).build());
	}

}
