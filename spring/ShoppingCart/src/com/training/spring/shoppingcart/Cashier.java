package com.training.spring.shoppingcart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Cashier {	
	
	@Value(value="${cashier.path}")
	private String path;
	
	@Autowired
	private RankingManager rankingManager;
	
	public void doCheckout(ShoppingCart shoppingCart) {
		processOrder(shoppingCart);
		Sale sale = new Sale(shoppingCart);
		rankingManager.updateRanking(sale);
	}

	public void setPath(String path) {
		this.path = path;
	}	

	private void processOrder(ShoppingCart shoppingCart) {
		File checkoutActionLog = new File(path, "order.txt");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(checkoutActionLog);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println(shoppingCart.getItems());
		writer.println("Total Amount :" + shoppingCart.getAmount());
		writer.close();
	}

}
