package com.training.spring.shoppingcart;


public class Battery extends Product {

	private boolean rechargeable;
	
	public Battery(String name, double price, boolean rechargeable) {
		super(name, price);		
		this.rechargeable = rechargeable;
	}

	public boolean isRechargeable() {
		return rechargeable;
	}

	public void setRechargeable(boolean rechargeable) {
		this.rechargeable = rechargeable;
	}

	@Override
	public String toString() {
		return "Battery [rechargeable=" + rechargeable + ", getName()="
				+ getName() + ", getPrice()=" + getPrice() + "]";
	}

}
