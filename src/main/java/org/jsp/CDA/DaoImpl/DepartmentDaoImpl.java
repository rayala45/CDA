package org.jsp.CDA.DaoImpl;
import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.DepartmentDao;
import org.jsp.CDA.entities.Department;
import org.jsp.CDA.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class DepartmentDaoImpl implements DepartmentDao{
	@Autowired
	private DepartmentRepository repo;

	@Override
	public Department save(Department department) {
		return repo.save(department);
	}

	@Override
	public List<Department> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Department> findById(int id) {
		return repo.findById(id);
	}

	@Override
	public Optional<Department> findByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}

	

}
