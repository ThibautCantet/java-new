package org.example.record_pattern;

public class RecordPattern {
    record Box<T>(T t) {}
    static String extractFieldValue(Box<Object> bo) {
        switch (bo) {
            case Box<Object>(Integer i) -> {
                return "int: " + i;
            }
            case Box<Object>(String s) -> {
                return "string: " + s;
            }
            case null, default -> {
                return "other: " + bo.t;
            }
        }
    }
}
