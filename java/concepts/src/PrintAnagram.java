import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PrintAnagram {

	public static void main(String[] arr) {

		Map<Integer, Map<String, Set<String>>> map = new HashMap<>();
		for (String word : arr) {
			int length = word.length();
			Map<String, Set<String>> map2 = map.get(length);
			char[] wordCharArray = word.toCharArray();
			Arrays.sort(wordCharArray);
			if (map2 == null) {
				Map<String, Set<String>> anagramMap = new HashMap<>();
				Set<String> anagrams = new HashSet<>();
				anagrams.add(word);
				anagramMap.put(Arrays.toString(wordCharArray), anagrams);
				map.put(length, anagramMap);
			} else {
				Set<String> anagrams = map2.get(Arrays.toString(wordCharArray));
				if (anagrams == null) {
					Set<String> set = new HashSet<>();
					set.add(word);
					map2.put(Arrays.toString(wordCharArray), set);
				}
			}		
			
		}
		
		for (Entry<Integer, Map<String, Set<String>>> entry : map.entrySet()) {
			Map<String, Set<String>> value = entry.getValue();
			for (Entry<String, Set<String>> entry1 : value.entrySet()) {
				System.out.println(entry1.getValue().toString());
			}
		}

	}

}
