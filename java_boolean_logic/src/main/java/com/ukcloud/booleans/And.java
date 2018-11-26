package com.ukcloud.booleans;

/**
 * A logic gate performing the "AND" function.
 *
 * Output is true if all the inputs are true.
 */
public class And extends Gate {

    public And() {
        this(2);
    }

    public And(int numberOfInputs) {
        super(numberOfInputs);
    }

    @Override
    public boolean getOutput() {
        for (final boolean b : getInputs()) {
            if (!b)
                return false;
        }
        return true;
    }
}
