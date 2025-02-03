package org.jsp.CDA.service;

import org.jsp.CDA.entities.Department;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {

	ResponseEntity<?> save(Department department);

	ResponseEntity<?> findAll();

	ResponseEntity<?> findById(int id);

	ResponseEntity<?> findByName(String name);

	ResponseEntity<?> deleteById(int id);

	ResponseEntity<?> update(Department department);

}
