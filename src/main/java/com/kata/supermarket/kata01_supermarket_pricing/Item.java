package com.kata.supermarket.kata01_supermarket_pricing;

public enum Item {

	BEAN(0.65);
	
	private double simplePrice;
	
	private Item(double price) {
		this.simplePrice = price;
	}
	
	public double getPrice() {
		return this.simplePrice;
	}
	
}
