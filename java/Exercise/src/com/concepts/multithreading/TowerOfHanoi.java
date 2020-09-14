package com.concepts.multithreading;

import java.util.Stack;

public class TowerOfHanoi {

	static int moveCount = 0;
	public static void main(String[] args) {		
		int diskCount = 5;
		Stack<Integer> source = new Stack<Integer>();
		Stack<Integer> auxillary = new Stack<Integer>();
		Stack<Integer> target = new Stack<Integer>();
		for (int j = diskCount; j >= 1; j--) {
			source.push(j);
		}
		move(diskCount, source, auxillary, target);
	}

	private static void move(int diskCount, Stack<Integer> source, Stack<Integer> target, Stack<Integer> auxillary) {
		if (diskCount > 0) {
			move(diskCount - 1, source, auxillary, target);
			target.push(source.pop());
			printTower(source, auxillary, target);
			move(diskCount - 1, auxillary, target, source);
		}
	}

	private static void printTower(Stack<Integer> source, Stack<Integer> auxillary, Stack<Integer> target) {
		System.out.println(++moveCount + ": " + source + "\t" + auxillary + "\t" + target);
	}

}
