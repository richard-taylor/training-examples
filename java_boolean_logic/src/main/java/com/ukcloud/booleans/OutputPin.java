package com.ukcloud.booleans;

/**
 * An output pin is a specific output of a logic unit.
 */
public class OutputPin extends Pin {

    public OutputPin(final LogicUnit unit, final int index) {
        super(unit, index);
    }

    public boolean getOutput() {
        return unit.getOutput(index);
    }
}