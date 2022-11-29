package com.ukcloud.printing;

import java.util.ArrayList;
import java.util.List;

public class Printer {

    private final List<String> linesPrinted;

    public Printer() {
        linesPrinted = new ArrayList<>();
    }

    public void print(String text) {
        System.out.println(text);
        linesPrinted.add(text);
    }

    public void print(int number) {
        print(String.valueOf(number));
    }

    public int getPrintCount() {
        return linesPrinted.size();
    }

    public String getLinePrinted(int lineNumber) {
        return linesPrinted.get(lineNumber);
    }

    public String getLastLinePrinted() {
        return linesPrinted.get(getPrintCount() - 1);
    }
}
