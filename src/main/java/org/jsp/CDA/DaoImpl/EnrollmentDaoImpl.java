package org.jsp.CDA.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.EnrollmentDao;
import org.jsp.CDA.entities.Enrollment;
import org.jsp.CDA.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnrollmentDaoImpl implements EnrollmentDao{

	@Autowired
	private EnrollmentRepository repo;

	@Override
	public Enrollment saveEnrollment(Enrollment enrollment) {
		return repo.save(enrollment);
	}


	@Override
	public List<Enrollment> findEnrollmentByUserId(int uid) {
		return repo.findAllEnrollmentByUserId(uid);
	}


	@Override
	public List<Enrollment> findEnrollmentByFacultyId(int fid) {
		return repo.findAllEnrollmentByFacultyId(fid);
	}


	@Override
	public List<Enrollment> findAllEnrollments() {
		return repo.findAll();
	}


	@Override
	public List<Enrollment> findAllEnrollmentsOfCourse(int cid) {
		return repo.findAllEnrollmentsOfCourse(cid);
	}


	@Override
	public List<Enrollment> findAllEnrollmentsOfStudent(int sid) {
		return repo.findAllEnrollmentsOfStudent(sid);
	}


	@Override
	public Optional<Enrollment> findEnrollmentById(int eid) {
		return repo.findById(eid);
	}
}
