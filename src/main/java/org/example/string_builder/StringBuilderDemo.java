package org.example.string_builder;

public class StringBuilderDemo {

    public String duplicate(String value, int times) {
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }
}
