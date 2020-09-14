package concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LargestNumberForGivenIntegerArray {

	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {
			int elementCount = s.nextInt();
			List<String> numbers = new ArrayList<String>();
			for (int n = 1; n <= elementCount; n++) {
				numbers.add((String.valueOf(s.nextInt())));
			}

			Collections.sort(numbers, new Comparator<String>() {

				@Override
				public int compare(String first, String second) {
					//String appendForward = first + second;
					//String appendReverse = second + first;
					StringBuilder appendForward = new StringBuilder(first).append(second);
					StringBuilder appendReverse = new StringBuilder(second).append(first);
					return appendForward.toString().compareTo(appendReverse.toString()) > 0 ? -1 : 1;
				}

			});

			for (String number : numbers) {
				System.out.print(number);
			}
		}
	}

}
