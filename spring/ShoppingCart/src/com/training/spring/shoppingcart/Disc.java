package com.training.spring.shoppingcart;

public class Disc extends Product {

	private boolean rewritable;
	
	public Disc(String name, double price, boolean rewritable) {
		super(name, price);		
		this.rewritable = rewritable;
	}

	public boolean isRewritable() {
		return rewritable;
	}

	public void setRewritable(boolean rewritable) {
		this.rewritable = rewritable;
	}

	@Override
	public String toString() {
		return "Disc [rewritable=" + rewritable + ", getName()=" + getName()
				+ ", getPrice()=" + getPrice() + "]";
	}	

}
