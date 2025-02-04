package org.jsp.CDA.DaoImpl;

import java.util.List;

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
}
