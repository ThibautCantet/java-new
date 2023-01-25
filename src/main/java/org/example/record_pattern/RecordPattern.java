package org.example.record_pattern;

public class RecordPattern {
    record Box<T>(T t) {}
    static String extractFieldValue(Box<Object> bo) {
        if (bo instanceof Box<Object>(Integer i)) {
            return "int: " + i;
        }
        if (bo instanceof Box<Object>(String s)) {
            return "string: " + s;
        }
        return "other: " + bo.t;
    }
}
