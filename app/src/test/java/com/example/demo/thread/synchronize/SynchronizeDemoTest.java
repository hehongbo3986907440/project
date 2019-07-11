package com.example.demo.thread.synchronize;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class SynchronizeDemoTest {
    private final int MAX_SIZE = 10;
    /**
     * 生产者消费者
     */
    private LinkedList<String> collect = new LinkedList<>();

    private synchronized void produce(String name){

        while (collect.size() + 1 > MAX_SIZE){
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        collect.add("test");
        this.notifyAll();
        System.out.println(name+"——"+collect.size());
    }

    private synchronized void consume(String name){
        while (collect.size() == 0){
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        collect.remove();
        this.notifyAll();
        System.out.println(name+"——"+collect.size());
    }


    public static void main(String[] args){
        SynchronizeDemoTest data = new SynchronizeDemoTest();
        for(int i=0;i<5;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true){
//                        try {
//                            Thread.sleep(1000);
//                            data.produce("test");
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }).start();
            new Thread(data.new Producer(data,"生产者"+i)).start();
        }
//
//
        for(int i=0;i<5;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while(true){
//                        try {
//                            Thread.sleep(3000);
//                            data.consume();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }).start();
            new Thread(data.new Consumer(data,"消费者"+i)).start();
        }

    }

    private class Producer implements Runnable{
        private SynchronizeDemoTest data;
        private String name;
        public Producer(){

        }
        public Producer (SynchronizeDemoTest data,String name){
            this.data = data;
            this.name = name;
        }
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    data.produce(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Consumer implements Runnable{
        private SynchronizeDemoTest data;
        private String name;
        public Consumer(){

        }
        public Consumer (SynchronizeDemoTest data,String name){
            this.data = data;
            this.name = name;
        }
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(3000);
                    data.consume(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
