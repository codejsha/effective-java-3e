package org.example.demo.chapter6.item39.repeatableannotation;

import org.example.demo.chapter6.item39.markerannotation.Test;

import java.lang.reflect.InvocationTargetException;

// Program to process marker annotations and repeatable annotations (Page 187)
class RunTests {
    public static void main(String[] args) throws Exception {
        var tests = 0;
        var passed = 0;
        Class testClass = Class.forName(args[0]);
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
                    System.out.println("INVALID @Test: " + m);
                }
            }

            // Processing repeatable annotations (Page 187)
            if (m.isAnnotationPresent(ExceptionTest.class)
                    || m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (Throwable wrappedExc) {
                    var exc = wrappedExc.getCause();
                    var oldPassed = passed;
                    var excTests =
                            m.getAnnotationsByType(ExceptionTest.class);
                    for (var excTest : excTests) {
                        if (excTest.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed)
                        System.out.printf("Test %s failed: %s %n", m, exc);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }
}
