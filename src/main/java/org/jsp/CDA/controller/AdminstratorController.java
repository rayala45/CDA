package org.jsp.CDA.controller;

import org.jsp.CDA.service.AdminstratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminstratorController {
	
	@Autowired
	private AdminstratorService service;

}
