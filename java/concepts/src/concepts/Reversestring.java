package concepts;
import java.util.Arrays;
import java.util.Scanner;

public class Reversestring {
	String reverse(String input) {
		int left, right = 0;

		char[] temp = input.toCharArray();
		right = temp.length - 1;
		for (left = 0; left <= right; left++, right--) {
			char t=temp[left]; 
			temp[left] = temp[right];
			temp[right]=t;

		}
		return new String(temp);

	}

	public static void main(String args[]) {
		Reversestring rev = new Reversestring();
		Scanner s = new Scanner(System.in);
		System.out.println(rev.reverse(s.nextLine()));

	}
}