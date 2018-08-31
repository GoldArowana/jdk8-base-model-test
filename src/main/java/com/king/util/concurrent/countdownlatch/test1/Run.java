package com.king.util.concurrent.countdownlatch.test1;

import java.util.concurrent.CountDownLatch;

public class Run {

    public static void main(String[] args) {
        try {
            CountDownLatch comingTag = new CountDownLatch(10);
            CountDownLatch waitTag = new CountDownLatch(1);
            CountDownLatch waitRunTag = new CountDownLatch(10);
            CountDownLatch beginTag = new CountDownLatch(1);
            CountDownLatch endTag = new CountDownLatch(10);

            MyThread[] threadArray = new MyThread[10];
            for (int i = 0; i < threadArray.length; i++) {
                threadArray[i] = new MyThread(comingTag, waitTag, waitRunTag, beginTag, endTag);
                threadArray[i].start();
            }
            System.out.println("裁判员在等待选手的到来！");
            comingTag.await();
            System.out.println("裁判看到所有运动员来了，各就各位前“巡视”用时5秒");
            Thread.sleep(5000);
            waitTag.countDown();
            System.out.println("各就各位！");
            waitRunTag.await();
            Thread.sleep(2000);
            System.out.println("发令枪响起！");
            beginTag.countDown();
            endTag.await();
            System.out.println("所有运动员到达，统计比赛名次！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
