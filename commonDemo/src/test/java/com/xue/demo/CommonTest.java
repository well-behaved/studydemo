package com.xue.demo;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class CommonTest {
    @Test
    public void dmeo4(){
        CountDownLatch CountDownLatch = new CountDownLatch(10);
        try {
            CountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo3(){
        System.out.println( "beign");
        Thread2Demo ThreadDemo2 = new Thread2Demo(new ReentrantLock());
        Thread thread1 = new Thread(ThreadDemo2);
        Thread thread2 = new Thread(ThreadDemo2);
        thread1.start();
        thread2.start();
        while(true){
            System.out.println("end");

        }
    }
    @Test
    public void demo2(){
        System.out.println( "beign");
        ThreadDemo ThreadDemo = new ThreadDemo();
        Thread thread1 = new Thread(ThreadDemo);
        Thread thread2 = new Thread(ThreadDemo);
        thread1.start();
        thread2.start();
        while(true){
                System.out.println("end");

        }
    }



    @Test
    public void stringDemo(){
        String s = new String();
        StringBuffer sb = new StringBuffer();
        Set<String> mapDemo = new HashSet();
        mapDemo.add("demo");
        LinkedHashSet<String> demo = new LinkedHashSet();
        demo.add("sdf");
        TreeSet setDemo = new TreeSet();

        Integer demo1 = 100;
        int demo2 = 100;

        Integer demo3 = 10000;
        int demo4 = 10000;

        Integer demo5 = 100;
        Integer demo6 = 100;

        Integer demo7 = 10000;
        Integer demo8 = 10000;

        int demo10=10000;
        int demo9=10000;
        System.out.println(demo1==demo2);
        System.out.println(demo3==demo4);
        System.out.println(demo5==demo6);
        System.out.println(demo7==demo8);
        System.out.println(demo9==demo10);
    }
}

