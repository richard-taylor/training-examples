package com.ukcloud.booleans;

/**
 * A half-adder circuit with two inputs A, B and two outputs S, C.
 *
 * S is the "sum" of A and B = A XOR B
 * C is the "carry" bit = A AND B
 *
 * It is called a half-adder because it does not accept a carry from a previous bit;
 * a full one-bit adder requires two half-adders.
 */
public class HalfAdder extends Circuit {

    private final InputPin inputPinA;
    private final InputPin inputPinB;
    private final OutputPin outputPinS;
    private final OutputPin outputPinC;

    public HalfAdder() {

        // We need two buffers because each of the inputs connect to two gates,
        // so the input pins need to be "copied" twice.

        final Buffer A = new Buffer(2);
        inputPinA = A.inputPin();

        final Buffer B = new Buffer(2);
        inputPinB = B.inputPin();

        final Xor xorGate = new Xor();
        outputPinS = xorGate.outputPin();

        final And andGate = new And();
        outputPinC = andGate.outputPin();

        add(new Connection(A.outputPin(0), xorGate.inputPin(0)));
        add(new Connection(A.outputPin(1), andGate.inputPin(0)));
        add(new Connection(B.outputPin(0), xorGate.inputPin(1)));
        add(new Connection(B.outputPin(1), andGate.inputPin(1)));
    }

    public InputPin pinA() {
        return inputPinA;
    }

    public InputPin pinB() {
        return inputPinB;
    }

    public OutputPin pinS() {
        return outputPinS;
    }

    public OutputPin pinC() {
        return outputPinC;
    }
}
