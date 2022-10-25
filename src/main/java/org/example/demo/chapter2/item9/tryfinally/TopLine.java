package org.example.demo.chapter2.item9.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TopLine {
    // try-finally - No longer the best way to close resources! (page 34)
    private static String firstLineOfFile(String path) throws IOException {
        var br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        var path = args[0];
        System.out.println(firstLineOfFile(path));
    }
}
