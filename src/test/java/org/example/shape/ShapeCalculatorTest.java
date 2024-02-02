package org.example.shape;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ShapeCalculatorTest {

    private final ShapeCalculator shapeCalculator = new ShapeCalculator();

    @Test
    void getPerimeter_should_return_perimeter_for_a_rectangle() {
        var shape = new Rectangle(3, 2);

        var result = shapeCalculator.getPerimeter(shape);

        assertThat(result).isEqualTo(10d);
    }

    @Test
    void getPerimeter_should_return_perimeter_for_a_circle() {
        var shape = new Circle(3);

        var result = shapeCalculator.getPerimeter(shape);

        assertThat(result).isEqualTo(18.84955592153876);
    }

    @Test
    void getPerimeter_should_throw_exception_when_not_a_valid_shape() {
        var shape = new CustomShape();

        Throwable throwable = catchThrowable(() -> shapeCalculator.getPerimeter(shape));

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Unrecognized shape");
    }

    private record CustomShape() implements Shape {}
}
