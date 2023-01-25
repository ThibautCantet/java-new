package org.example.record_pattern;


import org.example.record_pattern.with_class.A;
import org.example.record_pattern.with_class.B;
import org.example.record_pattern.with_interface.FirstMyInterfaceImpl;
import org.example.record_pattern.with_interface.MyInterface;
import org.example.record_pattern.with_interface.SecondMyInterfaceImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RecordPatternExhaustiveSwitchUTest {

    @Nested
    class SwitchPatternWithMyInterfaceAsFirstParameter {
        @Test
        void switchPattern_should_return_first_interface_implementation_twice_when_first_implementation_as_second_parameter() {
            var pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    (MyInterface) new FirstMyInterfaceImpl(),
                    new FirstMyInterfaceImpl());

            var recordPatternExhaustiveSwitch = RecordPatternExhaustiveSwitch.create(pair);

            String result = recordPatternExhaustiveSwitch.switchPattern();

            assertThat(result).isEqualTo("FirstMyInterfaceImpl-FirstMyInterfaceImpl");
        }

        @Test
        void switchPattern_should_return_first_implementation_and_second_interface_implementation_when_second_implementation_as_second_parameter() {
            var pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new FirstMyInterfaceImpl(),
                    new SecondMyInterfaceImpl());

            var recordPatternExhaustiveSwitch = RecordPatternExhaustiveSwitch.create(pair);

            String result = recordPatternExhaustiveSwitch.switchPattern();

            assertThat(result).isEqualTo("FirstMyInterfaceImpl-SecondMyInterfaceImpl");
        }
    }

    @Nested
    class SwitchPatternWithImplementationAsFirstParameter {
        @Test
        void switchPattern_should_return_first_interface_implementation_twice_when_first_implementation_and_myinterface_as_parameters() {
            var pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new FirstMyInterfaceImpl(),
                    (MyInterface) new FirstMyInterfaceImpl());

            var recordPatternExhaustiveSwitch = RecordPatternExhaustiveSwitch.create(pair);

            String result = recordPatternExhaustiveSwitch.switchPattern2();

            assertThat(result).isEqualTo("FirstMyInterfaceImpl-FirstMyInterfaceImpl");
        }

        @Test
        void switchPattern_should_return_second_and_first_interface_implementation_when_second_implementation_and_first_implementation_as_parameters() {
            var pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new SecondMyInterfaceImpl(),
                    new FirstMyInterfaceImpl());

            var recordPatternExhaustiveSwitch = RecordPatternExhaustiveSwitch.create(pair);

            String result = recordPatternExhaustiveSwitch.switchPattern2();

            assertThat(result).isEqualTo("SecondMyInterfaceImpl-FirstMyInterfaceImpl");
        }

        @Test
        void switchPattern_should_return_second_interface_implementation_twice_when_2_second_implementation_as_parameters() {
            RecordPatternExhaustiveSwitch.Pair<MyInterface> pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new SecondMyInterfaceImpl(),
                    new SecondMyInterfaceImpl());

            var recordPatternExhaustiveSwitch = RecordPatternExhaustiveSwitch.create(pair);

            String result = recordPatternExhaustiveSwitch.switchPattern2();

            assertThat(result).isEqualTo("SecondMyInterfaceImpl-SecondMyInterfaceImpl");
        }
    }

    @Nested
    class SwitchPatternWithClass {
        @Test
        void should_return_b_b_when_b_and_b_as_parameters() {
            RecordPatternExhaustiveSwitch.Pair<A> pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new B(),
                    new B());
            var recordPatternExhaustiveSwitch = RecordPatternExhaustiveSwitch.createWithClass(pair);

            String result = recordPatternExhaustiveSwitch.switchPatternWithClass();

            assertThat(result).isEqualTo("B-B");
        }

        @Test
        void should_return_a_b_when_a_and_b_as_parameters() {
            var pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new A(),
                    new B());
            var recordPatternExhaustiveSwitch = RecordPatternExhaustiveSwitch.createWithClass(pair);

            String result = recordPatternExhaustiveSwitch.switchPatternWithClass();

            assertThat(result).isEqualTo("A-B");
        }

        @Test
        void should_return_b_a_when_b_and_a_as_parameters() {
            var pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new B(),
                    new A());
            var recordPatternExhaustiveSwitch = RecordPatternExhaustiveSwitch.createWithClass(pair);

            String result = recordPatternExhaustiveSwitch.switchPatternWithClass();

            assertThat(result).isEqualTo("B-A");
        }

        @Test
        void should_return_a_a_when_a_and_a_as_parameters() {
            var pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new A(),
                    new A());
            var recordPatternExhaustiveSwitch = RecordPatternExhaustiveSwitch.createWithClass(pair);

            String result = recordPatternExhaustiveSwitch.switchPatternWithClass();

            assertThat(result).isEqualTo("A-A");
        }
    }

}
