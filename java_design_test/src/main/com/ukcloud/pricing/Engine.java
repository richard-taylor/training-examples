package com.ukcloud.pricing;

import com.ukcloud.reporting.Reporting;
import com.ukcloud.sources.CloudResource;
import com.ukcloud.sources.CloudSource;
import com.ukcloud.sources.PlatformException;
import com.ukcloud.storage.Database;
import com.ukcloud.storage.Time;

import java.util.List;

/**
 * A pricing engine is instantiated by the application manager to
 * calculate the usage costs of all the active resources on the
 * given Cloud Platform. It must implement the Reporting interface.
 */
public class Engine implements Reporting {

    private final CloudSource platform;
    private final Database db;

    public Engine(CloudSource platform, Database db) {
        this.platform = platform;
        this.db = db;
    }

    public void update() throws PlatformException {

        Time last = db.getTime("last-pricing-run");
        Time now = db.getTime("now");

        List<CloudResource> resources = platform.getResources();

        for (CloudResource resource : resources) {
            long usage = platform.getUsage(resource, last, now);
            Price cost = db.getPrice(resource.getType());

            long charge = cost.forUnits(usage);
            db.addCharge(new Charge(resource.getOwner(), resource.getName(), charge, last, now));
        }
        db.setTime("last-pricing-run", now);
    }

    @Override
    public List<Charge> getCharges(String customerName, Time periodStart, Time periodEnd) {
        return db.getCharges(customerName, periodStart, periodEnd);
    }
}
