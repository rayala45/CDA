package org.jsp.CDA.service;

import org.jsp.CDA.entities.Faculty;
import org.springframework.http.ResponseEntity;

public interface FacultyService {

	ResponseEntity<?> findfacultybyId(int id);

	ResponseEntity<?> findAllFaculties();

	ResponseEntity<?> delete(int id);

	ResponseEntity<?> updateFaculty(Faculty faculty);

	ResponseEntity<?> findByName(String name);

	ResponseEntity<?> findByUsername(String username);

	ResponseEntity<?> assignDepartmentToFaculty(int fid, int did);

}
