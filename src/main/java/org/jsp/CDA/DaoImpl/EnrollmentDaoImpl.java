package org.jsp.CDA.DaoImpl;

import org.jsp.CDA.Dao.EnrollmentDao;
import org.jsp.CDA.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnrollmentDaoImpl implements EnrollmentDao{

	@Autowired
	private EnrollmentRepository repo;
}
