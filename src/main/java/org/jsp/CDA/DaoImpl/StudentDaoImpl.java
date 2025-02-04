package org.jsp.CDA.DaoImpl;

import java.util.List;
import java.util.Optional;

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
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Optional<Student> findById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Student> findAllStudents() {
		return repo.findAll();
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

}
