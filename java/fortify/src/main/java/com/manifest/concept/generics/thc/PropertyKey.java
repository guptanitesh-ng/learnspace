package com.manifest.concept.generics.thc;

import java.util.Objects;

public class PropertyKey<T> {

	private Class<T> type;
	
	private String name;

	public PropertyKey(Class<T> type, String name) {
		this.type = type;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyKey<?> other = (PropertyKey<?>) obj;
		return Objects.equals(type, other.type) && Objects.equals(name, other.name);
	}

	public Class<T> getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
	
}
