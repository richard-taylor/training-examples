package com.ukcloud.booleans;

/**
 * A logic gate with no inputs which always outputs true.
 */
public class True extends Gate {

    public True() {
        super(0);
    }

    @Override
    public boolean getOutput() {
        return true;
    }
}
