package com.ukcloud.fizzbuzz;

public class TransformEulerTotient implements Transformer {

    @Override
    public String numberToString(int number) {

        // Euler's Totient Theorem can be used to show that (number ^ 4) % 15 must be in {0,1,6,10}

        switch ((number * number * number * number) % 15) {
            case 1: return String.valueOf(number);
            case 6: return "Fizz";
            case 10: return "Buzz";
        }
        return "FizzBuzz";
    }
}
