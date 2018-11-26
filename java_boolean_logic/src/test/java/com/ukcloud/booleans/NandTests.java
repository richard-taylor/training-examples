package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NandTests {

    @Test
    public void defaultConstructor() {
        final Nand nandGate = new Nand();

        nandGate.setInput(0, true);
        nandGate.setInput(1, false);

        assertTrue(nandGate.getOutput());
    }

    @Test
    public void customConstructor() {
        final Nand nandGate = new Nand(3);

        nandGate.setInput(0, true);
        nandGate.setInput(1, true);
        nandGate.setInput(2, true);

        assertFalse(nandGate.getOutput());
    }
}
