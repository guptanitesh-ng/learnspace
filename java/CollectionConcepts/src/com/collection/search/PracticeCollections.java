package com.collection.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PracticeCollections {

	public static void main(String[] args) {
		// Check adding element to immutable list throws Unsupported exception
		//List emptyList = Collections.EMPTY_LIST;
		//emptyList.add("");
		
		Object[] params = {"One", "Two", "Three"};
		StringBuffer keyPrefix = new StringBuffer("methodName");
		Arrays.asList(params).forEach(e -> keyPrefix.append(":").append(e.toString()));
		System.out.println(keyPrefix);
	}
}
