package com.ukcloud.fizzbuzz;

public class TransformExtendable implements Transformer {
    @Override
    public String numberToString(int number) {
        StringBuilder stringBuilder = new StringBuilder();

        if (number % 3 == 0) {
            stringBuilder.append("Fizz");
        }
        if (number % 5 == 0) {
            stringBuilder.append("Buzz");
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }
}
