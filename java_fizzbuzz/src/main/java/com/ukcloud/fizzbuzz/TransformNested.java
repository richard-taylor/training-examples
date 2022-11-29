package com.ukcloud.fizzbuzz;

public class TransformNested implements Transformer {
    @Override
    public String numberToString(int number) {
        if (number % 3 == 0) {
            if (number % 5 == 0) {
                return "FizzBuzz";
            }
            else {
                return "Fizz";
            }
        }
        else if (number % 5 == 0) {
            return "Buzz";
        }
        else {
            return String.valueOf(number);
        }
    }
}
