package org.jsp.CDA.controller;

import org.jsp.CDA.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {
	
	@Autowired
	private EnrollmentService service;

}
