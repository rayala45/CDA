package org.jsp.CDA.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.DepartmentDao;
import org.jsp.CDA.Dao.FacultyDao;
import org.jsp.CDA.entities.Department;
import org.jsp.CDA.entities.Faculty;
import org.jsp.CDA.responsestructure.ResponseStructure;
import org.jsp.CDA.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class FacultyServiceImpl implements FacultyService {
	@Autowired
	private FacultyDao dao;
	
	@Autowired
	private DepartmentDao ddao;

	@Override
	public ResponseEntity<?> findfacultybyId(int id) {
		Optional<Faculty> optional = dao.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("faculty found successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllFaculties() {
		List<Faculty> fl=dao.findAll();
		if(fl.isEmpty()) {
			throw new RuntimeException("No faculty found..");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("faculty found successfully...").body(fl).build());
	}

	@Override
	public ResponseEntity<?> delete(int id) {
		Optional<Faculty> optional = dao.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		dao.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("faculty found successfully...").body("deleted successfully").build());
	}

	@Override
	public ResponseEntity<?> updateFaculty(Faculty faculty) {
		Optional<Faculty> optional = dao.findById(faculty.getId());
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		faculty=dao.saveFaculty(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("faculty found successfully...").body(faculty).build());
	}

	@Override
	public ResponseEntity<?> findByName(String name) {
		List<Faculty> sl=dao.findAll();
		List<Faculty> rl=new ArrayList<>();
		if(sl.isEmpty()) {
			throw new RuntimeException("No student found in the database");
		}
		for(Faculty s:sl) {
			if(s.getUser().getName().equalsIgnoreCase(name)) {
				rl.add(s);
			}
		}
		if(rl.isEmpty()) {
			throw new RuntimeException("No user found with that name");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("faculty found successfully with given name...").body(rl).build());
	}

	@Override
	public ResponseEntity<?> findByUsername(String username) {
		List<Faculty> sl=dao.findAll();
		List<Faculty> rl=new ArrayList<>();
		if(sl.isEmpty()) {
			throw new RuntimeException("No student found in the database");
		}
		for(Faculty s:sl) {
			if(s.getUser().getUsername().equalsIgnoreCase(username)) {
				rl.add(s);
			}
		}
		if(rl.isEmpty()) {
			throw new RuntimeException("No user found with that name");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Faculty found successfully with given name...").body(rl).build());
	}

	@Override
	public ResponseEntity<?> assignDepartmentToFaculty(int fid, int did) {
		Optional<Department> optional2 = ddao.findById(did);
		if(optional2.isEmpty()) {
			throw new RuntimeException("invalid department id...");
		}
		Optional<Faculty> optional = dao.findById(fid);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Faculty id...");
		}
		Faculty faculty = optional.get();
		Department department = optional2.get();
		faculty.setDepartment(department);
		faculty=dao.saveFaculty(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("department assigned to the faculty successfully...").body(faculty).build());
	}
	
	

}
