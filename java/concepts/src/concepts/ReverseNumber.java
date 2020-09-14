package concepts;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {
			int value = s.nextInt();
			int reverse = 0;
			while (value > 0) {
				reverse *= 10;
				reverse += value % 10;
				value /= 10;
			}
			System.out.println(reverse);
		}
	}

	private static Object readInput() {
		Scanner s = new Scanner(System.in);
		int elementCount = s.nextInt();
		// int[] q = new int[elementCount +1];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int n = 1; n <= elementCount; n++) {
			queue.add(s.nextInt());
		}
		int operation = s.nextInt();
		if (operation == 1) {
			queue.add(s.nextInt());
		} else if (operation == 0) {
			queue.remove();
		}
		return null;
	}
}
