package org.example.demo.chapter3.item13;

import java.util.Arrays;

// A cloneable version of Stack (Pages 60-61)
public class Stack implements Cloneable {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int size = 0;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    // To see that clone works, call with several command line arguments
    public static void main(String[] args) {
        var stack = new Stack();
        for (var arg : args)
            stack.push(arg);
        var copy = stack.clone();
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
        while (!copy.isEmpty())
            System.out.print(copy.pop() + " ");
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        var result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Clone method for class with references to mutable state
    @Override
    public Stack clone() {
        try {
            var result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Ensure space for at least one more element.
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
