package com.kata.supermarket.kata01_supermarket_pricing;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Item> items;

    public Basket(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public static BasketTaker pick() {
        return new BasketTaker();
    }

    public static class BasketTaker {

        private final List<Item> items;

        public BasketTaker() {
            this.items = new ArrayList<>();
        }

        public BasketTaker addItem(Item item) {
            items.add(item);
            return this;
        }

        public Basket stopAddingItems() {
            return new Basket(items);
        }

    }

}
