package org.jsp.CDA.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.CourseDao;
import org.jsp.CDA.Dao.DepartmentDao;
import org.jsp.CDA.Dao.FacultyDao;
import org.jsp.CDA.entities.Course;
import org.jsp.CDA.entities.Department;
import org.jsp.CDA.entities.Faculty;
import org.jsp.CDA.exceptionclasses.DuplicateCourseException;
import org.jsp.CDA.exceptionclasses.InvalidCourseIdException;
import org.jsp.CDA.exceptionclasses.InvalidFacultyIdException;
import org.jsp.CDA.exceptionclasses.NoCoursesFoundException;
import org.jsp.CDA.responsestructure.ResponseStructure;
import org.jsp.CDA.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao dao;
	
	@Autowired
	private FacultyDao fdao;
	
	@Autowired
	private DepartmentDao ddao;

	@Override
	public ResponseEntity<?> saveCourse(Course course) {
		Optional<Course> optional=dao.findByName(course.getTitle());
		if(optional.isPresent()) {
			throw DuplicateCourseException.builder().message("course already exist...").build();
		}
		course=dao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("course saved successfully...").body(course).build());
	}

	@Override
	public ResponseEntity<?> findCoursebyId(int id) {
		Optional<Course> optional=dao.findById(id);
		if(optional.isEmpty()) {
			throw InvalidCourseIdException.builder().message("invalid id...").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("course found successfully...").body(optional.get()).build());
	
	}

	@Override
	public ResponseEntity<?> findAllCourses() {
		List<Course> cl=dao.findAllCourses();
		if(cl.isEmpty()) {
			throw NoCoursesFoundException.builder().message("no corses found in the database..").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("courses found successfully...").body(cl).build());
	}

	@Override
	public ResponseEntity<?> assignFacultyToCourse(int cid, int fid) {
		Optional<Course> optional=dao.findById(cid);
		if(optional.isEmpty()) {
			throw InvalidCourseIdException.builder().message("invalid id...").build(); 
		}
		Optional<Faculty> optional1=fdao.findById(fid);
		if(optional.isEmpty()) {
			throw InvalidFacultyIdException.builder().message("invalid id...").build(); 
		}
		Faculty faculty=optional1.get();
		Course course=optional.get();
		course.setFaculty(faculty);
		course=dao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("faculty assigned successfully...").body(course).build());
		
	}

	@Override
	public ResponseEntity<?> delete(int id) {
		Optional<Course> optional=dao.findById(id);
		if(optional.isEmpty()) {
			throw InvalidCourseIdException.builder().message("invalid id unable to delete...").build();
		}
		dao.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("course found successfully...").body("deleted successfull..").build());
	
	}

	@Override
	public ResponseEntity<?> findByName(String title) {
		Optional<Course> optional = dao.findByName(title);
		if(optional.isEmpty()) {
			throw NoCoursesFoundException.builder().message("no corses found in the database..").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("courses found successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> update(Course course) {
		Optional<Course> optional=dao.findById(course.getId());
		if(optional.isEmpty()) {
			throw InvalidCourseIdException.builder().message("invalid id...").build(); 
		}
		course=dao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("course updated successfully...").body(course).build());
	}

	@Override
	public ResponseEntity<?> assignDepartmentToCourse(int cid, int did) {
		Optional<Department> optional = ddao.findById(did);
		if(optional.isEmpty()) {
			throw new RuntimeException("Invalid department id...");
		}
		Optional<Course> optional2 = dao.findById(cid);
		if(optional2.isEmpty()) {
			throw new RuntimeException("Invalid course id...");
		}
		Department department = optional.get();
		Course course = optional2.get();
		course.setDepartment(department);
		course=dao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("course updated successfully...").body(course).build());
	}

}
