package org.jsp.CDA.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.entities.Faculty;

public interface FacultyDao {

	Optional<Faculty> findById(int cid);

	Faculty saveFaculty(Faculty faculty);

	List<Faculty> findAll();

	void delete(int id);



}
