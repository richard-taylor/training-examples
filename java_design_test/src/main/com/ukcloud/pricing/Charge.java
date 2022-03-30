package com.ukcloud.pricing;

import com.ukcloud.storage.Time;

public class Charge {

    final String customerName;
    final String resourceName;
    final long charge;
    final Time periodStart;
    final Time periodEnd;

    public Charge(String customerName, String resourceName, long charge, Time periodStart, Time periodEnd) {
        this.customerName = customerName;
        this.resourceName = resourceName;
        this.charge = charge;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

    public String getCustomerName() { return customerName; }
    public String getResourceName() { return resourceName; }
    public long getAmount() { return charge; }
    public Time getPeriodStart() { return periodStart; }
    public Time getPeriodEnd() { return periodEnd; }
}
