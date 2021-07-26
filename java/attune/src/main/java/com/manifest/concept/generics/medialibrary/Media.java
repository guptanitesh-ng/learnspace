package com.manifest.concept.generics.medialibrary;

import java.time.LocalDate;
import java.util.Date;

public abstract class Media {

	private long id;
	
	private String name;
	
	private LocalDate publishedOn;

	public Media(long id, String name, LocalDate publishedOn) {
		super();
		this.id = id;
		this.name = name;
		this.publishedOn = publishedOn;
	}

	public String getName() {
		return name;
	}

	public LocalDate getPublishedOn() {
		return publishedOn;
	}

	public long getId() {
		return id;
	}

}
