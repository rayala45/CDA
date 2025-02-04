package org.jsp.CDA.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.entities.Adminstrator;

public interface AdminstratorDao {

	Adminstrator saveAdminstrator(Adminstrator adminstrator);

	Optional<Adminstrator> findById(int id);

	List<Adminstrator> findAll();

	void delete(int id);

  



}
