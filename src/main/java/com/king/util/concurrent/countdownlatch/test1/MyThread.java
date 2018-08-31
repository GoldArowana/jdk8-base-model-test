package com.king.util.concurrent.countdownlatch.test1;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {

    private CountDownLatch comingTag;// 裁判等待所有运动员到来
    private CountDownLatch waitTag;// 等待裁判说准备开始
    private CountDownLatch waitRunTag;// 等待起跑
    private CountDownLatch beginTag;// 起跑
    private CountDownLatch endTag;// 所有运动员到达终点

    public MyThread(CountDownLatch comingTag, CountDownLatch waitTag,
                    CountDownLatch waitRunTag, CountDownLatch beginTag,
                    CountDownLatch endTag) {
        super();
        this.comingTag = comingTag;
        this.waitTag = waitTag;
        this.waitRunTag = waitRunTag;
        this.beginTag = beginTag;
        this.endTag = endTag;
    }

    @Override
    public void run() {
        try {
            System.out.println("运动员使用不同交通工具不同速度到达起跑点，正向这头走！");
            Thread.sleep((int) (Math.random() * 10000));
            System.out.println(Thread.currentThread().getName() + "到起跑点了！");
            comingTag.countDown();
            System.out.println("等待裁判说准备！");
            waitTag.await();
            System.out.println("各就各位！准备起跑姿势！");
            Thread.sleep((int) (Math.random() * 10000));
            waitRunTag.countDown();
            beginTag.await();
            System.out.println(Thread.currentThread().getName() + " 运行员起跑 并且跑赛过程用时不确定");
            Thread.sleep((int) (Math.random() * 10000));
            endTag.countDown();
            System.out.println(Thread.currentThread().getName() + " 运行员到达终点");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
