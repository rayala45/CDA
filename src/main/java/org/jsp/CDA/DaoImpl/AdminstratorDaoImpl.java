package org.jsp.CDA.DaoImpl;

import java.util.List;
import java.util.Optional;

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
	public Adminstrator saveAdminstrator(Adminstrator adminstrator) {
		return repo.save(adminstrator);
	}

	@Override
	public Optional<Adminstrator> findById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Adminstrator> findAll() {
		return repo.findAll();
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}
}
