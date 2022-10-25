package org.example.demo.chapter6.item36;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// EnumSet - a modern replacement for bit fields (Page 170)
class Text {
    // Sample use
    public static void main(String[] args) {
        var text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }

    // Any Set could be passed in, but EnumSet is clearly best
    private void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n",
                Objects.requireNonNull(styles));
    }

    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}
}
