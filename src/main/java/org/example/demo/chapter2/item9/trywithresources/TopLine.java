package org.example.demo.chapter2.item9.trywithresources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TopLine {
    // try-with-resources - the the best way to close resources!  (Page 35)
    private static String firstLineOfFile(String path) throws IOException {
        try (var br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        var path = args[0];
        System.out.println(firstLineOfFile(path));
    }
}
