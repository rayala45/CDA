package org.jsp.CDA.controller;

import org.jsp.CDA.dto.UserLogin;
import org.jsp.CDA.entities.User;
import org.jsp.CDA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLogin login){
		return service.login(login.getUsername(),login.getPassword());
	}
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllUser(){
		return service.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id){
		return service.findUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return service.delete(id);
	}
	
	

}
