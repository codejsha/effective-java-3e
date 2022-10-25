package org.example.demo.chapter6.item39.annotationwithparameter;

// Program containing annotations with a parameter (Page 183)
class Sample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {  // Test should pass
        var i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {  // Should fail (wrong exception)
        var a = new int[0];
        var i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {
    }  // Should fail (no exception)
}
