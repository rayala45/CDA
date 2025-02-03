package org.jsp.CDA.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.CDA.Dao.CourseDao;
import org.jsp.CDA.entities.Course;
import org.jsp.CDA.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao {
	@Autowired
	private CourseRepository repo;

	@Override
	public Optional<Course> findByName(String title) {
		return repo.findByTitle(title);
	}

	@Override
	public Course saveCourse(Course course) {
		return repo.save(course);
	}

	@Override
	public Optional<Course> findById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return repo.findAll();
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

}
