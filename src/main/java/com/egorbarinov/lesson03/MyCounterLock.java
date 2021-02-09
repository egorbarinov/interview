package com.egorbarinov.lesson03;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyCounterLock {

    public static Lock lock = new ReentrantLock();
    public static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                lock.lock();
                count.incrementAndGet();
                System.out.println(count.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }).start();
        }
    }
}
