package org.jsp.CDA.DaoImpl;

import org.jsp.CDA.Dao.StudentDao;
import org.jsp.CDA.entities.Student;
import org.jsp.CDA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private StudentRepository repo;

	@Override
	public void saveStudent(Student student) {
		repo.save(student);
	}

}
