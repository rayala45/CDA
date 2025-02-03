package org.jsp.CDA.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.entities.Course;

public interface CourseDao {

	Optional<Course> findByName(String title);

	Course saveCourse(Course course);

	Optional<Course> findById(int id);

	List<Course> findAllCourses();

	void delete(int id);

}
