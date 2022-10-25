package org.example.demo.chapter4.item25;

// Static member classes instead of multiple top-level classes (Page 116)
class Test {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }

    private static class Utensil {
        private static final String NAME = "pan";
    }

    private static class Dessert {
        private static final String NAME = "cake";
    }
}
