package org.jsp.CDA.repository;

import java.util.Optional;

import org.jsp.CDA.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	Optional<Course> findByTitle(String title);

}
