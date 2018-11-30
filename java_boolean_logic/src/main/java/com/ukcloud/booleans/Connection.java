package com.ukcloud.booleans;

/**
 * A connection joins a specific output of one logic unit to a specific input of
 * another logic unit.
 */
public class Connection {

    private final OutputPin sourcePin;
    private final InputPin sinkPin;

    private boolean state;

    public Connection(final OutputPin sourcePin, InputPin sinkPin) {
        this.sourcePin = sourcePin;
        this.sinkPin = sinkPin;
    }

    public boolean propagate() {
        state = sourcePin.getOutput();
        sinkPin.setInput(state);
        return state;
    }

    public boolean getState() {
        return state;
    }
}
