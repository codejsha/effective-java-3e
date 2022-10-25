package org.example.demo.chapter3.item14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

// The benefits of implementing Comparable (Page 66)
class WordList {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, args);
        System.out.println(s);
    }
}
