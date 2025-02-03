package org.jsp.CDA.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.FacultyDao;
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
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("faculty found successfully...").body("deleted successfully").build());
	}

}
