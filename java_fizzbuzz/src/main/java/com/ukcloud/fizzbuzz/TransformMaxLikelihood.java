package com.ukcloud.fizzbuzz;

public class TransformMaxLikelihood implements Transformer {
    @Override
    public String numberToString(int number) {
        if (number % 15 != 0) {
            if (number % 5 != 0) {
                if (number % 3 != 0) {
                    return String.valueOf(number);
                }
                else {
                    return "Fizz";
                }
            }
            else {
                return "Buzz";
            }
        }
        else {
            return "FizzBuzz";
        }
    }
}
