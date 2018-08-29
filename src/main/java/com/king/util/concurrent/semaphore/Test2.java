package com.king.util.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class Test2 {
    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(1);
                    System.out.println(Thread.currentThread().getName() + " begin timer=" + System.currentTimeMillis());
                    int sleepValue = 6000;
//                    int sleepValue = ((int) (Math.random() * 10000));
                    System.out.println(Thread.currentThread().getName() + " 停止了" + (sleepValue / 1000) + "秒");
                    Thread.sleep(sleepValue);
                    System.out.println(Thread.currentThread().getName() + "   end timer=" + System.currentTimeMillis());
                    semaphore.release(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
