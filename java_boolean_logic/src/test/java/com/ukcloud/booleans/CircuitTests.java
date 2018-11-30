package com.ukcloud.booleans;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CircuitTests {

    @Test
    public void threeGates() {
        final Or orGateA = new Or();
        final Or orGateB = new Or();

        final And andGate = new And();

        final Circuit circuit = new Circuit();
        circuit.add(new Connection(orGateA.outputPin(), andGate.inputPin(0)));
        circuit.add(new Connection(orGateB.outputPin(), andGate.inputPin(1)));

        orGateA.setInput(0, true);
        orGateA.setInput(1, false);

        orGateB.setInput(0, false);
        orGateB.setInput(1, true);

        circuit.propagate();

        assertTrue(andGate.getOutput());
    }

    @Test
    public void orderDependency() {
        final Not gateA = new Not();
        final Not gateB = new Not();
        final Not gateC = new Not();
        final Not gateD = new Not();
        final Not gateE = new Not();

        // deliberately add the connections back-to-front.

        final Circuit circuit = new Circuit();
        circuit.add(new Connection(gateD.outputPin(), gateE.inputPin(0)));
        circuit.add(new Connection(gateC.outputPin(), gateD.inputPin(0)));
        circuit.add(new Connection(gateB.outputPin(), gateC.inputPin(0)));
        circuit.add(new Connection(gateA.outputPin(), gateB.inputPin(0)));

        gateA.setInput(true);
        assertTrue(circuit.propagate() > 0);    // we do not know exactly how many loops to expect.

        assertFalse(gateA.getOutput());
        assertTrue(gateB.getOutput());
        assertFalse(gateC.getOutput());
        assertTrue(gateD.getOutput());
        assertFalse(gateE.getOutput());
    }

    @Test(expected = NoSteadyStateException.class)
    public void infiniteLoop() {
        final Not gate = new Not();
        final Circuit circuit = new Circuit();

        circuit.add(new Connection(gate.outputPin(), gate.inputPin(0)));    // connect the output back to the input
        circuit.propagate();                                                // no steady state. oscillates forever.
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void customisedIterationLimit() throws Exception {
        expectedEx.expect(NoSteadyStateException.class);
        expectedEx.expectMessage("After 123 iterations.");

        final Not gate = new Not();
        final Circuit circuit = new Circuit(123);

        circuit.add(new Connection(gate.outputPin(), gate.inputPin(0)));    // connect the output back to the input
        circuit.propagate();                                                // no steady state. oscillates forever.
    }
}
