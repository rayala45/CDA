package org.jsp.CDA.serviceImpl;

import org.jsp.CDA.Dao.AdminstratorDao;
import org.jsp.CDA.service.AdminstratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminstratorServiceImpl implements AdminstratorService {
	@Autowired
	private AdminstratorDao dao;

}
