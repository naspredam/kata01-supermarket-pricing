package com.kata.supermarket.kata01_supermarket_pricing;

import java.util.List;
import java.util.stream.IntStream;

public class Bill {
	
	private final Basket basket;
	
	private Bill(Basket basket) {
		this.basket = basket;
	}

	public static Bill of(Basket basket) {
		return new Bill(basket);
	}

	public double getCost() {
		List<Item> items = basket.getItems();
		return IntStream.range(0, items.size())
				.mapToDouble(idx -> applyDiscount(idx) ? 0.0 : items.get(idx).getPrice())
				.sum();
	}

	private boolean applyDiscount(int idx) {
		return idx > 0 && idx % 3 == 0;
	}
}

