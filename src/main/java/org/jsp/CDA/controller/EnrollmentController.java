package org.jsp.CDA.controller;

import org.jsp.CDA.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
	
	@Autowired
	private EnrollmentService service;
	
	@PostMapping("/{uid}/{cid}")
	public ResponseEntity<?> saveEnrollment(@PathVariable int uid,@PathVariable int cid){
		return service.saveEnrollment(uid,cid);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllEnrollments(){
		return service.findAllEnrollments();
	}
	
	@GetMapping("/{eid}")
	public ResponseEntity<?> findEnrollmentById(@PathVariable int eid){
		return service.findEnrollmentById(eid);
	}
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<?> findEnrollmentByUserId(@PathVariable int uid){
		return service.findEnrollmentByUserId(uid);
	}
	
	@GetMapping("/faculty/{fid}")
	public ResponseEntity<?> findEnrollmentByFacultyId(@PathVariable int fid){
		return service.findEnrollmentByFacultyId(fid);
	}
	
	@GetMapping("/studentEnrolls/{sid}")
	public ResponseEntity<?> findAllEnrollmentsOfStudent(@PathVariable int sid){
		return service.findAllEnrollmentsOfStudent(sid);
	}
	
	@GetMapping("/courseEnrolls/{cid}")
	public ResponseEntity<?> findAllEnrollmentsOfCourse(@PathVariable int cid){
		return service.findAllEnrollmentsOfCourse(cid);
	}

}
