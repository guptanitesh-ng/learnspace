package com.manifest.concept.generics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetUtil {

	public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
		HashSet<T> hashSet = new HashSet<T>();
		hashSet.addAll(setA);
		hashSet.addAll(setB);
		return hashSet;
	}
	
	public static <T> Set<T> intersect(Set<T> setA, Set<T> setB) {
		return setA.stream().filter(e -> setB.contains(e)).collect(Collectors.toSet());
	}
	
	public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
		return setA.stream().filter(e -> !setB.contains(e)).collect(Collectors.toSet());
	}
	
	public static <T> List<T> difference(List<T> listA, List<T> listB) {
		return listA.stream().filter(e -> !listB.contains(e)).collect(Collectors.toList());
	}
}
