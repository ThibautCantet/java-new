package org.example;

public class ShapeCalculator {
    public double getPerimeter(Shape shape) {
        return switch (shape) {
            case Rectangle r: yield 2 * r.length() + 2 * r.width();
            case Circle c:    yield 2 * c.radius() * Math.PI;
            default:          throw new IllegalArgumentException("Unrecognized shape");
        };
    }
}
