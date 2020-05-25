package com.kata.supermarket.kata01_supermarket_pricing;

import java.util.Optional;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by naspredam on May 22, 2017
 */
public class BillShould {
	
	@Test
	public void buyUnit_WhenBuyingSingleItem() {
		Basket basket = Basket.pick()
				.addItemUnit(Item.BEAN)
				.stopAddingItems();

		Optional<BasketItem> first = basket.getItems()
				.stream()
				.findFirst();
		assertThat(first).as("We have an item in the basket").isPresent();
		assertThat(first.get()).as("We have an item in the basket")
				.isEqualTo(BasketItem.pickItem(Item.BEAN, ItemQuantity.unit()));
	}

	@Test
	public void buyWithMass_WhenBuyingItemWithMass() {
		Basket basket = Basket.pick()
				.addItemMass(Item.BEAN, 3, ItemMassUnit.POUND)
				.stopAddingItems();

		Optional<BasketItem> first = basket.getItems()
				.stream()
				.findFirst();
		assertThat(first).as("We have an item in the basket").isPresent();
		assertThat(first.get()).as("We have an item in the basket")
				.isEqualTo(BasketItem.pickItem(Item.BEAN, ItemQuantity.mass(3, ItemMassUnit.POUND)));
	}
	
	@Test
	public void returnPrice_WhenBuyingTwoItem() {
		Basket basket = Basket.pick()
				.addItemUnit(Item.BEAN)
				.addItemUnit(Item.BEAN)
				.stopAddingItems();

		double basketCost = Bill.of(basket).getCost();
		assertThat(basketCost).as("We have two item in the basket")
				.isEqualTo(1.30);
	}

	@Test
	public void returnPrice_WhenBuyingItemWithMass() {
		Basket basket = Basket.pick()
				.addItemMass(Item.BEAN, 1, ItemMassUnit.POUND)
				.stopAddingItems();

		double basketCost = Bill.of(basket).getCost();
		assertThat(basketCost).as("We have two item in the basket")
				.isEqualTo(1.99);
	}
}
