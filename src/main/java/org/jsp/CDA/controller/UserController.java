package org.jsp.CDA.controller;

import org.jsp.CDA.dto.UserLogin;
import org.jsp.CDA.entities.User;
import org.jsp.CDA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	
	
	@Operation(summary = "login user",description = "Api To user login")
	@ApiResponses({@ApiResponse(responseCode = "200",description = "User login successfully.."),@ApiResponse(responseCode = "400",description = "Invalid user credentials ..")})
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLogin login){
		return service.login(login.getUsername(),login.getPassword());
	}
	
	@Operation(summary = "save user",description = "To save the user details")
	@ApiResponses({@ApiResponse(responseCode = "200",description = "User saved successfully.."),@ApiResponse(responseCode = "400",description = "Invalid user email id..")})
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	
	@Operation(summary = "to fetch all users",description = "API to fetch all users in the database..")
	@ApiResponses({@ApiResponse(responseCode = "200",description = "Users found successfully.."),@ApiResponse(responseCode = "400",description = "No User in the database..")})
	
	@GetMapping
	public ResponseEntity<?> findAllUser(){
		return service.findAllUsers();
	}
	
	@Operation(summary = "to fetch user by id",description = "API to fetch user by id..")
	@ApiResponses({@ApiResponse(responseCode = "200",description = "User found successfully.."),@ApiResponse(responseCode = "400",description = "Invalid user id..")})
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id){
		return service.findUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return service.delete(id);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findUserByName(@PathVariable String name){
		return service.findUserByName(name);
	}
	
	@GetMapping("/searchName/{name}")
	public ResponseEntity<?> searchUserByName(@PathVariable String name){
		return service.searchUserByName(name);
	}
	
	@GetMapping("/searchUsername/{username}")
	public ResponseEntity<?> searchUserByUsername(@PathVariable String username){
		return service.searchUserByUsername(username);
	}
	
//	@GetMapping("/simple")
//	@Scheduled(fixedDelay = 1000)
//	public void simple() {
//		System.out.println("hello good bye...");
//	}
	
	

}
