package com.kata.supermarket.kata01_supermarket_pricing;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<BasketItem> items;

    public Basket(List<BasketItem> items) {
        this.items = items;
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public static BasketTaker pick() {
        return new BasketTaker();
    }

    public static class BasketTaker {

        private final List<BasketItem> items;

        public BasketTaker() {
            this.items = new ArrayList<>();
        }

        public BasketTaker addItemUnit(Item item) {
            items.add(BasketItem.pickItem(item, ItemQuantity.unit()));
            return this;
        }

        public BasketTaker addItemMass(Item item, double amountMass, ItemMassUnit massUnit) {
            ItemQuantity mass = ItemQuantity.mass(amountMass, massUnit);
            items.add(BasketItem.pickItem(item, mass));
            return this;
        }

        public Basket stopAddingItems() {
            return new Basket(items);
        }

    }

}
