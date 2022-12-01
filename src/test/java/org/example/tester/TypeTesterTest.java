package org.example.tester;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TypeTesterTest {
    private final TypeTester typeTester = new TypeTester();

    @Test
    void test_should_return_null_when_object_is_null() {
        String result = typeTester.test(null);

        assertThat(result).isEqualTo("null");
    }

    @Test
    void test_should_return_short_string_when_string_when_is_string_and_length_less_than_10() {
        String result = typeTester.test("short");

        assertThat(result).isEqualTo("Short string: short");
    }

    @Test
    void test_should_return_long_string_when_string_when_is_string_and_length_greater_than_10() {
        String result = typeTester.test("my long string");

        assertThat(result).isEqualTo("Long string: my long string");
    }

    @Test
    void test_should_return_color_name_when_name_when_is_Color() {
        String result = typeTester.test(TypeTester.Color.BLUE);

        assertThat(result).isEqualTo("Color: BLUE");
    }

    @Test
    void test_should_return_point_coordinates_when_coordinates_when_is_Point() {
        String result = typeTester.test(new Point(1, 3));

        assertThat(result).isEqualTo("Point[x=1, y=3]");
    }

    @Test
    void test_should_return_composing_items_when_coordinates_when_is_array() {
        String result = typeTester.test(new int[] {1, 2, 3});

        assertThat(result).isEqualTo("Array: 1,2,3");
    }
    @Test
    void test_should_return_something_else_when_something_else_otherwise() {
        String result = typeTester.test(new Object());

        assertThat(result).isEqualTo("Something else");
    }
}
