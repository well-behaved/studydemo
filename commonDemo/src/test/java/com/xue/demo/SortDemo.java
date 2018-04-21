package com.xue.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortDemo {
    public int[] demoArrey;
    @Before
    public void init(){
        demoArrey = new int[]{12,52,6345,11,25,41,52,63,99};
        System.out .println("初始数组："+Arrays.toString(demoArrey));
    }

    /**
     * 冒泡排序
     */
    @Test
    public void sortDemo1(){
        System.out .println("冒泡排序");
        if(demoArrey!=null){
            for (int i = 0; i <demoArrey.length ; i++) {
                for (int j = 0; j <demoArrey.length-1-i ; j++) {
                    if(demoArrey[j]>demoArrey[j+1]){
                        int temp = demoArrey[j];
                        demoArrey[j] = demoArrey[j+1];
                        demoArrey[j+1] = temp;
                    }
                }

            }
        }
    }

    /**
     * 插入排序
     */
    @Test
    public void sortDemo2(){
        System.out .println("插入排序");
        for (int i = 1; i <demoArrey.length ; i++) {
            int j = i;
            int temp = demoArrey[j];
            while(j>0 && temp<demoArrey[j-1]){
                demoArrey[j] = demoArrey[j-1];
                j--;
            }
            demoArrey[j]=temp;
        }
    }

    /**
     * 快排序
     */
    @Test
    public void sortDemo3(){
        sortyy(demoArrey,0,demoArrey.length-1);
    }

    private void sortyy(int[] demoArrey,int beginIndex,int endIndex) {
        int begin = beginIndex;
        int end =endIndex;
        if(begin>=end){
            return;
        }
        int tempIndex = beginIndex;
        while(beginIndex<endIndex){
            //右边边比较
            while(beginIndex<endIndex){
                if(demoArrey[endIndex]<demoArrey[tempIndex]){
                        int temp = demoArrey[endIndex];
                        demoArrey[endIndex] = demoArrey[tempIndex];
                        demoArrey[tempIndex] = temp;
                        break;
                }
                endIndex--;
            }
            //左边边边比较
            while(beginIndex<endIndex){
                if(demoArrey[beginIndex]>demoArrey[tempIndex]){
                    int temp = demoArrey[beginIndex];
                    demoArrey[beginIndex] = demoArrey[tempIndex];
                    demoArrey[tempIndex] = temp;
                    break;
                }
                beginIndex++;
            }
            //左边
            sortyy(demoArrey,begin,beginIndex);
            //右边
            sortyy(demoArrey,beginIndex,end);
        }


    }

    @After
    public void end(){
        System.out .println("排序后："+Arrays.toString(demoArrey));
    }
}
