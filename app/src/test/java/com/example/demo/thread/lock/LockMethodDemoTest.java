package com.example.demo.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMethodDemoTest {
    private Lock lock = new ReentrantLock();

    public void m(){
        try{
            lock.lock();
            Thread.sleep(3000);
            System.out.println("m_________________");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void n(){
        boolean flag = false;
        try {
//            flag = lock.tryLock(2000, TimeUnit.MILLISECONDS);
            lock.lock();
            flag = true;
            System.out.println("n-------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(flag){
                lock.unlock();
            }
        }
    }
    
    
    public static void main(String[] args){
        LockMethodDemoTest demo = new LockMethodDemoTest();
        ExecutorService executorsService = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorsService.submit(new Runnable() {
                @Override
                public void run() {
                    demo.m();
                }
            });
        }


        for(int i=0;i<5;i++){
            executorsService.submit(new Runnable() {
                @Override
                public void run() {
                    demo.n();
                }
            });
        }
    }
}
