package org.example.tester;

import java.util.Arrays;

public class TypeTester {

    enum Color { RED, GREEN, BLUE; }

    public String test(Object obj) {
        return switch (obj) {
            case null     -> "null";
            case String s -> manageString(s);
            case Color c  -> "Color: " + c.name();
            case Point p  -> p.toString();
            case int[] ia -> "Array: " + String.join(",", Arrays.stream(ia).mapToObj(String::valueOf).toList());
            default       -> "Something else";
        };
    }

    private static String manageString(String s) {
        if (s.length() < 10) {
            return "Short string: " + s;
        }
        return "Long string: " + s;
    }
}
