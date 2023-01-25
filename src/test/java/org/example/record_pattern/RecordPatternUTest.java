package org.example.record_pattern;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RecordPatternUTest {
    @Test
    void extractFieldValue_should_return_int_when_parameter_is_integer() {
        String result = RecordPattern.extractFieldValue(new RecordPattern.Box<>(1));

        assertThat(result).isEqualTo("int: 1");
    }

    @Test
    void extractFieldValue_should_return_string_when_parameter_is_String() {
        String result = RecordPattern.extractFieldValue(new RecordPattern.Box<>("toto"));

        assertThat(result).isEqualTo("string: toto");
    }

    @Test
    void extractFieldValue_should_return_Box_other_when_parameter_is_other_type() {
        String result = RecordPattern.extractFieldValue(new RecordPattern.Box<>(true));

        assertThat(result).isEqualTo("other: true");
    }
}
