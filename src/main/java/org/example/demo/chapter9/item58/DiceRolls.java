package org.example.demo.chapter9.item58;

import java.util.Collection;
import java.util.EnumSet;

// Same bug as NestIteration.java (but different symptom)!! - Page 213
class DiceRolls {
    public static void main(String[] args) {
        // Same bug, different symptom!
        Collection<Face> faces = EnumSet.allOf(Face.class);

        for (var i = faces.iterator(); i.hasNext(); )
            for (var j = faces.iterator(); j.hasNext(); )
                System.out.println(i.next() + " " + j.next());

        System.out.println("***************************");

        for (var f1 : faces)
            for (var f2 : faces)
                System.out.println(f1 + " " + f2);
    }

    enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX}
}
