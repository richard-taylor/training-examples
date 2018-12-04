package com.ukcloud.booleans;

/**
 * Base class for logic units.
 *
 * There can be any positive number of boolean inputs and outputs.
 * A unit with zero inputs would be a generator of some kind.
 * A unit with zero outputs seems pretty useless... but who knows?
 */
public abstract class LogicUnit {

    private final boolean[] inputs;
    protected final int numberOfInputs;
    protected final int numberOfOutputs;

    public LogicUnit(int numberOfInputs, int numberOfOutputs) {
        if (numberOfInputs < 0)
            throw new IllegalArgumentException(String.format("Fan-in of %d must be positive.", numberOfInputs));
        if (numberOfOutputs < 0)
            throw new IllegalArgumentException(String.format("Fan-out of %d must be positive.", numberOfOutputs));

        inputs = new boolean[numberOfInputs];
        this.numberOfInputs = numberOfInputs;
        this.numberOfOutputs = numberOfOutputs;
    }

    public void setInput(int index, boolean value) {
        inputs[index] = value;
    }

    public boolean getInput(int index) {
        return inputs[index];
    }

    protected boolean[] getInputs() {
        return inputs;
    }

    // Convenience method to construct an input pin connected to this unit.
    public InputPin inputPin(int index) {
        return new InputPin(this, index);
    }

    // Convenience method to construct an output pin connected to this unit.
    public OutputPin outputPin(int index) {
        return new OutputPin(this, index);
    }

    public abstract boolean getOutput(int index);
}
