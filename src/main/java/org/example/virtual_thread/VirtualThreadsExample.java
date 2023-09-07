package org.example.virtual_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class VirtualThreadsExample {

    void main() {
        Runnable runnable = () -> System.out.println("Inside Runnable");

        //1
        Thread.startVirtualThread(runnable);

        //2
        Thread virtualThread = Thread.ofVirtual().start(runnable);

        //2.1
        ThreadFactory virtualThreadFactory = Thread.ofVirtual()
                .name("prefix", 0)
                .factory();

        Thread factoryThread = virtualThreadFactory.newThread(runnable);
        factoryThread.start();

        //3
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(runnable);
    }
}
