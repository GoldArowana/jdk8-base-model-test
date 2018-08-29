package com.king.util.concurrent.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListPool {

    private int poolMaxSize = 5;
    private int semaphorePermits = 5;
    private List<String> list = new ArrayList<>();
    private Semaphore concurrencySemaphore = new Semaphore(semaphorePermits);
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public ListPool() {
        super();
        for (int i = 0; i < poolMaxSize; i++) {
            list.add("高洪岩" + (i + 1));
        }
    }

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

    public String get() {
        String getString = null;
        try {
            concurrencySemaphore.acquire();
            lock.lock();
            while (list.size() == 0) {
                condition.await();
            }
            getString = list.remove(0);
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getString;
    }

    public void put(String stringValue) {
        lock.lock();
        list.add(stringValue);
        condition.signalAll();
        lock.unlock();
        concurrencySemaphore.release();
    }
}
