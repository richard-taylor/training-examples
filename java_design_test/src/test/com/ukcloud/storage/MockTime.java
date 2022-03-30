package com.ukcloud.storage;

public class MockTime implements Time {

    final long t;

    public MockTime(long t) {
        this.t = t;
    }

    public static MockTime at(long t) {
        return new MockTime(t);
    }

    public long getTime() { return t; }
}
