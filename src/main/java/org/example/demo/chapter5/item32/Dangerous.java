package org.example.demo.chapter5.item32;

import java.util.List;

// It is unsafe to store a value in a generic varargs array parameter (Page 146)
class Dangerous {
    // Mixing generics and varargs can violate type safety!
    private static void dangerous(List<String>... stringLists) {
        var intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // Heap pollution
        var s = stringLists[0].get(0); // ClassCastException
    }

    public static void main(String[] args) {
        dangerous(List.of("There be dragons!"));
    }
}
