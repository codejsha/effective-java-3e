package org.example.demo.chapter7.item45.anagrams;

import java.io.File;
import java.io.IOException;
import java.util.*;

// Prints all large anagram groups in a dictionary iteratively (Page 204)
class IterativeAnagrams {
    public static void main(String[] args) throws IOException {
        var dictionary = new File(args[0]);
        var minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (var s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                var word = s.next();
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }

        for (var group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }

    private static String alphabetize(String s) {
        var a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
