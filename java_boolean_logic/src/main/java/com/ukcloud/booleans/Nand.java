package com.ukcloud.booleans;

/**
 * A logic gate performing the "NAND" function.
 *
 * Output is true unless all the inputs are true.
 */
public class Nand extends And {

    public Nand() {
        this(2);
    }

    public Nand(int numberOfInputs) {
        super(numberOfInputs);
    }

    @Override
    public boolean getOutput() {
        return !super.getOutput();
    }
}
