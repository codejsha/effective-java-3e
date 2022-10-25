package org.example.demo.chapter8.item53;

// Sample uses of varargs (Pages 245-6)
class Varargs {
    // Simple use of varargs (Page 245)
    private static int sum(int... args) {
        var sum = 0;
        for (var arg : args)
            sum += arg;
        return sum;
    }

    //    // The WRONG way to use varargs to pass one or more arguments! (Page 245)
    //    static int min(int... args) {
    //        if (args.length == 0)
    //            throw new IllegalArgumentException("Too few arguments");
    //        int min = args[0];
    //        for (int i = 1; i < args.length; i++)
    //            if (args[i] < min)
    //                min = args[i];
    //        return min;
    //    }

    // The right way to use varargs to pass one or more arguments (Page 246)
    private static int min(int firstArg, int... remainingArgs) {
        var min = firstArg;
        for (var arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(min(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
