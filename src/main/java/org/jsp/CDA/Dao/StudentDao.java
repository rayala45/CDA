package org.jsp.CDA.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.entities.Student;

public interface StudentDao {

	Student saveStudent(Student student);

	Optional<Student> findById(int id);

	List<Student> findAllStudents();

	void delete(int id);


}
