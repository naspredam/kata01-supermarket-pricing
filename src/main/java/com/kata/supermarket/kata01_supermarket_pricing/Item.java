package com.kata.supermarket.kata01_supermarket_pricing;

public enum Item {

	BEAN(0.65, 1.99);
	
	private final double pricePerUnit;

	private final double pricePerPound;

	Item(double pricePerUnit, double pricePerPound) {
		this.pricePerUnit = pricePerUnit;
		this.pricePerPound = pricePerPound;
	}
	
	public double getPricePerUnit() {
		return this.pricePerUnit;
	}

	public double getPricePerPound() {
		return this.pricePerPound;
	}

}
