package org.example.demo.chapter5.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

// Wildcard type for parameter that serves as an T producer (page 141)
class Chooser<T> {
    private final List<T> choiceList;
    private final Random rnd = new Random();

    private Chooser(Collection<? extends T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public static void main(String[] args) {
        var intList = List.of(1, 2, 3, 4, 5, 6);
        var chooser = new Chooser<Number>(intList);
        for (var i = 0; i < 10; i++) {
            var choice = chooser.choose();
            System.out.println(choice);
        }
    }

    T choose() {
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
