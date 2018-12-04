package com.ukcloud.booleans;

/**
 * A logic unit that copies a single input to multiple outputs.
 */
public class Buffer extends LogicUnit {

    public Buffer(int numberOfOutputs) {
        super(1, numberOfOutputs);
    }

    public void setInput(boolean value) {
        setInput(0, value);
    }

    public InputPin inputPin() {
        return inputPin(0);
    }

    @Override
    public boolean getOutput(int index) {
        if (index >= numberOfOutputs)
            throw new IndexOutOfBoundsException(String.format("Index %d must be less than %d.", index, numberOfOutputs));

        return getInput(0);
    }
}
