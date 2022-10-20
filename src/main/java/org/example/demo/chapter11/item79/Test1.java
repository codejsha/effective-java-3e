package org.example.demo.chapter11.item79;

import java.util.HashSet;

// Simple test of ObservableSet - Page 318
public class Test1 {
    public static void main(String[] args) {
        var set =
                new ObservableSet<Integer>(new HashSet<>());

        set.addObserver((s, e) -> System.out.println(e));

        for (var i = 0; i < 100; i++)
            set.add(i);
    }
}
