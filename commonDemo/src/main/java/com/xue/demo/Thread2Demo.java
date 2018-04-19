package com.xue.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread2Demo implements  Runnable {
    private Lock lock;

    public Thread2Demo(Lock lock) {
        super();
        this.lock = lock;
    }
    public void run() {
       lock.lock();
            System.out.println(Thread.currentThread().getName()+"线程开始执行");
            System.out.println(Thread.currentThread().getName()+"ce1");
            System.out.println(Thread.currentThread().getName()+"ce2");
            System.out.println(Thread.currentThread().getName()+"ce3");
        lock.unlock();
        System.out.println(Thread.currentThread().getName()+"线程结束执行");

    }
}
