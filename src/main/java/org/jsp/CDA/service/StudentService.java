package org.jsp.CDA.service;

import org.jsp.CDA.entities.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {

	ResponseEntity<?> findStudentbyId(int id);

	ResponseEntity<?> findAllStudent();

	ResponseEntity<?> delete(int id);

	ResponseEntity<?> updateStudent(Student student);

	ResponseEntity<?> findByName(String name);

	ResponseEntity<?> findByUsername(String username);

	ResponseEntity<?> assignDepartmentToStudent(int uid, int did);

}
