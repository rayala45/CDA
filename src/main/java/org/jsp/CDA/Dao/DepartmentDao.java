package org.jsp.CDA.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.entities.Department;

public interface DepartmentDao {

	Department save(Department department);

	List<Department> findAll();

	Optional<Department> findById(int id);

	Optional<Department> findByName(String name);

	void deleteById(int id);

}
