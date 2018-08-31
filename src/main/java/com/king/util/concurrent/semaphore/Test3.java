package com.king.util.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class Test3 {
    private static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(finalI + ": jin ru");
                    if (finalI == 0 || finalI == 1) {
                        Thread.sleep(1000);
                    } else {
                        Thread.sleep(Integer.MAX_VALUE);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(finalI + ": 释放");
                    semaphore.release();
                }
            }).start();
        }
    }
}
