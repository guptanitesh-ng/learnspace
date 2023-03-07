package com.manifest.concept.generics;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.manifest.concept.RandomDataGenerator;

public class SetUtilTest {
	
	@Test
	public void testSetAddition() {
		Set<Integer> setA = new HashSet<Integer>();
		setA.addAll(Arrays.asList(RandomDataGenerator.generateNumberArray(10, Integer.class)));
		
		Set<Integer> setB = new HashSet<Integer>();
		setB.addAll(Arrays.asList(RandomDataGenerator.generateNumberArray(10, Integer.class)));
		
		System.out.println(setA + "\n" + setB);
		Set<Integer> union = SetUtil.union(setA, setB);
		System.out.println(union);		
		assertTrue("Expected 20",20 >= union.size());
	}
	
	@Test
	public void testSetIntersection() {
		Set<Integer> setA = new HashSet<Integer>();
		setA.addAll(Arrays.asList(RandomDataGenerator.generateNumberArray(10, Integer.class)));
		
		Set<Integer> setB = new HashSet<Integer>();
		setB.addAll(Arrays.asList(RandomDataGenerator.generateNumberArray(10, Integer.class)));
		
		System.out.println(setA + "\n" + setB);
		Set<Integer> union = SetUtil.intersect(setA, setB);
		System.out.println(union);		
		assertTrue("Expected 20",10 >= union.size());
	}
	
	@Test
	public void testSetDifference() {
		Set<Integer> setA = new HashSet<Integer>();
		setA.addAll(Arrays.asList(RandomDataGenerator.generateNumberArray(10, Integer.class)));
		
		Set<Integer> setB = new HashSet<Integer>();
		setB.addAll(Arrays.asList(RandomDataGenerator.generateNumberArray(10, Integer.class)));
		
		System.out.println(setA + "\n" + setB);
		Set<Integer> union = SetUtil.difference(setA, setB);
		System.out.println(union);		
		assertTrue("Expected 20",10 >= union.size());
	}
}
