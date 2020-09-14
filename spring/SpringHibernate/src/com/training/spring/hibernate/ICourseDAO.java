package com.training.spring.hibernate;

import java.util.List;

public interface ICourseDAO {

	public void createCourse(Course course);
	
	public void deleteCourse(Course course);
	
	public Course findCourse(Course course);
	
	public List<Course> getAllCourses();
}
