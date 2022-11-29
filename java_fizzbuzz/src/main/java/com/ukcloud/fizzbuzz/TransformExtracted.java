package com.ukcloud.fizzbuzz;

public class TransformExtracted implements Transformer {
    @Override
    public String numberToString(int number) {
        String THREE = "Fizz";
        String FIVE = "Buzz";
        String BOTH = "FizzBuzz";

        boolean is3 = isMultiple(number, 3);
        boolean is5 = isMultiple(number, 5);

        if (is3 && is5)
            return BOTH;
        if (is3)
            return THREE;
        if (is5)
            return FIVE;
        return String.valueOf(number);
    }

    private boolean isMultiple(int number, int factor) {
        return number % factor == 0;
    }
}
