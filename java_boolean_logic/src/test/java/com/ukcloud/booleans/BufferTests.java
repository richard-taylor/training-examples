package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.*;

public class BufferTests {

    @Test
    public void singleOutput() {
        final Buffer buffer = new Buffer(1);

        buffer.setInput(true);
        assertTrue(buffer.getOutput(0));

        buffer.setInput(false);
        assertFalse(buffer.getOutput(0));
    }

    @Test
    public void multipleOutputs() {
        final Buffer buffer = new Buffer(3);

        buffer.setInput(true);
        assertTrue(buffer.getOutput(0));
        assertTrue(buffer.getOutput(1));
        assertTrue(buffer.getOutput(2));

        buffer.setInput(false);
        assertFalse(buffer.getOutput(0));
        assertFalse(buffer.getOutput(1));
        assertFalse(buffer.getOutput(2));
    }
}
