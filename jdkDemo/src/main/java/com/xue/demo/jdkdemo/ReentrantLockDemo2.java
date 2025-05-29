package com.xue.demo.jdkdemo;

import static java.lang.Thread.sleep;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: xuexiong
 * @date: 2025/5/29 14:32
 */
public class ReentrantLockDemo2 {
    public static void main(String[] args) {
        // 默认非公平锁
        ReentrantLock lock = new ReentrantLock();
        //第一个线程
        new Thread(() -> {
            lock.lock();
            System.out.printf("%s 获取到了锁\n", Thread.currentThread().getName());
            // 临界区代码
            customSleep(100000000);
            lock.unlock();
        }).start();
        //第二个线程
        new Thread(() -> {
            customSleep(1);
            lock.lock();
            System.out.printf("%s 获取到了锁\n", Thread.currentThread().getName());
            // 临界区代码
            customSleep(1000);
            lock.unlock();
        }).start();
    }
    public static void customSleep(int i) {
        try {
            Thread.sleep(i/1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
