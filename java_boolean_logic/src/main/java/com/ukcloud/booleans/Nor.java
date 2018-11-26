package com.ukcloud.booleans;

/**
 * A logic gate performing the "NOR" function.
 *
 * Output is true if none the inputs are true.
 */
public class Nor extends Or {

    public Nor() {
        this(2);
    }

    public Nor(int numerOfInputs) {
        super(numerOfInputs);
    }

    @Override
    public boolean getOutput() {
        return !super.getOutput();
    }
}
