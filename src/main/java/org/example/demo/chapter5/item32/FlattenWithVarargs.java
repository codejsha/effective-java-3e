package org.example.demo.chapter5.item32;

import java.util.ArrayList;
import java.util.List;

// Safe method with a generic varargs parameter (page 149)
class FlattenWithVarargs {
    @SafeVarargs
    private static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (var list : lists)
            result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        var flatList = flatten(
                List.of(1, 2), List.of(3, 4, 5), List.of(6, 7));
        System.out.println(flatList);
    }
}
