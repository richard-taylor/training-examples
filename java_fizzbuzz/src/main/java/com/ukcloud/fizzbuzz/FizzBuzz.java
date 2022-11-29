package com.ukcloud.fizzbuzz;

import com.ukcloud.printing.Printer;

/**
 * Play the fizz buzz game.
 *
 * For all the numbers from 1 to 100, either
 *
 * Print the number
 * Print "Fizz" if the number is a multiple of 3
 * Print "Buzz" if the number is a multiple of 5
 * Print "FizzBuzz" if the number is a multiple of 3 and 5.
 */
public class FizzBuzz {

    private final Printer printer;
    private final Transformer transformer;

    public FizzBuzz(Printer printer, Transformer transformer) {
        this.printer = printer;
        this.transformer = transformer;
    }

    public FizzBuzz(Printer printer) {
        this(printer, new TransformCommon());
    }

    public void play() {
        for (int i = 1; i <= 100; i++) {
            printer.print(transformer.numberToString(i));
        }
    }
}
