package org.jsp.CDA.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.DepartmentDao;
import org.jsp.CDA.entities.Department;
import org.jsp.CDA.exceptionclasses.InvalidDepartmentIdException;
import org.jsp.CDA.exceptionclasses.InvalidDepartmentNameException;
import org.jsp.CDA.exceptionclasses.NoDepartmentFoundException;
import org.jsp.CDA.responsestructure.ResponseStructure;
import org.jsp.CDA.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentDao dao;

	@Override
	public ResponseEntity<?> save(Department department) {
		department=dao.save(department);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("department entered successfully...").body(department).build());
	}

	@Override
	public ResponseEntity<?> findAll() {
		List<Department> dl=dao.findAll();
		if(dl.isEmpty()) {
			throw NoDepartmentFoundException.builder().message("No department found...").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("departments found successfully...").body(dl).build());
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<Department> optional=dao.findById(id);
		if(optional.isEmpty()) {
			throw InvalidDepartmentIdException.builder().message("invalid department id...").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("departments found successfully by id...").body(optional.get()).build());
		
	}

	@Override
	public ResponseEntity<?> findByName(String name) {
		Optional<Department> optional=dao.findByName(name);
		if(optional.isEmpty()) {
			throw InvalidDepartmentNameException.builder().message("invalid department name...").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("departments found successfully by name...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> deleteById(int id) {
		Optional<Department> optional=dao.findById(id);
		if(optional.isEmpty()) {
			throw InvalidDepartmentIdException.builder().message("invalid department id unable to delete...").build();
		}
		dao.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("departments found successfully by id...").body(optional.get()).build());
		
	}

	@Override
	public ResponseEntity<?> update(Department department) {
		Optional<Department> optional = dao.findById(department.getId());
		if(optional.isEmpty()) {
			throw InvalidDepartmentIdException.builder().message("invalid department details unable to update...").build();
		}
		Department department2 = dao.save(department);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("department updated  successfully...").body(department2).build());
	}

}
