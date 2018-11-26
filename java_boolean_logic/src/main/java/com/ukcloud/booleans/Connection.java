package com.ukcloud.booleans;

/**
 * A connection joins the output of one logic gate to a specific input of
 * another logic gate.
 */
public class Connection {

    private final Gate sourceGate;
    private final Gate sinkGate;
    private final int sinkIndex;

    private boolean state;

    public Connection(final Gate sourceGate, final Gate sinkGate, int sinkIndex) {
        this.sourceGate = sourceGate;
        this.sinkGate = sinkGate;
        this.sinkIndex = sinkIndex;
    }

    public boolean propagate() {
        state = sourceGate.getOutput();
        sinkGate.setInput(sinkIndex, state);
        return state;
    }

    public boolean getState() {
        return state;
    }
}
