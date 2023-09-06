package org.example.string_template;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TemplateTest {

    private Template template = new Template();

    @Test
    void withConcatenation_should_return_template_text() {
        String result = template.withConcatenation();

        assertThat(result).isEqualTo("10 + 20 = 30");
    }

    @Test
    void withStringFormat_should_return_template_text() {
        String result = template.withStringFormat();

        assertThat(result).isEqualTo("10 + 20 = 30");
    }

    @Test
    void withMessageFormat_should_return_template_text() {
        String result = template.withMessageFormat();

        assertThat(result).isEqualTo("10 + 20 = 30");
    }

    @Test
    void withStringBuilder_should_return_template_text() {
        String result = template.withStringBuilder();

        assertThat(result).isEqualTo("10 + 20 = 30");
    }

    @Test
    void withTemplate_should_return_template_text() {
        String result = template.withTemplate();

        assertThat(result).isEqualTo("10 + 20 = 30");
    }

    @Test
    void withFormatterTemplate_should_return_template_text() {
        String result = template.withFormatterTemplate();

        assertThat(result).isEqualTo("10.79");
    }

    @Test
    void withRawTemplate_should_return_template_text() {
        String result = template.withRawTemplate();

        assertThat(result).isEqualTo("StringTemplate{ fragments = [ \"\", \"\" ], values = [10.7898] }");
    }
}
