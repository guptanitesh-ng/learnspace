package com.concepts;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		new GenerateParentheses().allParentheses(4);
	}

	public List<String> allParentheses(int n) {
		List<String> allParentheses = new ArrayList<>();
		generate(allParentheses, "", "(", n, n);
		//allParentheses.forEach(e -> System.out.println(e));
		return allParentheses;
	}

	private void generate(List<String> allParentheses, String parentheses, String next, int n, int m) {

		if (next == "(")
			n--;
		if (next == ")")
			m--;

		parentheses = parentheses.concat(next);

		if (m == 0)
			allParentheses.add(parentheses);
		if (n > 0)
			generate(allParentheses,parentheses, "(", n, m);
		if (m > n)
			generate(allParentheses, parentheses, ")", n, m);
	}
}
