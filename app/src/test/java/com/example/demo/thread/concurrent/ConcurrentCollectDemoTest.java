package com.example.demo.thread.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentCollectDemoTest {
    private BlockingQueue queue = new LinkedBlockingQueue(10);

    private void produce(String name){
        try {
            queue.put(name);
            System.out.println(name+"-"+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consume(String name){
        try {
            queue.take();
            System.out.println(name+"-"+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private class Producer implements Runnable{
        private ConcurrentCollectDemoTest data;
        private String name;

        public Producer(){}

        public Producer(ConcurrentCollectDemoTest data,String name){
            this.data = data;
            this.name = name;
        }
        @Override
        public void run() {
            while (true){
                data.produce(name);
            }
        }
    }


    private class Consumer implements Runnable{
        private ConcurrentCollectDemoTest data;
        private String name;

        public Consumer(){}

        public Consumer(ConcurrentCollectDemoTest data,String name){
            this.data = data;
            this.name = name;
        }
        @Override
        public void run() {
            while(true){
                data.consume(name);
            }
        }
    }

    public static void main(String[] args){
        ConcurrentCollectDemoTest data = new ConcurrentCollectDemoTest();
        for(int i=0 ;i<5; i++){
            new Thread(data.new Producer(data,"生产者"+i)).start();
        }

        for(int i=0 ;i<5; i++){
            new Thread(data.new Consumer(data,"消费者"+i)).start();
        }
    }
}
