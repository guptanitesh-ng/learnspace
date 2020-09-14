package concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Palindromenumber {
	boolean palindrome(int a) {
		int temp = a, sum = 0;
		while (a > 0) {
			int r;
			r = a % 10;
			sum = (sum * 10) + r;
			a = a / 10;
		}
		if (temp == sum) {
			System.out.println("its a Palindrome number");
			return true;
		} else {
			System.out.println("its not a Palindrome number");
			return false;
		}
	}

	public static void main(String args[]) {
		/*Palindromenumber p = new Palindromenumber();
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println(p.palindrome(a));*/

		List<String> list = new ArrayList<>();
		list.add("sad");
		
		PriorityQueue<String> names = new PriorityQueue<>();
		names.add("Prachi");
		names.add("Nitesh");
		
		System.out.println(names.remove());
		
		PriorityQueue<Book> books = new PriorityQueue<>();
		books.add(new Book("Prachi"));
		books.add(new Book("Nitesh"));
		
		
	}
}
