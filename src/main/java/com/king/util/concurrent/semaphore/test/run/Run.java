package com.king.util.concurrent.semaphore.test.run;


import com.king.util.concurrent.semaphore.service.RepastService;

public class Run {

    public static void main(String[] args) {
        RepastService service = new RepastService();
        for (int i = 0; i < 60; i++) {
            new Thread(service::get).start();
        }

        for (int i = 0; i < 60; i++) {
            new Thread(service::set).start();
        }

    }
}
