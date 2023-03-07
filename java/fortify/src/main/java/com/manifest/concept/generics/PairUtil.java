package com.manifest.concept.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PairUtil {

	public static <F,S> Pair<S,F> swap(Pair<F,S> pair){
		return new Pair<S,F>(pair.getSecond(), pair.getFirst());
	}
	
	public static <T extends Comparable<? super T>> Pair<T,T> computeMinMax(T[] elements) {		
		List<T> elementsList = Arrays.asList(elements);
		Collections.sort(elementsList);
		return new Pair<T, T>(elementsList.get(0),
				elementsList.get(elementsList.size()-1));
	}

}
