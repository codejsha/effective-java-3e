package org.example.demo.chapter8.item52;

import java.math.BigInteger;
import java.util.*;

// Broken! - What does this program print?  (Page 238)
class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> lst) {
        return "List";
    }

    private static String classify(Collection<?> c) {
        return "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (var c : collections)
            System.out.println(classify(c));
    }
}
