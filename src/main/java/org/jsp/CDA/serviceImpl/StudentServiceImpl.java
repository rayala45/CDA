package org.jsp.CDA.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.DepartmentDao;
import org.jsp.CDA.Dao.StudentDao;
import org.jsp.CDA.entities.Department;
import org.jsp.CDA.entities.Student;
import org.jsp.CDA.responsestructure.ResponseStructure;
import org.jsp.CDA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao dao;
	
	@Autowired
	private DepartmentDao ddao;

	@Override
	public ResponseEntity<?> findStudentbyId(int id) {
		Optional<Student> optional = dao.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Student found successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllStudent() {
		List<Student> sl= dao.findAllStudents();
		if(sl.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("student found successfully...").body(sl).build());
	
	}

	@Override
	public ResponseEntity<?> delete(int id) {
		Optional<Student> optional = dao.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		dao.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("student found successfully...").body("student deleted successfully...").build());
	
	}

	@Override
	public ResponseEntity<?> updateStudent(Student student) {
		Optional<Student> optional = dao.findById(student.getId());
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Id...");
		}
		Student student1=dao.saveStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Student found successfully...").body(student1).build());
	
	}

	@Override
	public ResponseEntity<?> findByName(String name) {
		List<Student> sl=dao.findAllStudents();
		List<Student> rl=new ArrayList<>();
		if(sl.isEmpty()) {
			throw new RuntimeException("No student found in the database");
		}
		for(Student s:sl) {
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
		List<Student> sl=dao.findAllStudents();
		List<Student> rl=new ArrayList<>();
		if(sl.isEmpty()) {
			throw new RuntimeException("No student found in the database");
		}
		for(Student s:sl) {
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
	public ResponseEntity<?> assignDepartmentToStudent(int uid, int did) {
		Optional<Student> optional = dao.findById(uid);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Student id...");
		}
		Optional<Department> optional2 = ddao.findById(did);
		if(optional2.isEmpty()) {
			throw new RuntimeException("invalid department id...");
		}
		Student student = optional.get();
		Department department = optional2.get();
		student.setDepartment(department);
		Student student2 = dao.saveStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("department assigned to the Student....").body(student2).build());
	}

}
