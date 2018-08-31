package com.king.util.concurrent.cyclebarrier.test2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyService {

    private CyclicBarrier cbRef;

    public MyService(CyclicBarrier cbRef) {
        super();
        this.cbRef = cbRef;
    }

    private void beginRun(int count) {
        try {
            System.out.println(Thread.currentThread().getName() + " 到了 在等待其它人都到了开始起跑");
            if (Thread.currentThread().getName().equals("C")) {
                System.out.println("thread-C中断");
                Thread.sleep(5000);
                Thread.currentThread().interrupt();
            }
            cbRef.await();
//			System.out.println("都到了，开始跑!");
            System.out.println(Thread.currentThread().getName() + " 到达终点，并结束第" + count + "赛段");
        } catch (InterruptedException e) {
            System.out.println("进入了InterruptedException e " + cbRef.isBroken());
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("进入了BrokenBarrierException e " + cbRef.isBroken());
            e.printStackTrace();
        }

    }

    public void testA() {
        // 比赛1个赛段
        for (int i = 0; i < 1; i++) {
            beginRun(i + 1);
        }
    }
}
