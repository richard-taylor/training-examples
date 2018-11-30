package com.ukcloud.booleans;

/**
 * An input pin is a specific input to a logic unit.
 */
public class InputPin extends Pin {

    public InputPin(final LogicUnit unit, final int index) {
        super(unit, index);
    }

    public void setInput(boolean value) {
        unit.setInput(index, value);
    }
}
