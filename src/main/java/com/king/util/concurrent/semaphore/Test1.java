package com.king.util.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class Test1 {
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        try {
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            System.out.println(semaphore.drainPermits() + " " + semaphore.availablePermits());
            System.out.println(semaphore.drainPermits() + " " + semaphore.availablePermits());
            System.out.println(semaphore.drainPermits() + " " + semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

}
