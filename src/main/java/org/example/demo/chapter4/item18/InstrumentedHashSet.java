package org.example.demo.chapter4.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// Broken - Inappropriate use of inheritance! (Page 87)
class InstrumentedHashSet<E> extends HashSet<E> {
    // The number of attempted element insertions
    private int addCount = 0;

    private InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    public static void main(String[] args) {
        var s = new InstrumentedHashSet<String>();
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

    int getAddCount() {
        return addCount;
    }
}
