package com.kata.supermarket.kata01_supermarket_pricing;

import java.util.Optional;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by naspredam on May 22, 2017
 */
public class BillShould {
	
	@Test
	public void buy_WhenBuyingSingleItem() {
		Basket basket = Basket.pick()
				.addItem(Item.BEAN)
				.stopAddingItems();

		Optional<Item> first = basket.getItems()
				.stream()
				.findFirst();
		assertThat(first).as("We have an item in the basket")
				.isPresent()
				.containsSame(Item.BEAN);
	}
	
	@Test
	public void returnPrice_WhenBuyingTwoItem() {
		Basket basket = Basket.pick()
				.addItem(Item.BEAN)
				.addItem(Item.BEAN)
				.stopAddingItems();

		double basketCost = Bill.of(basket).getCost();
		assertThat(basketCost).as("We have two item in the basket")
				.isEqualTo(1.30);
	}	
	
}
