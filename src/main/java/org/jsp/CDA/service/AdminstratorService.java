package org.jsp.CDA.service;

import org.jsp.CDA.entities.Adminstrator;
import org.springframework.http.ResponseEntity;

public interface AdminstratorService {

	ResponseEntity<?> findAdminstratorbyId(int id);

	ResponseEntity<?> findAllAdminstrator();

	ResponseEntity<?> delete(int id);

	ResponseEntity<?> updateAdmin(Adminstrator adminstrator);

	ResponseEntity<?> findByName(String name);

	ResponseEntity<?> findByUsername(String username);

	ResponseEntity<?> assignDepartmentToAdmin(int aid, int did);

}
