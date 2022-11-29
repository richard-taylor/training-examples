package com.ukcloud.fizzbuzz;

public class TransformStatic implements Transformer {

    private static final String[] cache100;
    static {
        Transformer transformer = new TransformPeriod15();
        cache100 = new String[100];

        for (int i = 1; i <= 100; i++) {
            cache100[i - 1] = transformer.numberToString(i);
        }
    }

    @Override
    public String numberToString(int number) {
        return cache100[number - 1];
    }
}
