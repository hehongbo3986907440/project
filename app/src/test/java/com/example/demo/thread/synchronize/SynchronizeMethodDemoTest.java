package com.example.demo.thread.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizeMethodDemoTest {
    public synchronized void m(){
        try {
            Thread.sleep(10000);
            System.out.println("m-------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void n(){
        try {
            Thread.sleep(1000);
            System.out.println("n-------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        SynchronizeMethodDemoTest demo = new SynchronizeMethodDemoTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0;i<5;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    demo.m();
                }
            });
        }


        for(int i=0;i<5;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    demo.n();
                }
            });
        }
    }
}
