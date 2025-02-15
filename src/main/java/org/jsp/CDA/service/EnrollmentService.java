package org.jsp.CDA.service;

import org.springframework.http.ResponseEntity;

public interface EnrollmentService {

	ResponseEntity<?> saveEnrollment(int uid, int cid);

	ResponseEntity<?> findEnrollmentByUserId(int uid);

	ResponseEntity<?> findEnrollmentByFacultyId(int fid);

	ResponseEntity<?> findAllEnrollmentsOfStudent(int sid);

	ResponseEntity<?> findAllEnrollmentsOfCourse(int cid);

	ResponseEntity<?> findAllEnrollments();

	ResponseEntity<?> findEnrollmentById(int eid);

}
