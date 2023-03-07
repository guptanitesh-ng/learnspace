package com.manifest.concept.generics.thc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TypeSafeHeterogeneousContainerTest {

	private Container container = new Container();
	
	@Test
	public void testForSameKeyType() {
		PropertyKey<String> propOne = new PropertyKey<String>(String.class, "One");
		PropertyKey<String> propTwo = new PropertyKey<String>(String.class, "Two");
		container.setProperty(propOne, "Value one");
		container.setProperty(propTwo, "Value two");
		
		assertEquals("Value one", container.getProperty(propOne));
	}
}
