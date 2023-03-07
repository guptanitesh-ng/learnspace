package com.concepts.sort;

import java.util.Objects;
import java.util.Random;

public class LinkedListUtil {

	public static void main(String[] args) {
		LinkedListUtil util = new LinkedListUtil();

		Node<Integer> head = null;
		Node<Integer> previous = null;
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			Node<Integer> node = new Node<Integer>();
			int number = random.nextInt(100);
			// System.out.print(number + " ");
			node.setValue(number);
			if (previous == null) {
				previous = node;
				head = node;
			} else {
				previous.setNext(node);
				previous = node;
			}
		}
		// System.out.println();
		util.nodeIterator(head);

		util.reverseAlternateNodes(head);
		System.out.println();
		util.nodeIterator(head);

		head = util.reverse(head);
		System.out.println();
		util.nodeIterator(head);

		head = util.reverseKNodesRecursively(head, 4);
		System.out.println();
		util.nodeIterator(head);
	}

	private <T> Node<T> reverseKNodesRecursively(Node<T> head, long k) {
		Node<T> current = head;
		Node<T> previous = null;
		Node<T> next = null;
		long count = k;
		while (Objects.nonNull(current) && count > 0) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
			count--;
		}
		if (count == 0)
			head.setNext(reverseKNodesRecursively(current, k));
		return previous;
	}

	private <T> Node<T> reverseKNodes(Node<T> head, long k) {
		Node<T> originalHead = head;
		Node<T> currentHead = head;
		Node<T> previousHead = null;
		long count = k;
		boolean initial = true;
		while (Objects.nonNull(originalHead.getNext()) && count > 1) {
			Node<T> current = originalHead.getNext();
			Node<T> next = current.getNext();
			current.setNext(currentHead);
			currentHead = current;
			originalHead.setNext(next);
			if (Objects.nonNull(previousHead))
				previousHead.setNext(currentHead);
			count--;
			if (Objects.isNull(originalHead.getNext())) {
				if (initial)
					head = currentHead;
				break;
			}
			if (count == 1) {
				if (initial) {
					head = currentHead;
					initial = false;
				}
				previousHead = originalHead;
				originalHead = originalHead.getNext();
				currentHead = originalHead;
				count = k;
			}
		}
		return head;
	}

	private <T> Node<T> reverse(Node<T> head) {
		Node<T> currentHead = head;
		while (Objects.nonNull(currentHead.getNext())) {
			Node<T> current = currentHead.getNext();
			Node<T> next = current.getNext();
			current.setNext(head);
			head = current;
			currentHead.setNext(next);
		}
		return head;
	}

	private <T> void nodeIterator(Node<T> rootNode) {
		Node<T> currentNode = rootNode;
		while (currentNode != null) {
			System.out.print(currentNode.getValue() + " ");
			currentNode = currentNode.getNext();
		}
	}

	private <T> void reverseAlternateNodes(Node<T> rootNode) {
		if (rootNode == null || rootNode.getNext() == null || rootNode.getNext().getNext() == null) {
			return;
		}
		Node<T> oddNode = rootNode;
		Node<T> evenNode = rootNode.getNext();
		Node<T> reverseRootNode = null;
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
