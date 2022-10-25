package org.example.demo.chapter5.item31;

import java.util.Arrays;
import java.util.List;

// Using a recursive type bound with wildcards (Page 143)
class RecursiveTypeBound {
    private static <E extends Comparable<? super E>> E max(
            List<? extends E> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("Empty list");

        E result = null;
        for (E e : list)
            if (result == null || e.compareTo(result) > 0)
                result = e;

        return result;
    }

    public static void main(String[] args) {
        var argList = Arrays.asList(args);
        System.out.println(max(argList));
    }
}
