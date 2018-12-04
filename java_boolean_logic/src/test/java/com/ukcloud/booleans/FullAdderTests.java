package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FullAdderTests {

    @Test
    public void all() {
        final FullAdder adder = new FullAdder();

        // Cin = false (effectively the same as a half-adder)

        adder.pinA().setInput(false);
        adder.pinB().setInput(false);
        adder.pinCin().setInput(false);
        adder.propagate();
        assertFalse(adder.pinS().getOutput());
        assertFalse(adder.pinCout().getOutput());

        adder.pinA().setInput(true);
        adder.pinB().setInput(false);
        adder.pinCin().setInput(false);
        adder.propagate();
        assertTrue(adder.pinS().getOutput());
        assertFalse(adder.pinCout().getOutput());

        adder.pinA().setInput(false);
        adder.pinB().setInput(true);
        adder.pinCin().setInput(false);
        adder.propagate();
        assertTrue(adder.pinS().getOutput());
        assertFalse(adder.pinCout().getOutput());

        adder.pinA().setInput(true);
        adder.pinB().setInput(true);
        adder.pinCin().setInput(false);
        adder.propagate();
        assertFalse(adder.pinS().getOutput());
        assertTrue(adder.pinCout().getOutput());

        // Cin = true

        adder.pinA().setInput(false);
        adder.pinB().setInput(false);
        adder.pinCin().setInput(true);
        adder.propagate();
        assertTrue(adder.pinS().getOutput());
        assertFalse(adder.pinCout().getOutput());

        adder.pinA().setInput(true);
        adder.pinB().setInput(false);
        adder.pinCin().setInput(true);
        adder.propagate();
        assertFalse(adder.pinS().getOutput());
        assertTrue(adder.pinCout().getOutput());

        adder.pinA().setInput(false);
        adder.pinB().setInput(true);
        adder.pinCin().setInput(true);
        adder.propagate();
        assertFalse(adder.pinS().getOutput());
        assertTrue(adder.pinCout().getOutput());

        adder.pinA().setInput(true);
        adder.pinB().setInput(true);
        adder.pinCin().setInput(true);
        adder.propagate();
        assertTrue(adder.pinS().getOutput());
        assertTrue(adder.pinCout().getOutput());
    }
}
