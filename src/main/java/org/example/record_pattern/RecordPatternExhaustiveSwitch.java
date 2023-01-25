package org.example.record_pattern;

public class RecordPatternExhaustiveSwitch {

    public RecordPatternExhaustiveSwitch(Pair<MyInterface> p2) {
        this.p2 = p2;
    }

    class A {}
    class B extends A {}
    record Pair<T>(T x, T y) {}

    Pair<A> p1;
    final Pair<MyInterface> p2;

    String switchPattern() {
        return switch (p2) {
            case Pair<MyInterface>(MyInterface i, FirstMyInterfaceImpl first) -> i.name() + "-" + first.name();
            case Pair<MyInterface>(MyInterface i, SecondMyInterfaceImpl second) -> i.name() + "-" + second.name();
        };
    }

    String switchPattern2() {
        return switch (p2) {
            case Pair<MyInterface>(FirstMyInterfaceImpl first, MyInterface i) -> first.name() + "-" + i.name();
            case Pair<MyInterface>(SecondMyInterfaceImpl second, FirstMyInterfaceImpl first) -> second.name() + "-" + first.name();
            case Pair<MyInterface>(SecondMyInterfaceImpl second1, SecondMyInterfaceImpl second2) -> second1.name() + "-" + second2.name();
        };
    }
}
