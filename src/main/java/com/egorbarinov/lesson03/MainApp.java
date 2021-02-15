package com.egorbarinov.lesson03;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainApp {

    public static class ThreadSafeCounter {

        private Lock lock;
        private int value;

        public ThreadSafeCounter() {
            this.lock = new ReentrantLock();
        }

        private void increment() {
            try {
                lock.lock();
                value++;
            } finally {
                lock.unlock();
            }
        }

        private void decrement() {
            try {
                lock.lock();
                value--;
            } finally {
                lock.unlock();
            }
        }

        public int get() {
            return value;
        }

    }

    public static void main(String[] args) {
        ThreadSafeCounter counter = new ThreadSafeCounter();

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10 ; i++) {
            service.execute(() -> {
                for (int j = 0; j < 10000; j++) {
                    counter.increment();
                }
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(counter.get());
        }





    }
}
