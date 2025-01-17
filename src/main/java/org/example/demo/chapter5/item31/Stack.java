package org.example.demo.chapter5.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

// Generic stack with bulk methods using wildcard types (Pages 139-41)
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
        var numberStack = new Stack<Number>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        numberStack.pushAll(integers);

        Collection<Object> objects = new ArrayList<>();
        numberStack.popAll(objects);

        System.out.println(objects);
    }

    private void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private E pop() {
        if (size == 0)
            throw new EmptyStackException();
        var result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    //    // pushAll staticfactory without wildcard type - deficient!
    //    public void pushAll(Iterable<E> src) {
    //        for (E e : src)
    //            push(e);
    //    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    //    // popAll staticfactory without wildcard type - deficient!
    //    public void popAll(Collection<E> dst) {
    //        while (!isEmpty())
    //            dst.add(pop());
    //    }

    // Wildcard type for parameter that serves as an E producer
    void pushAll(Iterable<? extends E> src) {
        for (E e : src)
            push(e);
    }

    // Wildcard type for parameter that serves as an E consumer
    void popAll(Collection<? super E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }
}
