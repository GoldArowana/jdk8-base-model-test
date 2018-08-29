package com.king.util.concurrent.Atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
    private static AtomicIntegerFieldUpdater<Dog> dogAgeUpdater = getAgeUpdater();

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        System.out.println(dogAgeUpdater.get(dog1));
        System.out.println(dogAgeUpdater.incrementAndGet(dog1));
        System.out.println(dog1.age);

        System.out.println("===================================");

        Dog dog2 = new Dog();
        System.out.println(dogAgeUpdater.get(dog2));
        System.out.println(dogAgeUpdater.decrementAndGet(dog2));
        System.out.println(dog2.age);
    }

    private static AtomicIntegerFieldUpdater<Dog> getAgeUpdater() {
        return AtomicIntegerFieldUpdater.newUpdater(Dog.class, "age");
    }

    static class Dog {
        public volatile Integer age = 10; // AtomicIntegerFieldUpdater 必须是volatile修饰的
    }
}
