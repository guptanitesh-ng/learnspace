package com.manifest.concept.generics.union;

import java.util.ArrayList;
import java.util.List;

/**
 * Performs union of two lists. The input list could contain the type T or any of its sub types.
 * The response is a new list of type T containing all the elements from both the input lists. 
 * @author nitesh.gupta
 *
 */
public class UnionUtil {

	public static <T> List<T> union(List<? extends T> firstList, List<? extends T> secondList){
		List<T> unionList = new ArrayList<T>();
		unionList.addAll(firstList);
		unionList.addAll(secondList);
		return unionList;
	}
}
