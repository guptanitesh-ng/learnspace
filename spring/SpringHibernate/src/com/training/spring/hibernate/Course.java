package com.training.spring.hibernate;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9091552486924584162L;

	private int courseId;
	
	private String courseTitle;
	
	private Date startDate;
	
	private Date endDate;
	
	private double fee;
	
	public Course() {
		
	}
	
	public Course(String courseTitle, Date startDate, Date endDate, double fee) {
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fee = fee;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
}
