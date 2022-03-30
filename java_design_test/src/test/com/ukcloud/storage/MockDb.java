package com.ukcloud.storage;

import com.ukcloud.pricing.Charge;
import com.ukcloud.pricing.Price;

import java.util.ArrayList;
import java.util.List;

public class MockDb implements Database {

    final List<Charge> charges = new ArrayList<>();

    @Override
    public void addCharge(Charge charge) {
        charges.add(charge);
    }

    @Override
    public List<Charge> getCharges(String customerName, Time periodStart, Time periodEnd) {
        return charges;
    }

    @Override
    public Price getPrice(String resourceType) {
        return new Price(20);
    }

    @Override
    public Time getTime(String label) {
        return null;
    }

    @Override
    public void setTime(String label, Time time) {

    }
}
