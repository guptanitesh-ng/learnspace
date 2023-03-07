package com.manifest.concept;

import java.util.Comparator;
import java.util.Objects;

public class HeapSort<T extends Comparable<? super T>, U> {

	private T[] comparableHeap;
	private U[] heap;
	private Comparator<? super U> comparator;

	public HeapSort(T[] heap) {
		this.comparableHeap = heap;
	}

	public HeapSort(U[] heap, Comparator<? super U> comparator) {
		this.heap = heap;
		this.comparator = comparator;
	}

	public void perform() {
		if (Objects.nonNull(comparableHeap)) {
			doSortWithComparable();
		} else {
			doSort();
		}
	}

	private void doSortWithComparable() {
		for (int i = (comparableHeap.length / 2 - 1); i >= 0; i--) {
			heapifyWithComparable(i, comparableHeap.length);
		}

		for (int i = comparableHeap.length - 1; i >= 0; i--) {
			T tempValue = comparableHeap[i];
			comparableHeap[i] = comparableHeap[0];
			comparableHeap[0] = tempValue;

			heapifyWithComparable(0, i);
		}
	}

	private void doSort() {
		for (int i = (heap.length / 2 - 1); i >= 0; i--) {
			heapify(i, heap.length);
		}

		for (int i = heap.length - 1; i >= 0; i--) {
			U tempValue = heap[i];
			heap[i] = heap[0];
			heap[0] = tempValue;

			heapify(0, i);
		}
	}

	private void heapify(int root, int currentSize) {
		int newRoot = root;
		if (leftChild(root) < currentSize && comparator.compare(heap[newRoot], heap[leftChild(newRoot)]) < 0) {
			newRoot = leftChild(root);
		}

		if (rightChild(root) < currentSize && comparator.compare(heap[newRoot], heap[rightChild(root)]) < 0) {
			newRoot = rightChild(root);
		}

		if (newRoot > root) {
			// do swap
			U tempValue = heap[root];
			heap[root] = heap[newRoot];
			heap[newRoot] = tempValue;
			heapify(newRoot, currentSize);
		}
	}

	private void heapifyWithComparable(int root, int currentSize) {
		int newRoot = root;
		if (leftChild(root) < currentSize
				&& comparableHeap[newRoot].compareTo(comparableHeap[leftChild(newRoot)]) < 0) {
			newRoot = leftChild(root);
		}

		if (rightChild(root) < currentSize && comparableHeap[newRoot].compareTo(comparableHeap[rightChild(root)]) < 0) {
			newRoot = rightChild(root);
		}

		if (newRoot > root) {
			// do swap
			swap(root, newRoot);
			heapifyWithComparable(newRoot, currentSize);
		}
	}

	private void swap(int root, int newRoot) {
		T tempValue = comparableHeap[root];
		comparableHeap[root] = comparableHeap[newRoot];
		comparableHeap[newRoot] = tempValue;
	}

	private int leftChild(int root) {
		return root * 2 + 1;
	}

	private int rightChild(int root) {
		return root * 2 + 2;
	}
}
