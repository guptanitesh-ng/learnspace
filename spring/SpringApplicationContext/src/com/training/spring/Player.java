package com.training.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="playerPOJO")
public class Player {

	@Value("defaultPlayer")
	private String name;
	
	private String lastName;
	
	private int age;
	
	private int matchesPlayed;
	
	public Player() {
		
	}
	
	public Player(String name, int matchedPlayed) {
		this.name = name;
		this.matchesPlayed = matchedPlayed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
}
