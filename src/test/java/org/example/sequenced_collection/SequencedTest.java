package org.example.sequenced_collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SequencedTest {

    private Sequenced sequenced;

    @BeforeEach
    void setUp() {
        sequenced = new Sequenced();
    }

    @Test
    void get_should_return_5_elements_in_ascending_order() {
         var list = sequenced.get();

        assertThat(list).contains(1, 2, 3, 4, 5);
    }

    @Test
    void reverse_should_return_5_elements_in_descending_order() {
         var list = sequenced.reverse();

        assertThat(list).contains(5, 4, 3, 2, 1);
    }

    @Nested
    class Last {
        @Test
        void getLast_should_return_5() {
            Integer last = sequenced.getLast();

            assertThat(last).isEqualTo(5);
        }

        @Test
        void addLast_should_add_6_to_the_end() {
            sequenced.addLast(6);

            var last = sequenced.getLast();

            assertThat(last).isEqualTo(6);
        }

        @Test
        void removeLast_should_remove_5_at_the_end() {
            sequenced.removeLast();

            var last = sequenced.getLast();

            assertThat(last).isEqualTo(4);
        }
    }

    @Nested
    class First {
        @Test
        void getFirst_should_return_1() {
            Integer first = sequenced.getFirst();

            assertThat(first).isEqualTo(1);
        }

        @Test
        void addFirst_should_add_0_to_the_beginning() {
            sequenced.addFirst(0);

            var first = sequenced.getFirst();

            assertThat(first).isEqualTo(0);
        }

        @Test
        void removeFirst_should_add_1_at_the_beginning() {
            sequenced.removeFirst();

            var first = sequenced.getFirst();

            assertThat(first).isEqualTo(2);
        }
    }
}
