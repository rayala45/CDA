package org.jsp.CDA.serviceImpl;

import org.jsp.CDA.Dao.StudentDao;
import org.jsp.CDA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao dao;

}
