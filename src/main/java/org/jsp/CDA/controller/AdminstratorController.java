package org.jsp.CDA.controller;

import org.jsp.CDA.entities.Adminstrator;
import org.jsp.CDA.service.AdminstratorService;
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
@RequestMapping("/admin")
public class AdminstratorController {
	
	@Autowired
	private AdminstratorService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findAdminstratorById(@PathVariable int id){
		return service.findAdminstratorbyId(id);
	}
	@GetMapping
	public ResponseEntity<?> findAllStudent(){
		return service.findAllAdminstrator();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return service.delete(id);
	}
	
	@PatchMapping("/updateAdmin")
	public ResponseEntity<?> updateAdmin(@RequestBody Adminstrator adminstrator){
		return service.updateAdmin(adminstrator);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<?> findByUsername(@PathVariable String username){
		return service.findByUsername(username);
	}
	
	@PatchMapping("/{aid}/{did}")
	public ResponseEntity<?> assignDepartmentToAdmin(@PathVariable int aid,@PathVariable int did){
		return service.assignDepartmentToAdmin(aid,did);
	}

}
