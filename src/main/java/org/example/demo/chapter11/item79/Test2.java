package org.example.demo.chapter11.item79;

import java.util.HashSet;

// More complex test of ObservableSet - Page 318-9
class Test2 {
    public static void main(String[] args) {
        var set =
                new ObservableSet<Integer>(new HashSet<>());

        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23)
                    s.removeObserver(this);
            }
        });

        for (var i = 0; i < 100; i++)
            set.add(i);
    }
}
