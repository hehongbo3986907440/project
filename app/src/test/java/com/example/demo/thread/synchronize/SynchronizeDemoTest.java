package com.example.demo.thread.synchronize;
import java.util.ArrayList;
import java.util.List;
public class SynchronizeDemoTest {
    /**
     * 生产者消费者
     */
    private List<String> collect = new ArrayList<>(10);

    private final SynchronizeDemoTest lock = new SynchronizeDemoTest();

    private void add(String a){

        while (collect.size()<10){
            synchronized (lock){
                collect.add(a);

            }
        }
        System.out.println("add"+collect.size());
    }

    private void remove(){
        while (collect.size()>0){
            synchronized (lock){
                collect.remove(collect.size()-1);
            }
        }
        System.out.println("remove"+collect.size());
    }


    public static void main(String[] args){
        SynchronizeDemoTest data = new SynchronizeDemoTest();
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data.add("test");
                }
            }).start();
        }


        for(int i=0;i<30;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data.remove();
                }
            }).start();
        }
    }
}
