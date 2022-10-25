package org.example.demo.chapter4.item19;

import java.time.Instant;

// Demonstration of what can go wrong when you override a method  called from constructor (Page 96)
final class Sub extends Super {
    // Blank final, set by constructor
    private final Instant instant;

    private Sub() {
        instant = Instant.now();
    }

    public static void main(String[] args) {
        var sub = new Sub();
        sub.overrideMe();
    }

    // Overriding method invoked by superclass constructor
    @Override
    void overrideMe() {
        System.out.println(instant);
    }
}
