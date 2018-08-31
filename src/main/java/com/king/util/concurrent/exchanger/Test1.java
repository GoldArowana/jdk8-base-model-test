package com.king.util.concurrent.exchanger;

import java.util.concurrent.Exchanger;


public class Test1 {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();
        new Thread(() -> {
            try {
                System.out.println("在线程A中得到线程B的值=" + exchanger.exchange("中国人A"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("在线程B中得到线程A的值=" + exchanger.exchange("中国人B"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
