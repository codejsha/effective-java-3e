package org.example.demo.chapter8.item52;

import java.math.BigInteger;
import java.util.*;

// Repaired  static classifier method. (Page 240)
class FixedCollectionClassifier {
    private static String classify(Collection<?> c) {
        return c instanceof Set ? "Set" :
                c instanceof List ? "List" : "Unknown Collection";
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
