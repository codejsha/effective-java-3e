package org.example.demo.chapter5.item32;

import java.util.ArrayList;
import java.util.List;

// List as a typesafe alternative to a generic varargs parameter (page 149)
class FlattenWithList {
    private static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (var list : lists)
            result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        var flatList = flatten(List.of(
                List.of(1, 2), List.of(3, 4, 5), List.of(6, 7)));
        System.out.println(flatList);
    }
}
