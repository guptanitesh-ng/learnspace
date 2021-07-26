package com.manifest.concept.generics.union;

public class Cake {

	private int cakeId;

	public Cake(int cakeId) {
		super();
		this.cakeId = cakeId;
	}

	public int getCakeId() {
		return cakeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cakeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cake other = (Cake) obj;
		if (cakeId != other.cakeId)
			return false;
		return true;
	}
	
}
