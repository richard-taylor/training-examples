package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AndTests {

    @Test
    public void defaultConstructor() {
        final And andGate = new And();

        andGate.setInput(0, true);
        andGate.setInput(1, true);

        assertTrue(andGate.getOutput());
    }

    @Test
    public void customConstructor() {
        final And andGate = new And(3);

        andGate.setInput(0, true);
        andGate.setInput(1, true);
        andGate.setInput(2, false);

        assertFalse(andGate.getOutput());
    }
}
