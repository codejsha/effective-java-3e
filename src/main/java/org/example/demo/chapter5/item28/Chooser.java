package org.example.demo.chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// List-based Chooser - typesafe (Page 129)
class Chooser<T> {
    private final List<T> choiceList;

    private Chooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public static void main(String[] args) {
        var intList = List.of(1, 2, 3, 4, 5, 6);

        var chooser = new Chooser<Integer>(intList);

        for (var i = 0; i < 10; i++) {
            Number choice = chooser.choose();
            System.out.println(choice);
        }
    }

    T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
