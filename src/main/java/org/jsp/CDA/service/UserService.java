package org.jsp.CDA.service;

import org.jsp.CDA.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> login(String username, String password);

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<?> findUserById(int id);

	ResponseEntity<?> delete(int id);

}
