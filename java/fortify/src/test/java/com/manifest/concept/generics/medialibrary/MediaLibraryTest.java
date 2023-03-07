package com.manifest.concept.generics.medialibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.junit.Test;

import com.manifest.concept.generics.medialibrary.Media;
import com.manifest.concept.generics.medialibrary.MediaLibrary;
import com.manifest.concept.generics.medialibrary.Newspaper;

public class MediaLibraryTest {

	@Test
	public void testGetMedia() {
		MediaLibrary<Media> library = new MediaLibrary<>();
		Media media = new Newspaper(1, "The Time", LocalDate.now(ZoneId.of("Asia/Kolkata")));
		library.addMedia(media);
		Optional<Media> optionalMedia = library.getMedia(1);
		assertTrue(optionalMedia.isPresent());
		assertEquals("Media Id does not match",1, optionalMedia.get().getId());
	}
}
