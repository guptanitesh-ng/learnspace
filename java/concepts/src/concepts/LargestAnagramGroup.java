package concepts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class LargestAnagramGroup {

	public static void main(String[] args) {
		Map<String, Integer> anagramMap = new HashMap<String, Integer>();
		Scanner s = new Scanner(System.in);
		int elementCount = Integer.valueOf(s.nextLine());
		for (int n = 1; n <= elementCount; n++) {
			String input = s.nextLine();
			char[] inputChars = input.toCharArray();
			Arrays.sort(inputChars);
			String key = String.valueOf(inputChars);
			if (anagramMap.get(key) == null) {
				anagramMap.put(key, 1);
			} else {
				int value = anagramMap.get(key) + 1;
				anagramMap.put(key, value);
			}
		}
		int max = -1;
		for (Entry<String, Integer> entry : anagramMap.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
			}
		}
		System.out.println(max);
	}

}
