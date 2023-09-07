package org.example.virtual_thread;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualThreadsExampleTest {

    @Test
    void execute_should_start_a_virtual_thread() {
        var virtualThreadsExample = new VirtualThreadsExample();

        virtualThreadsExample.main();
    }
}
