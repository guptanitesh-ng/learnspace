package com.manifest.concept.generics.medialibrary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Represents a collection of any sub types of media elements. Provides methods to add and
 * retrieve from the collection.
 * 
 * @author nitesh.gupta
 *
 */
public class MediaLibrary<T extends Media> {

	private Collection<T> mediaCollection = new ArrayList<>();

	public boolean addMedia(T media) {
		return mediaCollection.add(media);
	}

	public Optional<T> getMedia(long id) {
		return mediaCollection.stream().filter(m -> m.getId() == id).findFirst();
	}
}
