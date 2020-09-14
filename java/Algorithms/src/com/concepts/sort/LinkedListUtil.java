package com.concepts.sort;

import java.util.Random;

public class LinkedListUtil {

	public static void main(String[] args) {
		LinkedListUtil util = new LinkedListUtil();

		Node<Integer> head = null;
		Node<Integer> previous = null;
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			Node<Integer> node = new Node<Integer>();
			int number = random.nextInt(100);
			System.out.print(number + " ");
			node.setValue(number);
			if (previous == null) {
				previous = node;
				head = node;
			} else {
				previous.setNext(node);
				previous = node;
			}
		}
		System.out.println();
		util.nodeIterator(head);
		util.reverseAlternateNodes(head);
		System.out.println();
		util.nodeIterator(head);
	}

	private void nodeIterator(Node<Integer> rootNode) {
		Node<Integer> currentNode = rootNode;
		while (currentNode != null) {
			System.out.print(currentNode.getValue() + " ");
			currentNode = currentNode.getNext();
		}
	}

	private void reverseAlternateNodes(Node<Integer> rootNode) {
		if (rootNode == null || rootNode.getNext() == null
				|| rootNode.getNext().getNext() == null) {
			return;
		}
		Node<Integer> oddNode = rootNode;
		Node<Integer> evenNode = rootNode.getNext();
		Node<Integer> reverseRootNode = null;
		while (evenNode != null) {
			if (evenNode.getNext() == null) {
				evenNode.setNext(reverseRootNode);
				reverseRootNode = evenNode;
				break;
			} else {
				oddNode.setNext(evenNode.getNext());
				oddNode = oddNode.getNext();
			}

			if (reverseRootNode == null) {
				reverseRootNode = evenNode;
				reverseRootNode.setNext(null);
			} else {
				evenNode.setNext(reverseRootNode);
				reverseRootNode = evenNode;
			}
			evenNode = oddNode.getNext();
		}
		oddNode.setNext(reverseRootNode);
	}
}
