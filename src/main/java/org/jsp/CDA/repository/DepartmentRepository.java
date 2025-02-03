package org.jsp.CDA.repository;

import java.util.Optional;

import org.jsp.CDA.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	Optional<Department> findByName(String name);

}
