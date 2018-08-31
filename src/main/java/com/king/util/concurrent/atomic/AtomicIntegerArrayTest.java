package com.king.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        AtomicIntegerArray array = new AtomicIntegerArray(new int[]{1, 3, 5, 7, 9, 11, 13});
        AtomicInteger[] arr = new AtomicInteger[]{new AtomicInteger(1), new AtomicInteger(3), new AtomicInteger(5)};
        System.out.println(arr[1].get());
        arr[1] = new AtomicInteger(10);
        arr[1].compareAndSet(3, 10);
        System.out.println(array.get(2));
    }
}
