package org.example.demo.chapter5.item29.technqiue2;

import org.example.demo.chapter5.item29.EmptyStackException;

import java.util.Arrays;

// Generic stack using Object[] (Pages 130-3)
class Stack<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int size = 0;

    private Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    // Little program to exercise our generic Stack
    public static void main(String[] args) {
        var stack = new Stack<String>();
        for (var arg : args)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }

    void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // Appropriate suppression of unchecked warning
    E pop() {
        if (size == 0)
            throw new EmptyStackException();

        // push requires elements to be of type E, so cast is correct
        @SuppressWarnings("unchecked") var result =
                (E) elements[--size];

        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
