package com.kata.supermarket.kata01_supermarket_pricing;

import java.util.Objects;

public class ItemQuantity {

    private final boolean unitOnly;

    private final double amountMass;

    private final ItemMassUnit massUnit;

    private ItemQuantity(boolean unitOnly, double amountMass, ItemMassUnit massUnit) {
        this.unitOnly = unitOnly;
        this.amountMass = amountMass;
        this.massUnit = massUnit;
    }

    public boolean isUnitOnly() {
        return unitOnly;
    }

    public double getAmountMass() {
        return amountMass;
    }

    public ItemMassUnit getMassUnit() {
        return massUnit;
    }

    public static ItemQuantity unit() {
        return new ItemQuantity(true, 0.0, null);
    }

    public static ItemQuantity mass(double amountMass, ItemMassUnit massUnit) {
        return new ItemQuantity(false, amountMass, massUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ItemQuantity)) return false;
        final ItemQuantity other = (ItemQuantity)o;
        if (unitOnly != other.unitOnly) return false;
        if (amountMass != other.amountMass) return false;
        if (!Objects.equals(massUnit, other.massUnit)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $item = this.unitOnly;
        final Object $amount = this.amountMass;
        final Object $massUnit = this.massUnit;
        result = result * PRIME + $item.hashCode();
        result = result * PRIME + $amount.hashCode();
        result = result * PRIME + ($massUnit == null ? 43 : $massUnit.hashCode());
        return result;
    }
}
