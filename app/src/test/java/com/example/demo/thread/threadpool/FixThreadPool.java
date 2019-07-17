package com.example.demo.thread.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixThreadPool {
    public ExecutorService executor = Executors.newFixedThreadPool(5);
}
