package com.egorbarinov.lesson03;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyCounterLock {

    public static Lock lock = new ReentrantLock();
    public static long count = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 3000; i++) {
            new Thread(() -> {
                lock.lock();
                System.out.println(++count);
                lock.unlock();
            }).start();
        }
    }
}
