package org.jsp.CDA.service;

import org.springframework.http.ResponseEntity;

public interface FacultyService {

	ResponseEntity<?> findfacultybyId(int id);

	ResponseEntity<?> findAllFaculties();

	ResponseEntity<?> delete(int id);

}
