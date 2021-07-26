package com.manifest.concept.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Description {

	private int id;

	private String text;

	private boolean active;

	@JsonCreator(mode=Mode.DEFAULT)
	public Description(@JsonProperty("id") int id, @JsonProperty("text") String text, @JsonProperty("active") boolean active) {
		super();
		this.id = id;
		this.text = text;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public boolean isActive() {
		return active;
	}

}
