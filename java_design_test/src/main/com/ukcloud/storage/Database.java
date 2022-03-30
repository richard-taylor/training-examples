package com.ukcloud.storage;

import com.ukcloud.pricing.Charge;
import com.ukcloud.pricing.Price;

import java.util.List;

public interface Database {

    void addCharge(Charge charge);
    List<Charge> getCharges(String customerName, Time periodStart, Time periodEnd);

    Price getPrice(String resourceType);

    Time getTime(String label);
    void setTime(String label, Time time);
}
