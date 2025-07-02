package com.xue.demo.jdkdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // 定义需要等待的任务数量（计数器初始化为3）
        int taskCount = 3;
        CountDownLatch latch = new CountDownLatch(taskCount);

        System.out.println("主线程：启动3个任务，等待所有任务完成...");

        // 创建并启动3个任务线程
        for (int i = 0; i < taskCount; i++) {
            int taskId = i + 1; // 任务编号（1-3）
            new Thread(() -> {
                try {
                    // 模拟任务执行耗时（随机1-3秒）
                    int costTime = ThreadLocalRandom.current().nextInt(1000, 3001);
                    System.out.printf("任务%d：开始执行（预计耗时%dms）\n", taskId, costTime);
                    Thread.sleep(costTime);

                    // 任务执行完成，计数器减1
                    latch.countDown();
                    System.out.printf("任务%d：执行完成，剩余等待任务数：%d\n", taskId, latch.getCount());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 恢复中断状态
                    System.out.println("任务" + taskId + "被中断！");
                }
            }).start();
        }

        // 主线程阻塞等待，直到计数器变为0（所有任务完成）
        latch.await();
        System.out.println("主线程：所有任务完成，开始汇总结果！");
    }
}