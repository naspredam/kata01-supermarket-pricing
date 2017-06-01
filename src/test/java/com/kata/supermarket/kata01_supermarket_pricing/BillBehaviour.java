package com.kata.supermarket.kata01_supermarket_pricing;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by naspredam on May 22, 2017
 */
public class BillBehaviour {

private Bill bill;
	
	private List<Item> basket;
	
	@Before
	public void setUp() {
		this.basket = new ArrayList<>();
		this.bill = new Bill(basket);
	}
	
	@Test
	public void returnSimplePrice_WhenBuyingSingleItem() {
		bill.buy(Item.BEAN);
		Assertions.assertThat(bill.generateBill()).as("We have an item on the basket").isEqualTo(0.65);
	}
	
	@Test
	public void applyDiscount_WhenBuyingThreeItem() {
		bill.buy(Item.BEAN);
		bill.buy(Item.BEAN);
		bill.buy(Item.BEAN);
		bill.buy(Item.BEAN);
		bill.buy(Item.BEAN);
		
		Assertions.assertThat(bill.generateBill()).as("We have an item on the basket").isEqualTo(2.30);
	}	

}
