package com.manifest.concept.generics.thc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Container {

	private final Map<PropertyKey<?>, Object> properties = new HashMap<>();

	public <T> T getProperty(PropertyKey<T> property) {
		return property.getType().cast(properties.get(property));
	}

	public <T> void setProperty(PropertyKey<T> property, T value) {
		properties.put(Objects.requireNonNull(property), value);
	}
}
