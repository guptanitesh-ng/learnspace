package com.concepts.string;

public class InternedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "Test";
		String s2 = new String("Test").intern();
		System.out.println(s1==s2);
	}

}
