package org.jsp.CDA.controller;

import org.jsp.CDA.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	private FacultyService service;
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findfacultyById(@PathVariable int id){
		return service.findfacultybyId(id);
	}
	@GetMapping
	public ResponseEntity<?> findAllFaculties(){
		return service.findAllFaculties();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return service.delete(id);
	}

}
