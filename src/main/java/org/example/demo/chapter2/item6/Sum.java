package org.example.demo.chapter2.item6;

// Hideously slow program! Can you spot the object creation? (Page 24)
class Sum {
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        var numSets = Integer.parseInt(args[0]);
        long x = 0;

        for (var i = 0; i < numSets; i++) {
            var start = System.nanoTime();
            x += sum();
            var end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // Prevents VM from optimizing away everything.
        if (x == 42)
            System.out.println();
    }
}
