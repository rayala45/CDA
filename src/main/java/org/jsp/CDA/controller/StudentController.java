package org.jsp.CDA.controller;

import org.jsp.CDA.entities.Student;
import org.jsp.CDA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable int id){
		return service.findStudentbyId(id);
	}
	@GetMapping
	public ResponseEntity<?> findAllStudent(){
		return service.findAllStudent();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return service.delete(id);
	}
	
	@PatchMapping("/updateStudent")
	public ResponseEntity<?> updateSTudent(@RequestBody Student student){
		return service.updateStudent(student);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<?> findByUsername(@PathVariable String username){
		return service.findByUsername(username);
	}
	
	@PatchMapping("/{uid}/{did}")
	public ResponseEntity<?> assignDepartmentToStudent(@PathVariable int uid,@PathVariable int did){
		return service.assignDepartmentToStudent(uid,did);
	}
	
	

}
