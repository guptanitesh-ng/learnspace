package com.training.spring.shoppingcart;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ProductRanking {

	private Map<String, Long> productSaleMap;

	private Quarter quarter;

	public ProductRanking(Quarter quarter) {
		this.quarter = quarter;
		this.productSaleMap = new HashMap<String, Long>();
	}

	public void updateProductRank(Product product) {
		if (!productSaleMap.containsKey(product.getName())) {
			productSaleMap.put(product.getName(), 0L);
		}
		Long soldCount = productSaleMap.get(product.getName()) + product.getQuantity();
		productSaleMap.put(product.getName(), soldCount);
	}

	public void printRankings() {
		System.out
				.println("Rankings for the " + quarter.name() + " quarter : ");
		for (Entry<String, Long> entry : productSaleMap.entrySet()) {
			System.out.println("Product Name: " + entry.getKey()
					+ " Quantity Sold: " + entry.getValue());
		}
	}
}
