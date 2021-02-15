package com.egorbarinov.lesson03;

import java.util.concurrent.locks.Lock;

public class PingPong {

    public static volatile boolean isAvailable = false;
    public static int count = 4000;
    public Lock lock;

    public static void main(String[] args) {

        while (count != 0) {
            if (!isAvailable) {
                new Thread(() -> System.out.println("Ping")).start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isAvailable = true;
            }
            if (isAvailable) {
                new Thread(() -> System.out.println("Pong")).start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isAvailable = false;
            }
            count--;
        }

    }
}
