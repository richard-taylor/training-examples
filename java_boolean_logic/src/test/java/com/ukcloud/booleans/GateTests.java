package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GateTests {

    @Test
    public void singleInputOK() {
        final Gate gate = new And(1);
        gate.setInput(0, true);
        assertTrue(gate.getInput(0));
        gate.setInput(0, false);
        assertFalse(gate.getInput(0));
    }

    @Test
    public void zeroInputsIsOK() {
        final Gate gate = new True();
        assertTrue(gate.getOutput());
    }

    @Test
    public void inputsDefaultToFalse() {
        final Gate gate = new And(4);
        assertFalse(gate.getInput(0));
        assertFalse(gate.getInput(1));
        assertFalse(gate.getInput(2));
        assertFalse(gate.getInput(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfRange() {
        final Gate gate = new And(1);
        gate.setInput(1, true);
    }
}
