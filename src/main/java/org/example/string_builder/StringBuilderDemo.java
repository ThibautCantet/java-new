package org.example.string_builder;

public class StringBuilderDemo {

    public String duplicate(String value, int times) {
        var stringBuilder = new StringBuilder();
        stringBuilder.repeat(value, times);
        return stringBuilder.toString();
    }
}
