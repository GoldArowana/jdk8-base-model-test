package com.king.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterTest {
    private static final AtomicReferenceFieldUpdater<Dog, Integer> dogAgeUpdater = getDogAgeUpdater();

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        System.out.println(dog1.age);
        System.out.println(dogAgeUpdater.updateAndGet(dog1, (prev) -> prev + 1));

        Dog dog2 = new Dog();
        System.out.println(dog2.age);
        System.out.println(dogAgeUpdater.updateAndGet(dog2, (prev) -> prev - 1));
    }

    private static AtomicReferenceFieldUpdater<Dog, Integer> getDogAgeUpdater() {
        return AtomicReferenceFieldUpdater.newUpdater(Dog.class, Integer.class, "age");
    }

    static class Dog {
        public volatile Integer age = 10;
    }
}
