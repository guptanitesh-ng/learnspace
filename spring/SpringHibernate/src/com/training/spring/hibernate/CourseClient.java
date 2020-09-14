package com.training.spring.hibernate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Course course = null;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/springhibernate.xml");
		ICourseDAO courseDAO = (ICourseDAO)context.getBean("courseDao");

		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 7, 17);
		Date startDate = calendar.getTime();
		calendar.set(2013, 7, 21);
		Date endDate = calendar.getTime();
		course = new Course("Spring Level 1", startDate, endDate, 0.0);
		courseDAO.createCourse(course);
		
		List<Course> courses = courseDAO.getAllCourses();
		System.out.println(courses.size());
		
		course = courseDAO.findCourse(course);
		System.out.println(course.getCourseTitle());
		
		courseDAO.deleteCourse(course);
	}

}
