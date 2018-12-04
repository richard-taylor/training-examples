package com.ukcloud.booleans;

/**
 * A one-bit adder circuit with three inputs A, B, Cin and two outputs S, Cout.
 *
 * S is the "sum" of A and B and Cin (carry in)
 * Cout is the "carry out" bit.
 */
public class FullAdder extends Circuit {

    private final InputPin inputPinA;
    private final InputPin inputPinB;
    private final InputPin inputPinCin;
    private final OutputPin outputPinS;
    private final OutputPin outputPinCout;

    public FullAdder() {

        final HalfAdder adder1 = new HalfAdder();
        inputPinA = adder1.pinA();
        inputPinB = adder1.pinB();

        final HalfAdder adder2 = new HalfAdder();
        inputPinCin = adder2.pinA();
        outputPinS = adder2.pinS();

        final Or orGate = new Or();
        outputPinCout = orGate.outputPin();

        add(adder1);
        add(adder2);

        add(new Connection(adder1.pinS(), adder2.pinB()));
        add(new Connection(adder1.pinC(), orGate.inputPin(0)));
        add(new Connection(adder2.pinC(), orGate.inputPin(1)));
    }

    public InputPin pinA() {
        return inputPinA;
    }

    public InputPin pinB() {
        return inputPinB;
    }

    public InputPin pinCin() {
        return inputPinCin;
    }

    public OutputPin pinS() {
        return outputPinS;
    }

    public OutputPin pinCout() {
        return outputPinCout;
    }
}
