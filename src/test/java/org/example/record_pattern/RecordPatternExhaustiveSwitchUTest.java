package org.example.record_pattern;


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

            var recordPatternExhaustiveSwitch = new RecordPatternExhaustiveSwitch(pair);

            String result = recordPatternExhaustiveSwitch.switchPattern();

            assertThat(result).isEqualTo("FirstMyInterfaceImpl-FirstMyInterfaceImpl");
        }

        @Test
        void switchPattern_should_return_first_implementation_and_second_interface_implementation_when_second_implementation_as_second_parameter() {
            var pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new FirstMyInterfaceImpl(),
                    new SecondMyInterfaceImpl());

            var recordPatternExhaustiveSwitch = new RecordPatternExhaustiveSwitch(pair);

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

            var recordPatternExhaustiveSwitch = new RecordPatternExhaustiveSwitch(pair);

            String result = recordPatternExhaustiveSwitch.switchPattern2();

            assertThat(result).isEqualTo("FirstMyInterfaceImpl-FirstMyInterfaceImpl");
        }

        @Test
        void switchPattern_should_return_second_and_first_interface_implementation_when_second_implementation_and_first_implementation_as_parameters() {
            var pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new SecondMyInterfaceImpl(),
                    new FirstMyInterfaceImpl());

            var recordPatternExhaustiveSwitch = new RecordPatternExhaustiveSwitch(pair);

            String result = recordPatternExhaustiveSwitch.switchPattern2();

            assertThat(result).isEqualTo("SecondMyInterfaceImpl-FirstMyInterfaceImpl");
        }

        @Test
        void switchPattern_should_return_second_interface_implementation_twice_when_2_second_implementation_as_parameters() {
            RecordPatternExhaustiveSwitch.Pair<MyInterface> pair = new RecordPatternExhaustiveSwitch.Pair<>(
                    new SecondMyInterfaceImpl(),
                    new SecondMyInterfaceImpl());

            var recordPatternExhaustiveSwitch = new RecordPatternExhaustiveSwitch(pair);

            String result = recordPatternExhaustiveSwitch.switchPattern2();

            assertThat(result).isEqualTo("SecondMyInterfaceImpl-SecondMyInterfaceImpl");
        }
    }
}
