package com.king.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {
    public static void main(String[] args) {
        AtomicLong num = new AtomicLong(20);
        long ret = num.getAndAccumulate(300, (prev, x) -> {
            return prev + x + 4000;
        });
        System.out.println(ret);
        System.out.println(num.get());
    }
}
