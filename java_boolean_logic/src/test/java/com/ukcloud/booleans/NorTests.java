package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NorTests {

    @Test
    public void defaultConstructor() {
        final Nor norGate = new Nor();

        norGate.setInput(0, false);
        norGate.setInput(1, false);

        assertTrue(norGate.getOutput());
    }

    @Test
    public void customConstructor() {
        final Nor norGate = new Nor(3);

        norGate.setInput(0, false);
        norGate.setInput(1, true);
        norGate.setInput(2, false);

        assertFalse(norGate.getOutput());
    }
}
