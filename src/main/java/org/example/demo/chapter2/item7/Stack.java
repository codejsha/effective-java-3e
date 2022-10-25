package org.example.demo.chapter2.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

// Can you spot the "memory leak"?  (Pages 26-27)
class Stack {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int size = 0;

    private Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public static void main(String[] args) {
        var stack = new Stack();
        for (var arg : args)
            stack.push(arg);

        while (true)
            System.err.println(stack.pop());
    }

    private void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    //    // Corrected version of pop method (Page 27)
    //    public Object pop() {
    //        if (size == 0)
    //            throw new EmptyStackException();
    //        Object result = elements[--size];
    //        elements[size] = null; // Eliminate obsolete reference
    //        return result;
    //    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
