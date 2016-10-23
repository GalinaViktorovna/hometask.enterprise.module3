package com.enterprise.module3;

import java.util.LinkedList;
import java.util.List;

public class Starter {
    private volatile static int counter = 0;
    private static List<Integer> elements = new LinkedList<>();

    public void starter(final  int SIZE) throws InterruptedException {
        final SemaphoreImplementation semaphore = new SemaphoreImplementation(4);
        for (int i = 1; i <= SIZE; i++) {
            Thread thread = new Thread(new Worker(semaphore));
            thread.start();
            

        }
    }

    public List<Integer> getElements() {
        return elements;
    }

    public static class Worker implements Runnable {

        SemaphoreInterface semaphore;

        public Worker(SemaphoreInterface semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                String nameOfCurrentThread = Thread.currentThread().getName();
                System.out.println("Start of thread #" + nameOfCurrentThread);

                semaphore.acquire();
                elements.add(++counter);
                System.out.println("Counter = " + counter + ".\tAvailable permits: " + semaphore.getAvailablePermits());
                System.out.println("Critical section. Thread #" + nameOfCurrentThread + ". Counter = " + counter);

                semaphore.release();
                System.out.println("End of thread #" + nameOfCurrentThread);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}