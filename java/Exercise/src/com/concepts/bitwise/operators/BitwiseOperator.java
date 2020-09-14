package com.concepts.bitwise.operators;

public class BitwiseOperator {

	public static void main(String[] args) {
		Integer hash = 1350;		
		System.out.println(hash.toBinaryString(hash));
		Integer output = hash | 15;
		System.out.println(output + "\n" + output.toBinaryString(output));
		
		output = hash & 15;
		System.out.println(output + "\n" + output.toBinaryString(output));
		
		output = hash ^ 15;
		System.out.println(output + "\n" + output.toBinaryString(output));
	}

}
