package com.ukcloud.reporting;

import com.ukcloud.pricing.Charge;
import com.ukcloud.storage.Time;

import java.util.List;

public interface Reporting {

    List<Charge> getCharges(String customerName, Time periodStart, Time periodEnd);
}
