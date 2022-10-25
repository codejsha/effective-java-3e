package org.example.demo.chapter4.item20;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// Concrete implementation built atop skeletal implementation (Page 101)
class IntArrays {
    private static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        // The diamond operator is only legal here in Java 9 and later
        // If you're using an earlier release, specify <Integer>
        return new AbstractList<>() {
            @Override
            public Integer get(int i) {
                return a[i];  // Autoboxing (Item 6)
            }

            @Override
            public Integer set(int i, Integer val) {
                var oldVal = a[i];
                a[i] = val;     // Auto-unboxing
                return oldVal;  // Autoboxing
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }

    public static void main(String[] args) {
        var a = new int[10];
        for (var i = 0; i < a.length; i++)
            a[i] = i;

        var list = intArrayAsList(a);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
