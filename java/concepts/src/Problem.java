import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<List<Integer>> twoSum(List<Integer> A, Integer n) {
		List<List<Integer>> pairs = new ArrayList<List<Integer>>();
		Set<Integer> keys = new HashSet<>();
		for (int a : A) {
			for (int b : A) {
				if (a+b == n) {
					if (keys.add(a) && keys.add(b)) {
						List<Integer> pair = new ArrayList<Integer>();
						pair.add(a);
						pair.add(b);
						pairs.add(pair);
					}
				}
			}
		}
		return pairs;
	}

}
