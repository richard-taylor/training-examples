package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrTests {

    @Test
    public void defaultConstructor() {
        final Or orGate = new Or();

        orGate.setInput(0, true);
        orGate.setInput(1, false);

        assertTrue(orGate.getOutput());
    }

    @Test
    public void customConstructor() {
        final Or orGate = new Or(3);

        orGate.setInput(0, false);
        orGate.setInput(1, false);
        orGate.setInput(2, false);

        assertFalse(orGate.getOutput());
    }
}
