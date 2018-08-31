package com.king.util.concurrent.phaser.test2;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        PrintTools.phaser = phaser;

        new MyThread(PrintTools::methodA).setThreadName("A").start();
        new MyThread(PrintTools::methodA).setThreadName("B").start();
        new MyThread(PrintTools::methodB).setThreadName("C").start();

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
