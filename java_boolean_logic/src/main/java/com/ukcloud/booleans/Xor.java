package com.ukcloud.booleans;

/**
 * A logic gate performing the "XOR" function (exclusive OR).
 *
 * Output is true if the two inputs are different.
 */
public class Xor extends Gate {

    public Xor() {
        super(2);
    }

    @Override
    public boolean getOutput() {
        return getInput(0) ^ getInput(1);
    }
}
