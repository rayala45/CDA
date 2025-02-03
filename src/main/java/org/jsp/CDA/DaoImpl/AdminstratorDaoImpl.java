package org.jsp.CDA.DaoImpl;

import org.jsp.CDA.Dao.AdminstratorDao;
import org.jsp.CDA.entities.Adminstrator;
import org.jsp.CDA.repository.AdminstratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AdminstratorDaoImpl implements AdminstratorDao {

	@Autowired
	private AdminstratorRepository repo;

	@Override
	public void saveAdminstrator(Adminstrator adminstrator) {
		repo.save(adminstrator);
	}
}
