package com.ukcloud.booleans;

/**
 * A logic gate performing the "OR" function.
 *
 * Output is true if any of the inputs are true.
 */
public class Or extends Gate {

    public Or() {
        this(2);
    }

    public Or(int numberOfInputs) {
        super(numberOfInputs);
    }

    @Override
    public boolean getOutput() {
        for (final boolean b : getInputs()) {
            if (b)
                return true;
        }
        return false;
    }
}
