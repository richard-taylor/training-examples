package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NotTests {

    @Test
    public void simple() {
        final Not notGate = new Not();

        notGate.setInput(true);
        assertFalse(notGate.getOutput());

        notGate.setInput(false);
        assertTrue(notGate.getOutput());
    }
}
