package org.example.demo.chapter5.item29.technqiue1;

import org.example.demo.chapter5.item29.EmptyStackException;

import java.util.Arrays;

// Generic stack using E[] (Pages 130-3)
class Stack<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] elements;
    private int size = 0;

    // The elements array will contain only E instances from push(E).
    // This is sufficient to ensure type safety, but the runtime
    // type of the array won't be E[]; it will always be Object[]!
    @SuppressWarnings("unchecked")
    private Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
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

    E pop() {
        if (size == 0)
            throw new EmptyStackException();
        var result = elements[--size];
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
