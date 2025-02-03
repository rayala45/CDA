package org.jsp.CDA.serviceImpl;

import org.jsp.CDA.Dao.EnrollmentDao;
import org.jsp.CDA.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceimpl implements EnrollmentService{
	@Autowired
	private EnrollmentDao dao;

}
