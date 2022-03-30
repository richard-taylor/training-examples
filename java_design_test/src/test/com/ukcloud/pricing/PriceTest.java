package com.ukcloud.pricing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    @Test
    void canConstruct() {
        assertNotNull(new Price(42));
    }
}