package com.king.util.concurrent.semaphore;

public class TestPool {

    public static void main(String[] args) {
        ListPool pool = new ListPool();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                String getString = pool.get();
                System.out.println(Thread.currentThread().getName() + " 取得值 " + getString);
                pool.put(getString);
            }).start();
        }
    }
}
