package com.manifest.concept;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class HeapSortTest {

	@Test
	public void testHeapify() {
		Integer[] heap = RandomDataGenerator.generateNumberArray(14, Integer.class);
		System.out.println(Arrays.toString(heap));
		HeapSort<Integer,Integer> heapSort = new HeapSort<Integer, Integer>(heap);
		heapSort.perform();
		System.out.println(Arrays.toString(heap));
	}
	
	@Test
	public void testMaxHeap() {
		// [96, 79, 90, 42, 47, 85, 88, 15, 23, 18, 16, 16, 10, 84]
		Integer[] heap = new Integer[] {23, 42, 10, 15, 18, 90, 88, 96, 79, 47, 16, 16, 85, 84};
		HeapSort<Integer,Integer> heapSort = new HeapSort<Integer, Integer>(heap);
		heapSort.perform();
		System.out.println(Arrays.toString(heap));
	}
	
	@Test
	public void testComparatorMaxHeap() {
		Employee[] employees = new Employee[2];
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		employees[0] = employee1;
		employees[1] = employee2;
		Integer[] heap = new Integer[] {23, 42, 10, 15, 18, 90, 88, 96, 79, 47, 16, 16, 85, 84};
		HeapSort<Integer,Integer> heapSort = new HeapSort<Integer, Integer>(heap, Collections.reverseOrder());
		heapSort.perform();
		System.out.println(Arrays.toString(heap));
	}
}
