package com.ukcloud.booleans;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConnectionTests {

    @Test
    public void simple() {
        final Or orGate = new Or();
        final And andGate = new And();

        final Connection connection = new Connection(orGate.outputPin(), andGate.inputPin(1));

        orGate.setInput(0, true);
        orGate.setInput(1, true);

        andGate.setInput(0, true);
        // input 1 is the output of the OR gate

        // this connection should propagate a "true" from the OR gate to the AND gate.
        assertTrue(connection.propagate());
        assertTrue(connection.getState());

        assertTrue(andGate.getOutput());
    }
}
