package com.manifest.concept.generics.medialibrary;

import java.time.LocalDate;

public class Video extends Media {

	public Video(long id, String name, LocalDate publishedOn) {
		super(id, name, publishedOn);
	}

}
