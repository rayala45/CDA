package org.jsp.CDA.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.AdminstratorDao;
import org.jsp.CDA.Dao.DepartmentDao;
import org.jsp.CDA.entities.Adminstrator;
import org.jsp.CDA.entities.Department;
import org.jsp.CDA.responsestructure.ResponseStructure;
import org.jsp.CDA.service.AdminstratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class AdminstratorServiceImpl implements AdminstratorService {
	@Autowired
	private AdminstratorDao dao;
	
	@Autowired
	private DepartmentDao ddao;

	@Override
	public ResponseEntity<?> findAdminstratorbyId(int id) {
		Optional<Adminstrator> optional = dao.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("student found successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllAdminstrator() {
		List<Adminstrator> al = dao.findAll();
		if(al.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("student found successfully...").body(al).build());
	}

	@Override
	public ResponseEntity<?> delete(int id) {
		Optional<Adminstrator> optional = dao.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		dao.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("student found successfully...").body("student deleted successfully...").build());
	
	}

	@Override
	public ResponseEntity<?> updateAdmin(Adminstrator adminstrator) {
		Optional<Adminstrator> optional = dao.findById(adminstrator.getId());
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		adminstrator=dao.saveAdminstrator(adminstrator);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("student found successfully...").body(adminstrator).build());
	}

	@Override
	public ResponseEntity<?> findByName(String name) {
		List<Adminstrator> sl=dao.findAll();
		List<Adminstrator> rl=new ArrayList<>();
		if(sl.isEmpty()) {
			throw new RuntimeException("No student found in the database");
		}
		for(Adminstrator s:sl) {
			if(s.getUser().getName().equalsIgnoreCase(name)) {
				rl.add(s);
			}
		}
		if(rl.isEmpty()) {
			throw new RuntimeException("No user found with that name");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Student found successfully with given name...").body(rl).build());
	}

	@Override
	public ResponseEntity<?> findByUsername(String username) {
		List<Adminstrator> sl=dao.findAll();
		List<Adminstrator> rl=new ArrayList<>();
		if(sl.isEmpty()) {
			throw new RuntimeException("No student found in the database");
		}
		for(Adminstrator s:sl) {
			if(s.getUser().getUsername().equalsIgnoreCase(username)) {
				rl.add(s);
			}
		}
		if(rl.isEmpty()) {
			throw new RuntimeException("No user found with that name");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Student found successfully with given name...").body(rl).build());
	}

	@Override
	public ResponseEntity<?> assignDepartmentToAdmin(int aid, int did) {
		Optional<Department> optional = ddao.findById(did);
		if(optional.isEmpty()) {
			throw new RuntimeException("Invalid department id...");
		}
		Optional<Adminstrator> optional2 = dao.findById(aid);
		if(optional2.isEmpty()) {
			throw new RuntimeException("Invalid Admin id...");
		}
		Adminstrator adminstrator = optional2.get();
		Department department = optional.get();
		adminstrator.setDepartment(department);
		adminstrator=dao.saveAdminstrator(adminstrator);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("department assigned to admin succesfully...").body(adminstrator).build());
	}

}
