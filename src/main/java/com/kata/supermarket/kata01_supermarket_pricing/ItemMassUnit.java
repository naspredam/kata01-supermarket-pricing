package com.kata.supermarket.kata01_supermarket_pricing;

public enum ItemMassUnit {

    POUND(1.0),

    OUNCE(0.0625);

    private double toPound;

    ItemMassUnit(double toPound) {
        this.toPound = toPound;
    }

    public double getToPound() {
        return toPound;
    }
}
