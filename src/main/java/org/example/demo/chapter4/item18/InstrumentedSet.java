package org.example.demo.chapter4.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Wrapper class - uses composition in place of inheritance  (Page 90)
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    public static void main(String[] args) {
        var s = new InstrumentedSet<String>(new HashSet<>());
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
