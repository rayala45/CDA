package org.jsp.CDA.repository;

import java.util.List;

import org.jsp.CDA.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{

	@Query("SELECT e FROM Enrollment e WHERE e.student.id = :uid")
	List<Enrollment> findAllEnrollmentByUserId(@Param("uid") int uid);

	@Query("SELECT e FROM Enrollment e WHERE e.course.faculty.id = :fid")
	List<Enrollment> findAllEnrollmentByFacultyId(@Param("fid") int fid);

	@Query("SELECT e FROM Enrollment e WHERE e.course.id = :cid")
	List<Enrollment> findAllEnrollmentsOfCourse(int cid);

	@Query("SELECT e FROM Enrollment e WHERE e.student.id = :sid")
	List<Enrollment> findAllEnrollmentsOfStudent(int sid);

}
