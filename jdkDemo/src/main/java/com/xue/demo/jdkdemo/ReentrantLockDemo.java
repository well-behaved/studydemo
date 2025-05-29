package com.xue.demo.jdkdemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: xuexiong
 * @date: 2025/5/27 19:10
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        // 默认非公平锁
        ReentrantLock lock = new ReentrantLock();
        // 获取锁
        lock.lock();
        try {
            System.out.printf("%s 获取到了锁\n", Thread.currentThread().getName());
            // 临界区代码
            sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
            System.out.printf("%s 释放了锁\n", Thread.currentThread().getName());
        }

        /*
        公平锁例子
         */
        // true 设置为公平锁
        ReentrantLock fairLock = new ReentrantLock(true);
        // 获取锁
        fairLock.lock();
        try {
            System.out.printf("%s 获取到了锁\n", Thread.currentThread().getName());
            // 临界区代码
            sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放锁
            fairLock.unlock();
            System.out.printf("%s 释放了锁\n", Thread.currentThread().getName());
        }


    }
    // 模拟耗时操作
    private static void sleep(int i) throws InterruptedException {
        Thread.sleep(i);
    }
}
