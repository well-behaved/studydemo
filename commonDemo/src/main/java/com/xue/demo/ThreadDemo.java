package com.xue.demo;

public class ThreadDemo implements  Runnable {
    public void run() {
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"线程开始执行");
            System.out.println(Thread.currentThread().getName()+"ce1");
            System.out.println(Thread.currentThread().getName()+"ce2");
            System.out.println(Thread.currentThread().getName()+"ce3");
        }
        System.out.println(Thread.currentThread().getName()+"线程结束执行");

    }
}
