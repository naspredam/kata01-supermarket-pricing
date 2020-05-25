package com.kata.supermarket.kata01_supermarket_pricing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by naspredam on May 22, 2017
 */
public class BillBehaviour {
	
	@Test
	public void returnSimplePrice_WhenBuyingSingleItem() {
		Basket basket = Basket.pick()
				.addItemUnit(Item.BEAN)
				.stopAddingItems();
		double actual = Bill.of(basket).getCost();
		assertThat(actual).as("We have an item on the basket").isEqualTo(0.65);
	}
	
	@Test
	public void applyDiscount_WhenBuyingMoreThanThreeItem() {
		Basket basket = Basket.pick()
				.addItemUnit(Item.BEAN)
				.addItemUnit(Item.BEAN)
				.addItemUnit(Item.BEAN)
				.addItemUnit(Item.BEAN)
				.addItemUnit(Item.BEAN)
				.stopAddingItems();

		double actual = Bill.of(basket).getCost();
		assertThat(actual).as("We have three items on the basket").isEqualTo(2.60);
	}

	@Test
	public void applyConversionFromOunces_WhenBuyingMoreThanThreeItem() {
		Basket basket = Basket.pick()
				.addItemMass(Item.BEAN, 4, ItemMassUnit.OUNCE)
				.stopAddingItems();

		double actual = Bill.of(basket).getCost();
		assertThat(actual).as("We have three items on the basket").isEqualTo(0.50);
	}

}
