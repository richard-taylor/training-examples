package com.ukcloud.booleans;

/**
 * Base class for logic gates.
 *
 * A gate is a specialisation of a logic unit which has exactly one boolean output.
 */
public abstract class Gate extends LogicUnit {

    public Gate(int numberOfInputs) {
        super(numberOfInputs, 1);
    }

    public abstract boolean getOutput();

    public OutputPin outputPin() {
        return outputPin(0);
    }

    @Override
    public boolean getOutput(int index) {
        if (index != 0)
            throw new IndexOutOfBoundsException(String.format("Gate output index %d must be 0.", index));

        return getOutput();
    }
}
