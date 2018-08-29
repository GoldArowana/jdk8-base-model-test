package com.king.util.concurrent.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(10);

        int ret = num.getAndUpdate((prev) -> {
            return prev + 100;
        });

        System.out.println(ret);
        System.out.println(num.get());


        ////////////////////////////

        AtomicInteger num2 = new AtomicInteger(20);
        int ret2 = num2.getAndAccumulate(300, (prev, x) -> {
            return prev + x + 4000;
        });
        System.out.println(ret2);
        System.out.println(num2.get());


    }
}
