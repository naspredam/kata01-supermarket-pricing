package com.kata.supermarket.kata01_supermarket_pricing;

import java.util.Objects;

public class BasketItem {

    private final Item item;

    private final ItemQuantity amount;

    private BasketItem(Item item, ItemQuantity amount) {
        this.item = item;
        this.amount = amount;
    }

    public boolean isUnit() {
        return amount.isUnitOnly();
    }

    public double getPricePerUnit() {
        return item.getPricePerUnit();
    }

    public double getPricePerMass() {
        return item.getPricePerPound() * amount.getAmountMass() * amount.getMassUnit().getToPound();
    }

    public static BasketItem pickItem(Item item, ItemQuantity quantity) {
        return new BasketItem(item, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof BasketItem)) return false;
        final BasketItem other = (BasketItem)o;
        if (item != other.item) return false;
        if (!Objects.equals(amount, other.amount)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $item = this.item;
        final Object $amount = this.amount;
        result = result * PRIME + ($item == null ? 43 : $item.hashCode());
        result = result * PRIME + ($amount == null ? 43 : $amount.hashCode());
        return result;
    }

}
