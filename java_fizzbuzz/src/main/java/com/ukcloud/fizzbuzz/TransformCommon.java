package com.ukcloud.fizzbuzz;

public class TransformCommon implements Transformer {
    @Override
    public String numberToString(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }
        else if (number % 3 == 0) {
            return "Fizz";
        }
        else if (number % 5 == 0) {
            return "Buzz";
        }
        else {
            return String.valueOf(number);
        }
    }
}
