package com.training.spring.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("courseDao")
@Transactional
public class HibernateCourseDAO implements ICourseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createCourse(Course course) {
		sessionFactory.getCurrentSession().save(course);
	}

	@Override
	public void deleteCourse(Course course) {
		sessionFactory.getCurrentSession().delete(findCourse(course));
	}

	@Override
	public Course findCourse(Course course) {
		return (Course)sessionFactory.getCurrentSession().get(Course.class, course.getCourseId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCourses() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
		return criteria.list();
	}

}
