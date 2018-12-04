package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HalfAdderTests {

    @Test
    public void all() {
        final HalfAdder halfAdder = new HalfAdder();

        halfAdder.pinA().setInput(false);
        halfAdder.pinB().setInput(false);
        halfAdder.propagate();
        assertFalse(halfAdder.pinS().getOutput());
        assertFalse(halfAdder.pinC().getOutput());

        halfAdder.pinA().setInput(true);
        halfAdder.pinB().setInput(false);
        halfAdder.propagate();
        assertTrue(halfAdder.pinS().getOutput());
        assertFalse(halfAdder.pinC().getOutput());

        halfAdder.pinA().setInput(false);
        halfAdder.pinB().setInput(true);
        halfAdder.propagate();
        assertTrue(halfAdder.pinS().getOutput());
        assertFalse(halfAdder.pinC().getOutput());

        halfAdder.pinA().setInput(true);
        halfAdder.pinB().setInput(true);
        halfAdder.propagate();
        assertFalse(halfAdder.pinS().getOutput());
        assertTrue(halfAdder.pinC().getOutput());
    }
}
