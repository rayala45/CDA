package org.jsp.CDA.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.FacultyDao;
import org.jsp.CDA.entities.Faculty;
import org.jsp.CDA.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class FacultyDaoImpl implements FacultyDao{
	@Autowired
	private FacultyRepository repo;

	@Override
	public Optional<Faculty> findById(int id) {
		return repo.findById(id);
	}

	@Override
	public void saveFaculty(Faculty faculty) {
		repo.save(faculty);
	}

	@Override
	public List<Faculty> findAll() {
		return repo.findAll();
	}

}
