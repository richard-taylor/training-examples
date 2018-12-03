package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class XorTests {

    @Test
    public void all() {
        final Xor xorGate = new Xor();

        xorGate.setInput(0, false);
        xorGate.setInput(1, false);
        assertFalse(xorGate.getOutput());

        xorGate.setInput(0, true);
        xorGate.setInput(1, false);
        assertTrue(xorGate.getOutput());

        xorGate.setInput(0, false);
        xorGate.setInput(1, true);
        assertTrue(xorGate.getOutput());

        xorGate.setInput(0, true);
        xorGate.setInput(1, true);
        assertFalse(xorGate.getOutput());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void onlyTwoInputs() {
        final Xor xorGate = new Xor();
        xorGate.setInput(2, true);
    }
}
