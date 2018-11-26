package com.ukcloud.booleans;

/**
 * Base class for logic gates.
 *
 * There can be any number of inputs and a single output.
 */
public abstract class Gate {

    final private boolean[] inputs;

    public Gate(int numberOfInputs) {
        if (numberOfInputs < 1)
            throw new IllegalArgumentException(String.format("Gate fan-in of %d must be at least 1.", numberOfInputs));

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
                    String.format("Inputs array length of %d does not match gate fan-in of %d.", inputs.length, this.inputs.length));

        System.arraycopy(inputs, 0, this.inputs, 0, this.inputs.length);
    }

    public boolean[] getInputs() {
        return inputs;
    }

    public abstract boolean getOutput();
}
