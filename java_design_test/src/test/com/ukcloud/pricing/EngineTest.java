package com.ukcloud.pricing;

import com.ukcloud.sources.MockResource;
import com.ukcloud.sources.MockSource;
import com.ukcloud.sources.PlatformException;
import com.ukcloud.storage.MockDb;
import com.ukcloud.storage.MockTime;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EngineTest {
    @Test
    public void singleUpdate() throws PlatformException {
        MockSource source = new MockSource(List.of(
                new MockResource("Disk-1", "ABC", "SSD-48000"),
                new MockResource("Disk-2", "ABC", "HDD-99445")
        ), 100);
        MockDb db = new MockDb();

        Engine engine = new Engine(source, db);
        engine.update();

        List<Charge> charges = engine.getCharges("ABC", MockTime.at(1), MockTime.at(2));
        assertEquals(2, charges.size());

        Charge charge1 = charges.get(0);
        assertEquals("ABC", charge1.getCustomerName());
        assertEquals("Disk-1", charge1.getResourceName());
        assertEquals(2000, charge1.getAmount());

        Charge charge2 = charges.get(1);
        assertEquals("ABC", charge2.getCustomerName());
        assertEquals("Disk-2", charge2.getResourceName());
        assertEquals(2000, charge2.getAmount());
    }
}
