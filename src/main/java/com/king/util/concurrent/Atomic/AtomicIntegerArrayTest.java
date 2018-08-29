package com.king.util.concurrent.Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        AtomicIntegerArray array = new AtomicIntegerArray(new int[]{1, 3, 5, 7, 9, 11, 13});
        System.out.println(array.get(2));
    }
}
