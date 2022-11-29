package com.ukcloud.fizzbuzz;

public class TransformPeriod15 implements Transformer {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String N = null;
    private static final String[] cache15 = { N, N, FIZZ, N, BUZZ, FIZZ, N, N, FIZZ, BUZZ, N, FIZZ, N, N, FIZZ+BUZZ };

    @Override
    public String numberToString(int number) {
        String result = cache15[(number - 1) % 15];
        return result != N ? result : String.valueOf(number);
    }
}
