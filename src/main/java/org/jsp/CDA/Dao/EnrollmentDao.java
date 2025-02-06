package org.jsp.CDA.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.entities.Enrollment;

public interface EnrollmentDao {

	Enrollment saveEnrollment(Enrollment enrollment);

	List<Enrollment> findEnrollmentByUserId(int uid);

	List<Enrollment> findEnrollmentByFacultyId(int fid);

	List<Enrollment> findAllEnrollments();

	List<Enrollment> findAllEnrollmentsOfCourse(int cid);

	List<Enrollment> findAllEnrollmentsOfStudent(int sid);

	Optional<Enrollment> findEnrollmentById(int eid);

}
