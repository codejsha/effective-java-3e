package org.example.demo.chapter7.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

// Frequency table examples showing improper and proper use of stream (Page 210-11)
class Freq {
    public static void main(String[] args) throws FileNotFoundException {
        var file = new File(args[0]);

        //        // Uses the streams API but not the paradigm--Don't do this!
        //        Map<String, Long> freq = new HashMap<>();
        //        try (Stream<String> words = new Scanner(file).tokens()) {
        //            words.forEach(word -> {
        //                freq.merge(word.toLowerCase(), 1L, Long::sum);
        //            });
        //        }

        // Proper use of streams to initialize a frequency table (
        Map<String, Long> freq;
        try (var words = new Scanner(file).tokens()) {
            freq = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        }

        System.out.println(freq);

        // Pipeline to get a top-ten list of words from a frequency table
        var topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

        System.out.println(topTen);
    }
}
