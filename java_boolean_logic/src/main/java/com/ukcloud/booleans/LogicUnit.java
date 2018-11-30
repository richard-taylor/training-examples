package com.ukcloud.booleans;

/**
 * Base class for logic units.
 *
 * There can be any positive number of boolean inputs and outputs.
 * A unit with zero inputs would be a generator of some kind.
 * A unit with zero outputs seems pretty useless... but who knows?
 */
public abstract class LogicUnit {

    final private boolean[] inputs;

    public LogicUnit(int numberOfInputs, int numberOfOutputs) {
        if (numberOfInputs < 0)
            throw new IllegalArgumentException(String.format("Fan-in of %d must be positive.", numberOfInputs));
        if (numberOfOutputs < 0)
            throw new IllegalArgumentException(String.format("Fan-out of %d must be positive.", numberOfOutputs));

        inputs = new boolean[numberOfInputs];
    }

    public void setInput(int index, boolean value) {
        inputs[index] = value;
    }

    public boolean getInput(int index) {
        return inputs[index];
    }

    public void setInputs(boolean[] inputs) {
        if (null == inputs)
            throw new IllegalArgumentException("Inputs array cannot be null");
        if (inputs.length != this.inputs.length)
            throw new IllegalArgumentException(
                    String.format("Input length of %d does not match fan-in of %d.", inputs.length, this.inputs.length));

        System.arraycopy(inputs, 0, this.inputs, 0, this.inputs.length);
    }

    public boolean[] getInputs() {
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
    public abstract boolean[] getOutputs();
}
