package org.example.demo.chapter6.item40;

import java.util.HashSet;
import java.util.Set;

// Can you spot the bug? (Page 188)
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (var i = 0; i < 10; i++)
            for (var ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigram(ch, ch));
        System.out.println(s.size());
    }

    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }
}
