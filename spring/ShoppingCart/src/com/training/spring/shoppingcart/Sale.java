package com.training.spring.shoppingcart;

import java.util.Calendar;
import java.util.Date;

public class Sale {

	private ShoppingCart cart;
    
	private Date time;
    
	public Sale(ShoppingCart cart) {		
		this.cart = cart;
		this.time = Calendar.getInstance().getTime();
	}	

	public Date getTime() {
		return time;
	}

	public ShoppingCart getCart() {
		return cart;
	}	
	
}
