package com.manifest.concept.generics.medialibrary;

import java.time.LocalDate;

public class Book extends Media {

	public Book(long id, String name, LocalDate publishedOn) {
		super(id, name, publishedOn);
	}

}
