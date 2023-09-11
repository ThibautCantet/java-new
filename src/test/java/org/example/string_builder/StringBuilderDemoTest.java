package org.example.string_builder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringBuilderDemoTest {

    @Test
    void duplicate_should_print_x_times_the_string() {
        var stringBuilderDemo = new StringBuilderDemo();

        String result = stringBuilderDemo.duplicate("hello", 4);

        assertThat(result).isEqualTo("hellohellohellohello");
    }
}
