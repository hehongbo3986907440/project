package com.example.demo.thread.lock;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者，生产者向固定大小的容器中存东西，生产者从容器中取出东西，
 * 为了保证容器满了不能在生产，容器空了不能在消费，需要保证生产和消费是同步的操作
 */
public class LockDemoTest {
    private LinkedList<String> collection = new LinkedList<>();

    private final int MAX_SIZE = 10;
    //锁对象
    private Lock lock = new ReentrantLock();
    //?
    private Condition produceCondition = lock.newCondition();
    //?
    private Condition consumeCondition = lock.newCondition();

    /**
     *
     * @param name
     */
    private void produce(String name){
        lock.lock();//加锁
        try{
            while(collection.size()+1 > MAX_SIZE){//当容器的容量到达上限时
                try {
                    produceCondition.await();//生产者等待，此时阻塞，并释放cpu
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            collection.add("test");//获取CPU后，正常的向容器添加东西
            consumeCondition.signalAll();//唤醒所有的消费者
            produceCondition.signalAll();//唤醒所有的生产者
            System.out.println(name+"——"+collection.size());
        }finally {
            lock.unlock();//解锁（必须的）
        }
    }

    private void consume(String name){
        lock.lock();//加锁
        try{
            while(collection.size() == 0){//当容器的容量到达下限时
                try {
                    consumeCondition.await();//消费者等待，此时阻塞，并释放cpu
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            collection.remove();//获取CPU后，正常的取出容器中东西
            produceCondition.signalAll();//唤醒所有的生产者
            consumeCondition.signalAll();//唤醒所有的消费者
            System.out.println(name+"——"+collection.size());
        }finally {
            lock.unlock();//解锁（必须的）
        }
    }

    private class Producer implements Runnable{
        private LockDemoTest data;
        private String name;
        public Producer(){

        }
        public Producer (LockDemoTest data,String name){
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
        private LockDemoTest data;
        private String name;
        public Consumer(){

        }
        public Consumer (LockDemoTest data,String name){
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

    public static void main(String[] args){
        LockDemoTest data = new LockDemoTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0;i<5;i++){
            executorService.execute(data.new Producer(data,"生产者"+i));
//            new Thread(data.new Producer(data,"生产者"+i)).start();
        }
        for(int i=0;i<5;i++){
            executorService.execute(data.new Consumer(data,"消费者"+i));
//            new Thread(data.new Consumer(data,"消费者"+i)).start();
        }
    }
}
