package com.ukcloud.fizzbuzz;

import com.ukcloud.printing.Printer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTests {

    @Test
    public void play() {
        Printer printer = new Printer();
        FizzBuzz fizzBuzz = new FizzBuzz(printer);

        assertEquals(0, printer.getPrintCount());

        fizzBuzz.play();

        assertEquals(100, printer.getPrintCount());

        assertEquals("1", printer.getLinePrinted(lineOfNumber(1)));
        assertEquals("2", printer.getLinePrinted(lineOfNumber(2)));

        assertEquals("Fizz", printer.getLinePrinted(lineOfNumber(3)));
        assertEquals("Fizz", printer.getLinePrinted(lineOfNumber(6)));

        assertEquals("Buzz", printer.getLinePrinted(lineOfNumber(5)));
        assertEquals("Buzz", printer.getLinePrinted(lineOfNumber(10)));

        assertEquals("FizzBuzz", printer.getLinePrinted(lineOfNumber(15)));
        assertEquals("FizzBuzz", printer.getLinePrinted(lineOfNumber(30)));
    }

    @Test
    public void replay() {
        Printer printer = new Printer();
        FizzBuzz fizzBuzz = new FizzBuzz(printer);

        for (int t = 1; t <= 10; t++) {

            fizzBuzz.play();

            assertEquals(100 * t, printer.getPrintCount());

            assertEquals("1", printer.getLinePrinted(lineOfNumber(t, 1)));
            assertEquals("Fizz", printer.getLinePrinted(lineOfNumber(t, 3)));
            assertEquals("Buzz", printer.getLinePrinted(lineOfNumber(t, 5)));
            assertEquals("FizzBuzz", printer.getLinePrinted(lineOfNumber(t, 15)));
        }
    }

    private int lineOfNumber(int number) {
        return number - 1;
    }

    private int lineOfNumber(int trial, int number) {
        return (trial - 1) * 100 + number - 1;
    }
}
