package org.example.demo.chapter3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Broken - violates symmetry!  (Page 39)
final class CaseInsensitiveString {
    private final String s;

    private CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Demonstration of the problem (Page 40)
    public static void main(String[] args) {
        var cis = new CaseInsensitiveString("Polish");
        var s = "polish";

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(s));
    }

    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s);
        if (o instanceof String)  // One-way interoperability!
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    //    // Fixed equals method (Page 40)
    //    @Override public boolean equals(Object o) {
    //        return o instanceof CaseInsensitiveString &&
    //                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    //    }
}
