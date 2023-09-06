package org.example.string_template;

import java.text.MessageFormat;

import static java.lang.StringTemplate.*;
import static java.util.FormatProcessor.*;

public class Template {

    String withConcatenation() {
        int x = 10, y = 20;

        return x + " + " + y + " = " + (x + y);
    }

    String withStringFormat() {
        int x = 10, y = 20;

        return String.format("%s + %s = %s", x, y, x + y);
    }

    String withMessageFormat() {
        int x = 10, y = 20;

        return MessageFormat.format("{0} + {1} = {2}", x, y, x + y);
    }

    String withStringBuilder() {
        int x = 10, y = 20;

        return new StringBuilder()
                .append(x)
                .append(" + ")
                .append(y)
                .append(" = ")
                .append(x + y)
                .toString();
    }

    String withTemplate() {
        int x = 10, y = 20;
        return STR."\{x} + \{y} = \{x + y}";
    }

    String withFormatterTemplate() {
        var x = 10.7898;
        return FMT."%.2f\{x}";
    }

    String withRawTemplate() {
        var x = 10.7898;
        return RAW."\{x}".toString();
    }
}
