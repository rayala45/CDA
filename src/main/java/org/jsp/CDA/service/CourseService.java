package org.jsp.CDA.service;

import org.jsp.CDA.entities.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {

	ResponseEntity<?> saveCourse(Course course);

	ResponseEntity<?> findCoursebyId(int id);

	ResponseEntity<?> findAllCourses();

	ResponseEntity<?> assignFacultyToCourse(int cid, int fid);

	ResponseEntity<?> delete(int id);

	ResponseEntity<?> findByName(String title);

	ResponseEntity<?> update(Course course);

	ResponseEntity<?> assignDepartmentToCourse(int cid, int did);

}
