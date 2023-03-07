package com.manifest.concept.generics;

public class SameTypePair<T> {

	private T first;
	private T second;
	
	public SameTypePair(T first, T second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	public T getFirst() {
		return first;
	}
	
	public T getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "SameTypePair [first=" + first + ", second=" + second + "]";
	}
	
	public void swap() {
		T temp = this.first;
		this.first = this.second;
		this.second = temp;
	}
	
}
