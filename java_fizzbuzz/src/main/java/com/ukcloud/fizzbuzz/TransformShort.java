package com.ukcloud.fizzbuzz;

public class TransformShort implements Transformer {
    @Override
    public String numberToString(int number) {
        if(number%15==0)return"FizzBuzz";
        if(number%3==0)return"Fizz";
        if(number%5==0)return"Buzz";
        return""+number;
    }
}
