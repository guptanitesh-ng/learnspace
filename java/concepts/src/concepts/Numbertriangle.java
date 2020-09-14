package concepts;

import java.util.Scanner;

public class Numbertriangle {
	public void numbertriangle(int num) {

		for (int line = 1; line <= 6; line++) {
			int printNum =num;
			for (int a = 1; a <= line; a++) {
				System.out.print(printNum++  +"\t");
			}
		System.out.println();
		}
	}

	public static void main(String args[]) {
		Numbertriangle nt = new Numbertriangle();

		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		nt.numbertriangle(a);
	}

}
