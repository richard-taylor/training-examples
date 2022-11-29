package com.ukcloud.printing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTests {

    @Test
    public void constructor() {
        Printer printer = new Printer();
        assertEquals(0, printer.getPrintCount());
    }

    @Test
    public void printString() {
        Printer printer = new Printer();
        printer.print("testing 123");
        assertEquals(1, printer.getPrintCount());
        assertEquals("testing 123", printer.getLastLinePrinted());
    }

    @Test
    public void printNumber() {
        Printer printer = new Printer();
        printer.print(1234);
        assertEquals(1, printer.getPrintCount());
        assertEquals("1234", printer.getLastLinePrinted());
    }

    @Test
    public void counter() {
        Printer printer = new Printer();
        printer.print(100);
        printer.print(200);
        printer.print(300);
        printer.print(400);
        assertEquals(4, printer.getPrintCount());
        assertEquals("100", printer.getLinePrinted(0));
        assertEquals("200", printer.getLinePrinted(1));
        assertEquals("300", printer.getLinePrinted(2));
        assertEquals("400", printer.getLinePrinted(3));
        assertEquals("400", printer.getLastLinePrinted());
    }
}
