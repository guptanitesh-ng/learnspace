package com.training.spring.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class ShoppingCart {

	private List<Product> items;
	
	public void addItem(Product item) {
		if (null == items) {
			items = new ArrayList<Product>();
		}
		if (item.getQuantity() <= 0) {
			item.setQuantity(1L);
		}
		items.add(item);
	}

	public List<Product> getItems() {
		return items;
	}

	public double getAmount() {
		double amount = 0.0;
		for (Product product : items) {
			amount += product.getPrice();
		}
		return amount;				
	}	
	
}
