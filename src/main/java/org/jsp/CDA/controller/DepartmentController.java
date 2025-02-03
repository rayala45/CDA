package org.jsp.CDA.controller;

import org.jsp.CDA.entities.Department;
import org.jsp.CDA.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	
	@Autowired
	private DepartmentService service;
	
	@PostMapping
	public ResponseEntity<?> saveDept(@RequestBody Department department){
		return service.save(department);
	}
	
	@GetMapping
	public ResponseEntity<?> allDept(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<?> updateDept(@RequestBody Department department){
		return service.update(department);
	}
}
