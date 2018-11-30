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

    @Test
    public void settingAllInputs() {
        final Gate gate = new And(4);
        final boolean[] inputs = new boolean[] { true, false, false, true };

        gate.setInputs(inputs);

        assertTrue(gate.getInput(0));
        assertFalse(gate.getInput(1));
        assertFalse(gate.getInput(2));
        assertTrue(gate.getInput(3));
    }

    @Test
    public void gettingAllInputs() {
        final Gate gate = new And(4);
        final boolean[] inputs = new boolean[] { true, false, false, true };

        gate.setInputs(inputs);
        final boolean[] check = gate.getInputs();

        assertTrue(check[0]);
        assertFalse(check[1]);
        assertFalse(check[2]);
        assertTrue(check[3]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayTooLongIsNotOK() {
        final Gate gate = new And(4);
        final boolean[] inputs = new boolean[] { true, false, false, true, false, false, false, false };

        gate.setInputs(inputs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayTooShortIsNotOK() {
        final Gate gate = new And(4);
        final boolean[] inputs = new boolean[] { true, false, false };

        gate.setInputs(inputs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullAarrayIsNotOK() {
        final Gate gate = new And(4);
        gate.setInputs(null);
    }
}
