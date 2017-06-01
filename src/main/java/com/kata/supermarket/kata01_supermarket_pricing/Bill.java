package com.kata.supermarket.kata01_supermarket_pricing;

import java.util.List;

public class Bill {
	
	private List<Item> basket;
	
	public Bill(List<Item> basket) {
		this.basket = basket;
	}

	public double generateBill() {
		return this.basket.stream()
				.mapToDouble(Item::getPrice)
				.sum();
	}

	public void buy(Item bean) {
		this.basket.add(bean);
	}
}

