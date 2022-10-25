package org.example.demo.chapter8.item50;

import java.util.Date;

// Two attacks on the internals of an "immutable" period (232-3)
class Attacks {
    public static void main(String[] args) {
        // Attack the internals of a Period instance  (Page 232)
        var start = new Date();
        var end = new Date();
        var p = new Period(start, end);
        end.setYear(78);  // Modifies internals of p!
        System.out.println(p);

        // Second attack on the internals of a Period instance  (Page 233)
        start = new Date();
        end = new Date();
        p = new Period(start, end);
        p.end().setYear(78);  // Modifies internals of p!
        System.out.println(p);
    }
}
