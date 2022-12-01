package org.example.tester;

import java.util.Arrays;

public class TypeTester {

    enum Color { RED, GREEN, BLUE; }

    public String test(Object obj) {
        return switch (obj) {
            case null     -> "null";
            case String s when s.length() < 10 -> "Short string: " + s;
            case String s -> "Long string: " + s;
            case Color c  -> "Color: " + c.name();
            case Point p  -> p.toString();
            case int[] ia -> "Array: " + String.join(",", Arrays.stream(ia).mapToObj(String::valueOf).toList());
            default       -> "Something else";
        };
    }
}
