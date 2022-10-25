package org.example.demo.chapter2.item6;

import java.util.regex.Pattern;

// Reusing expensive object for improved performance (Pages 22 and 23)
class RomanNumerals {
    // Reusing expensive object for improved performance (Page 23)
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    // Performance can be greatly improved! (Page 22)
    private static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        var numSets = Integer.parseInt(args[0]);
        var numReps = Integer.parseInt(args[1]);
        var b = false;

        for (var i = 0; i < numSets; i++) {
            var start = System.nanoTime();
            for (var j = 0; j < numReps; j++) {
                b ^= isRomanNumeralSlow("MCMLXXVI");  // Change Slow to Fast to see performance difference
            }
            var end = System.nanoTime();
            System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
        }

        // Prevents VM from optimizing away everything.
        if (!b)
            System.out.println();
    }
}
