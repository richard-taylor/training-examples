package com.ukcloud.pricing;

public class Price {

    final long unitCost;

    public Price(long unitCost) {
        this.unitCost = unitCost;
    }

    public long forUnits(long units) {
        return unitCost * units;
    }
}
