package com.ukcloud.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EfficiencyTests {

    @Test
    public void orderMatters() {
        Util u0 = new Util();
        long n0 = do3and5(u0);

        Util u1 = new Util();
        long n1 = do3then5(u1);

        Util u2 = new Util();
        long n2 = do5then3(u2);

        Util u3 = new Util();
        long n3 = do15(u3);

        assertEquals(n0, n1);
        assertEquals(n1, n2);
        assertEquals(n2, n3);

        assertEquals(200, u0.getCalls());
        assertEquals(133, u1.getCalls());
        assertEquals(120, u2.getCalls());
        assertEquals(100, u3.getCalls());
    }

    private long do3and5(Util u) {
        long n = 0;
        for (int i = 1; i <= 100; i++) {
            if (u.mod(i, 3) == 0 & u.mod(i, 5)== 0) {
                n++;
            }
        }
        return n;
    }

    private long do3then5(Util u) {
        long n = 0;
        for (int i = 1; i <= 100; i++) {
            if (u.mod(i, 3) == 0 && u.mod(i, 5)== 0) {
                n++;
            }
        }
        return n;
    }

    private long do5then3(Util u) {
        long n = 0;
        for (int i = 1; i <= 100; i++) {
            if (u.mod(i, 5) == 0 && u.mod(i, 3) == 0) {
                n++;
            }
        }
        return n;
    }

    private long do15(Util u) {
        long n = 0;
        for (int i = 1; i <= 100; i++) {
            if (u.mod(i, 15) == 0) {
                n++;
            }
        }
        return n;
    }

    private class Util {
        private int calls = 0;

        public int mod(int number, int divisor) {
            calls++;
            return number % divisor;
        }

        public int getCalls() { return calls; }
    }
}
