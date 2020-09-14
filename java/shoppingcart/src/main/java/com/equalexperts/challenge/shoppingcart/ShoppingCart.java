package com.equalexperts.challenge.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart {

	private Map<Product, Integer> cartItems = new LinkedHashMap<>();
	private double taxRate;

	/**
	 * Returns the current cart items.
	 * @return cart items.
	 */
	public Map<Product, Integer> getCartItems() {
		return cartItems;
	}

	/**
	 * Add given product to cart
	 * 
	 * @param product
	 *            the given product
	 * @param quantity
	 *            the units of the given product to be added
	 */
	public void addProduct(Product product, int quantity) {
		if (cartItems.get(product) == null) {
			cartItems.put(product, quantity);
		} else {
			int existingQuantity = cartItems.get(product);
			cartItems.put(product, existingQuantity + quantity);
		}
	}

	/**
	 * Compute total price of the cart based on the current composition
	 */
	public double getTotalPrice() {
		double totalPrice = 0;
		for (Entry<Product, Integer> entry : cartItems.entrySet()) {
			double totalProductPrice = entry.getKey().getUnitPrice() * entry.getValue();
			totalPrice += totalProductPrice + (totalProductPrice * taxRate / 100);
		}
		return BigDecimal.valueOf(totalPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	/**
	 * Compute the tax for the current cart items.
	 * 
	 * @return the total value of tax.
	 */
	public double getTaxAmount() {
		double taxAmount = 0;
		for (Entry<Product, Integer> entry : cartItems.entrySet()) {
			taxAmount += entry.getKey().getUnitPrice() * entry.getValue() * taxRate / 100;
		}
		return BigDecimal.valueOf(taxAmount).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	/**
	 * Set the tax rate
	 * @param taxRate tax rate value to be set.
	 */
	public void applyTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

}
