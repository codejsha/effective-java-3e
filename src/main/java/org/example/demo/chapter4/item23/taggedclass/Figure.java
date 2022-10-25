package org.example.demo.chapter4.item23.taggedclass;

// Tagged class - vastly inferior to a class hierarchy! (Page 109)
class Figure {
    // Tag field - the shape of this figure
    private final Shape shape;

    // These fields are used only if shape is RECTANGLE
    private double length;
    private double width;
    // This field is used only if shape is CIRCLE
    private double radius;

    // Constructor for circle
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Constructor for rectangle
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        return switch (shape) {
            case RECTANGLE -> length * width;
            case CIRCLE -> Math.PI * (radius * radius);
            default -> throw new AssertionError(shape);
        };
    }

    enum Shape {RECTANGLE, CIRCLE}
}
