package com.ukcloud.booleans;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NoSteadyStateExceptionTests {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void customisedMessage() throws Exception {
        expectedEx.expect(NoSteadyStateException.class);
        expectedEx.expectMessage("This will oscillate forever.");

        throw new NoSteadyStateException("This will oscillate forever.");
    }
}
