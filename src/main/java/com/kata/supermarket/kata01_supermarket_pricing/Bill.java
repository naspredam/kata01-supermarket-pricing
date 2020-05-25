package com.kata.supermarket.kata01_supermarket_pricing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Predicate.not;

public class Bill {
	
	private final Basket basket;
	
	private Bill(Basket basket) {
		this.basket = basket;
	}

	public static Bill of(Basket basket) {
		return new Bill(basket);
	}

	public double getCost() {
		List<BasketItem> items = basket.getItems();
		double costPerUnits = getCostPerUnits(items);
		double costPerMass = getCostPerMass(items);
		return Math.round(costPerUnits + costPerMass * 100.0) / 100.0;
	}

	private double getCostPerUnits(List<BasketItem> items) {
		List<BasketItem> itemUnits = items.stream()
				.filter(BasketItem::isUnit)
				.collect(Collectors.toList());
		return IntStream.range(0, itemUnits.size())
				.mapToDouble(idx -> applyDiscount(idx) ? 0.0 : items.get(idx).getPricePerUnit())
				.sum();
	}

	private double getCostPerMass(List<BasketItem> items) {
		return items.stream()
				.filter(not(BasketItem::isUnit))
				.mapToDouble(BasketItem::getPricePerMass)
				.sum();
	}

	private boolean applyDiscount(int idx) {
		return idx > 0 && idx % 3 == 0;
	}
}

