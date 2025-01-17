package org.example.demo.chapter8.item52;

import java.util.List;

// Classification using method overrriding (Page 239)
class Overriding {
    public static void main(String[] args) {
        var wineList = List.of(
                new Wine(), new SparklingWine(), new Champagne());

        for (var wine : wineList)
            System.out.println(wine.name());
    }
}
