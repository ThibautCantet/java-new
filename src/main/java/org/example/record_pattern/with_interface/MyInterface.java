package org.example.record_pattern.with_interface;

sealed public interface MyInterface permits FirstMyInterfaceImpl, SecondMyInterfaceImpl {
    String name();
}
