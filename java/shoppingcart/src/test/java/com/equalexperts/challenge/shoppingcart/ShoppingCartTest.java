package com.equalexperts.challenge.shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ShoppingCartTest {

	@Test
	public void testWhenAddProductsTwoTypesThenTaxAmount() {
		ShoppingCart cart = new ShoppingCart();
		Product doveSoap = new Product("Dove Soap", 39.99);
		Product axeDeo = new Product("Axe Deo", 99.99);
		cart.addProduct(doveSoap,2);
		cart.addProduct(axeDeo,2);
		cart.applyTaxRate(12.5);
		assertEquals(35.00, cart.getTaxAmount(), 0);
	}

	@Test
	public void testWhenAddProductsTwoTypesThenTotalPrice() {
		ShoppingCart cart = new ShoppingCart();
		Product doveSoap = new Product("Dove Soap", 39.99);
		Product axeDeo = new Product("Axe Deo", 99.99);
		cart.addProduct(doveSoap,2);
		cart.addProduct(axeDeo,2);
		cart.applyTaxRate(12.5);
		assertEquals(314.96, cart.getTotalPrice(),0);
	}
	
	@Test
	public void testWhenAddProductsTwoTypesThenCountAndPrice() {
		ShoppingCart cart = new ShoppingCart();
		Product doveSoap = new Product("Dove Soap", 39.99);
		Product axeDeo = new Product("Axe Deo", 99.99);
		cart.addProduct(doveSoap,2);
		cart.addProduct(axeDeo,2);
		Map<Product, Integer> cartItems = cart.getCartItems();
		assertEquals(2, cartItems.get(doveSoap).intValue());
		assertEquals(2, cartItems.get(axeDeo).intValue());
	}	
	
	@Test
	public void testWhenAddProductsSameTypeThenProductCountAndUnitPrice() {
		ShoppingCart cart = new ShoppingCart();
		Product doveSoap = new Product("Dove Soap", 39.99);
		cart.addProduct(doveSoap,5);
		cart.addProduct(doveSoap,3);
		Map<Product, Integer> cartItems = cart.getCartItems();
		assertEquals(8, cartItems.get(doveSoap).intValue());
		assertTrue(cartItems.containsKey(doveSoap));
	}

	@Test
	public void testWhenAddProductsSameTypeThenTotalPrice() {
		ShoppingCart cart = new ShoppingCart();
		Product doveSoap = new Product("Dove Soap", 39.99);
		cart.addProduct(doveSoap,5);
		cart.addProduct(doveSoap,3);
		assertEquals(319.92, cart.getTotalPrice(),0);
	}

	@Test
	public void testWhenAddProductsThenProductCountAndUnitPrice() {
		ShoppingCart cart = new ShoppingCart();
		Product doveSoap = new Product("Dove Soap", 39.99);
		cart.addProduct(doveSoap,5);		
		Map<Product, Integer> cartItems = cart.getCartItems();
		assertEquals(5, cartItems.get(doveSoap).intValue());
		assertTrue(cartItems.containsKey(doveSoap));
	}

	@Test
	public void testWhenAddProductsThenNotMatchOtherProducts() {
		ShoppingCart cart = new ShoppingCart();
		Product doveSoap = new Product("Dove Soap", 39.99);
		cart.addProduct(doveSoap,5);		
		Map<Product, Integer> cartItems = cart.getCartItems();
		assertEquals(5, cartItems.get(doveSoap).intValue());
		Product anotherDoveSoap = new Product("Dove Soap", 49.99);
		assertTrue(!cartItems.containsKey(anotherDoveSoap));
	}
	
	@Test
	public void testWhenAddProductsThenTotalPrice() {
		ShoppingCart cart = new ShoppingCart();
		Product doveSoap = new Product("Dove Soap", 39.99);
		cart.addProduct(doveSoap,5);		
		assertEquals(199.95, cart.getTotalPrice(),0);		
	}
}
