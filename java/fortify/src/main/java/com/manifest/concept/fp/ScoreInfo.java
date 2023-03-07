package com.manifest.concept.fp;

public class ScoreInfo {
	private String lastName;
	private String firstName;
	private int score;
	
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public ScoreInfo(String lastName, String firstName, int score) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.score = score;
	}


	@Override
	public String toString() {
		return "ScoreInfo [lastName=" + lastName + ", firstName=" + firstName + ", score=" + score + "]";
	}
	
	
}