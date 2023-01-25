package org.example.record_pattern;

import org.example.record_pattern.with_class.A;
import org.example.record_pattern.with_class.B;
import org.example.record_pattern.with_interface.FirstMyInterfaceImpl;
import org.example.record_pattern.with_interface.MyInterface;
import org.example.record_pattern.with_interface.SecondMyInterfaceImpl;

public class RecordPatternExhaustiveSwitch {

    private RecordPatternExhaustiveSwitch(Pair<MyInterface> p2) {
        this.p2 = p2;
    }

    private RecordPatternExhaustiveSwitch() {
        p2 = null;
    }

    static RecordPatternExhaustiveSwitch create(Pair<MyInterface> p2) {
        return new RecordPatternExhaustiveSwitch(p2);
    }

    static RecordPatternExhaustiveSwitch createWithClass(Pair<A> p1) {
        var recordPatternExhaustiveSwitch = new RecordPatternExhaustiveSwitch();
        recordPatternExhaustiveSwitch.p1 = p1;
        return recordPatternExhaustiveSwitch;
    }
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

    String switchPatternWithClass() {
        return switch (p1) {
            case Pair<A>(B b1, B b2) -> b1.name() + "-" + b2.name();
            case Pair<A>(A a, B b) -> a.name() + "-" + b.name();
            case Pair<A>(B b, A a) -> b.name() + "-" + a.name();
            case Pair<A>(A a1, A a2) -> a1.name() + "-" + a2.name();
        };
    }
}
