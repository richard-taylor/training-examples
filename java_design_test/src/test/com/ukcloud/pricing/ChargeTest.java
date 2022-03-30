package com.ukcloud.pricing;

import com.ukcloud.storage.MockTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChargeTest {
    @Test
    public void canConstruct() {
        assertNotNull(new Charge("ABC", "123", 99, MockTime.at(1), MockTime.at(2)));
    }
}