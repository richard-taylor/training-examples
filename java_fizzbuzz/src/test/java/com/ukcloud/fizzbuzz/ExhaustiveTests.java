package com.ukcloud.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExhaustiveTests {

    @Test
    public void testCommon() {
        test100(new TransformCommon());
    }

    private void test100(Transformer transformer) {
        String[] expected = { "N/A",
                 "1",  "2", "Fizz",  "4", "Buzz", "Fizz",  "7",  "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz",
                "16", "17", "Fizz", "19", "Buzz", "Fizz", "22", "23", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz",
                "31", "32", "Fizz", "34", "Buzz", "Fizz", "37", "38", "Fizz", "Buzz", "41", "Fizz", "43", "44", "FizzBuzz",
                "46", "47", "Fizz", "49", "Buzz", "Fizz", "52", "53", "Fizz", "Buzz", "56", "Fizz", "58", "59", "FizzBuzz",
                "61", "62", "Fizz", "64", "Buzz", "Fizz", "67", "68", "Fizz", "Buzz", "71", "Fizz", "73", "74", "FizzBuzz",
                "76", "77", "Fizz", "79", "Buzz", "Fizz", "82", "83", "Fizz", "Buzz", "86", "Fizz", "88", "89", "FizzBuzz",
                "91", "92", "Fizz", "94", "Buzz", "Fizz", "97", "98", "Fizz", "Buzz"
        };
        for (int number = 1; number <= 100; number++) {
            assertEquals(expected[number], transformer.numberToString(number));
        }
    }

    @Test
    public void testShort() {
        test100(new TransformShort());
    }

    @Test
    public void testExtendable() {
        test100(new TransformExtendable());
    }

    @Test
    public void testNested() {
        test100(new TransformNested());
    }

    @Test
    public void testMaxLikelihood() {
        test100(new TransformMaxLikelihood());
    }

    @Test
    public void testExtracted() {
        test100(new TransformExtracted());
    }

    @Test
    public void testPeriod15() {
        test100(new TransformPeriod15());
    }

    @Test
    public void testPeriod15LowMemory() {
        test100(new TransformPeriod15LowMemory());
    }

    @Test
    public void testEulerTotient() {
        test100(new TransformEulerTotient());
    }

    @Test
    public void testStatic() {
        test100(new TransformStatic());
    }
}
