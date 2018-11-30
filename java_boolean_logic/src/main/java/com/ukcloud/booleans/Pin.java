package com.ukcloud.booleans;

/**
 * A pin is a specific input or output to a logic unit.
 */
public class Pin {

    public final LogicUnit unit;
    public final int index;

    public Pin(final LogicUnit unit, final int index) {
        this.unit = unit;
        this.index = index;
    }
}
