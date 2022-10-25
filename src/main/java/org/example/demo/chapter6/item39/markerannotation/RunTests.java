package org.example.demo.chapter6.item39.markerannotation;

// Program to process marker annotations (Page 182)

import java.lang.reflect.InvocationTargetException;

class RunTests {
    public static void main(String[] args) throws Exception {
        var tests = 0;
        var passed = 0;
        var testClass = Class.forName(args[0]);
        for (var m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    var exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }
}
