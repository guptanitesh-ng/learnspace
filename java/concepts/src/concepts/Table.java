package concepts;

import java.util.Scanner;

public class Table {

	public static void main(String args[]) {
		System.out.println("enter the value");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		for (int c = 1; c <= 10; c++) {
			System.out.println(n + "*" + c + "=" + c * n);
		}

	}
}