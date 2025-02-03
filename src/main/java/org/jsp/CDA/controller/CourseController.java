package org.jsp.CDA.controller;

import org.jsp.CDA.entities.Course;
import org.jsp.CDA.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@PostMapping
	public ResponseEntity<?> saveCourse(@RequestBody Course course){
		return service.saveCourse(course);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findCourse(@PathVariable int id){
		return service.findCoursebyId(id);
	}
	@GetMapping
	public ResponseEntity<?> findAllCourse(){
		return service.findAllCourses();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return service.delete(id);
	}
	
	@PatchMapping("/{cid}/{fid}")
	public ResponseEntity<?> assignFacultyToCourse(@PathVariable int cid,@PathVariable int fid){
		return service.assignFacultyToCourse(cid,fid);
	}
	
	
	@GetMapping("/title/{title}")
	public ResponseEntity<?> findByname(@PathVariable String title){
		return service.findByName(title);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<?> findByname(@RequestBody Course course){
		return service.update(course);
	}


}
