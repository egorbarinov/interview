package com.egorbarinov.lesson03;

import java.util.concurrent.atomic.AtomicLong;

public class MyAtomicCounter {

    public static AtomicLong count = new AtomicLong(0);
    public static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        synchronized (object) {

            for (int i = 0; i < 30; i++) {
                new Thread(() -> {
                    synchronized (object) {
                          count.incrementAndGet();
                        System.out.println(count.get());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }

    }
}
