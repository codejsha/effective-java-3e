package org.example.demo.chapter9.item61;

import java.util.Comparator;

// Broken comparator - can you spot the flaw? - Page 273
class BrokenComparator {
    public static void main(String[] args) {

        //        Comparator<Integer> naturalOrder =
        //                (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        // Fixed Comparator - Page 274
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed; // Auto-unboxing
            return i < j ? -1 : (i == j ? 0 : 1);
        };

        var result = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result);
    }
}
