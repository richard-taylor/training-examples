package com.ukcloud.booleans;

/**
 * A logic gate performing the "Not" function.
 *
 * Output is true if the input is false.
 */
public class Not extends Gate {

    public Not() {
        super(1);
    }

    public void setInput(boolean input) {
        setInput(0, input);
    }

    @Override
    public boolean getOutput() {
        return !getInput(0);
    }
}
