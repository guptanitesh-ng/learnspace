package com.training.spring.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Customer {

	@Autowired
	private Cashier cashier;
	
	@Autowired
	private ShoppingCart cart;
	
	private String customerId;
	
	private String name;
	
	private String address;

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String checkout() {
		cashier.doCheckout(cart);
		return "Order placed successfully";
	}	

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
}
