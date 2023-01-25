package org.example.record_pattern;

sealed interface MyInterface permits FirstMyInterfaceImpl, SecondMyInterfaceImpl {
    String name();
}
