package org.jsp.CDA.Dao;

import java.util.List;

import org.jsp.CDA.entities.Enrollment;

public interface EnrollmentDao {

	Enrollment saveEnrollment(Enrollment enrollment);

	List<Enrollment> findEnrollmentByUserId(int uid);

	List<Enrollment> findEnrollmentByFacultyId(int fid);

}
