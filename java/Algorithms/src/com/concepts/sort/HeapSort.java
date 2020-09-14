package com.concepts.sort;

public class HeapSort {

	int[] heap;
	
	public void doSort(int[] heap) {
		
	}
	
	private void heapify(int[] heap, int currentRoot) {
		int rootValue = heap[currentRoot];
		int leftChildValue = heap[leftChild(currentRoot)];
		int newRoot = -1;
		if (rootValue < leftChildValue) {
			newRoot = leftChild(currentRoot);
		}
		int rightChildValue = heap[rightChild(currentRoot)];
		if (rootValue < rightChildValue) {
			newRoot = rightChild(currentRoot);
		}
		if (newRoot > -1) {
			// do swap
			int tempValue = rootValue;
			heap[currentRoot] = heap[newRoot];
			heap[newRoot] = tempValue;
			heapify(heap, newRoot);
		}
	}
	
	private int sibling(int child) {
		return (child % 2 == 1) ? child + 1 : child - 1;
	}

	private int rootNode(int child) {
		return (child % 2 == 1) ? (child - 1) / 2 : (child - 2) / 2;
	}

	private int leftChild(int root) {
		return root * 2 + 1;
	}

	private int rightChild(int root) {
		return root * 2 + 2;
	}
}
