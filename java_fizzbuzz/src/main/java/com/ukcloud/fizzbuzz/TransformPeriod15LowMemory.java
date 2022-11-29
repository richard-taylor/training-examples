package com.ukcloud.fizzbuzz;

public class TransformPeriod15LowMemory implements Transformer {

    // 00 = number
    // 01 = Fizz
    // 10 = Buzz
    // 11 = FizzBuzz
    //
    private static final int BIT_SEQUENCE = Integer.parseInt("000001001001000001100001000011", 2);

    @Override
    public String numberToString(int number) {
        switch ((BIT_SEQUENCE >> (2 * (number % 15))) & 3) {
            case 1: return "Fizz";
            case 2: return "Buzz";
            case 3: return "FizzBuzz";
        }
        return String.valueOf(number);
    }
}
