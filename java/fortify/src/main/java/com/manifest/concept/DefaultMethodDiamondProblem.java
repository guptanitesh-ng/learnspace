package com.manifest.concept;

interface NodeA {
	default void print() {
		System.out.println("Printing node A");
	}
}

interface NodeB {
	default void print() {
		System.out.println("Printing node B");
	}
}

public class DefaultMethodDiamondProblem implements NodeA, NodeB {

	@Override
	public void print() {
		NodeB.super.print();
	}
	
	public void triggerDiamondBehavior() {
		NodeA.super.print();
	}
}
