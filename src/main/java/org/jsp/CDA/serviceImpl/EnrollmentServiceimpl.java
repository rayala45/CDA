package org.jsp.CDA.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.CourseDao;
import org.jsp.CDA.Dao.EnrollmentDao;
import org.jsp.CDA.Dao.StudentDao;
import org.jsp.CDA.entities.Course;
import org.jsp.CDA.entities.Enrollment;
import org.jsp.CDA.entities.Student;
import org.jsp.CDA.responsestructure.ResponseStructure;
import org.jsp.CDA.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceimpl implements EnrollmentService{
	@Autowired
	private EnrollmentDao dao;
	
	@Autowired
	private StudentDao sdao;
	@Autowired
	private CourseDao cdao;

	@Override
	public ResponseEntity<?> saveEnrollment(int uid, int cid) {
		Optional<Student> optional = sdao.findById(uid);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Student id...");
		}
		Optional<Course> optional2 = cdao.findById(cid);
		if(optional2.isEmpty()) {
			throw new RuntimeException("invalid Student id...");
		}
		Student student = optional.get();
		Course course = optional2.get();
		Enrollment enrollment=Enrollment.builder().course(course).student(student).build();
		enrollment=dao.saveEnrollment(enrollment);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Enrolled successfully..").body(enrollment).build());
	}

	@Override
	public ResponseEntity<?> findEnrollmentByUserId(int uid) {
		List<Enrollment> el=dao.findEnrollmentByUserId(uid);
		if(el.isEmpty()) {
			throw new RuntimeException("Not enrolled to any course...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("all Enrollments..").body(el).build());
	}

	@Override
	public ResponseEntity<?> findEnrollmentByFacultyId(int fid) {
		List<Enrollment> el=dao.findEnrollmentByFacultyId(fid);
		if(el.isEmpty()) {
			throw new RuntimeException("Not enrolled to any course...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("all Enrollments..").body(el).build());
	
	}

	@Override
	public ResponseEntity<?> findAllEnrollmentsOfStudent(int sid) {
		Optional<Student> optional = sdao.findById(sid);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Student id...");
		}
		List<Enrollment> el=dao.findAllEnrollmentsOfStudent(sid);
		if(el.isEmpty()) {
			throw new RuntimeException("No enrollments in the dataBase...");
		}
//		List<Course> cl=new ArrayList<>();
//		for(Enrollment e:el) {
//			if(e.getStudent().getId()==sid) {
//				cl.add(e.getCourse());
//			}
//		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("all Enrollments of a given student..").body(el).build());
	}

	@Override
	public ResponseEntity<?> findAllEnrollmentsOfCourse(int cid) {
		Optional<Course> optional = cdao.findById(cid);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid Student id...");
		}
		List<Enrollment> el=dao.findAllEnrollmentsOfCourse(cid);
		if(el.isEmpty()) {
			throw new RuntimeException("No Enrollments for given course id");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("all Enrollments of a given course..").body(el).build());
	}

	@Override
	public ResponseEntity<?> findAllEnrollments() {
		List<Enrollment> el = dao.findAllEnrollments();
		if(el.isEmpty()) {
			throw new RuntimeException("No Enrollments in the Database...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("all Enrollments found..").body(el).build());
	}

	@Override
	public ResponseEntity<?> findEnrollmentById(int eid) {
		Optional<Enrollment> optional=dao.findEnrollmentById(eid);
		if(optional.isEmpty()) {
			throw new RuntimeException("Invalid Enrollment id.....");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Enrollment found successfully with given id..").body(optional.get()).build());
	}

}
