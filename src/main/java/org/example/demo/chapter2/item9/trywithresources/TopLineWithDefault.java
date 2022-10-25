package org.example.demo.chapter2.item9.trywithresources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TopLineWithDefault {
    // try-with-resources with a catch clause  (Page 36)
    private static String firstLineOfFile(String path, String defaultVal) {
        try (var br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }

    public static void main(String[] args) throws IOException {
        var path = args[0];
        System.out.println(firstLineOfFile(path, "Toppy McTopFace"));
    }
}
