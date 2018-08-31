package com.king.util.concurrent.cyclebarrier.test2;

import java.util.concurrent.CyclicBarrier;

public class Test {
    public static void main(String[] args) {
        CyclicBarrier cbRef = new CyclicBarrier(4, () -> System.out.println("彻底结束了"));

        MyService service = new MyService(cbRef);

        Runnable runner = service::testA;

        new MyThread(runner).setThreadName("A").start();
        new MyThread(runner).setThreadName("B").start();
        new MyThread(runner).setThreadName("C").start();
        new MyThread(runner).setThreadName("D").start();

    }

    private static class MyThread extends Thread {
        public MyThread(Runnable runnable) {
            super(runnable);
        }

        public MyThread setThreadName(String threadName) {
            super.setName(threadName);
            return this;
        }
    }
}
