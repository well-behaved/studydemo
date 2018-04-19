package com.xue.demo;

import java.util.Random;

/**
 * 二叉树
 */
public class TwoTreeDemo<T> {
    public T value;
    public TwoTreeDemo<T> parentNode;
    public TwoTreeDemo<T> leftNode;
    public TwoTreeDemo<T> rightNode;
    public TwoTreeDemo(T value) {
        this.value = value;
    }
    public static TwoTreeDemo<Integer> initTree(){
        //顶层
        TwoTreeDemo<Integer> headNode = new TwoTreeDemo(20);
        //一层
        headNode.leftNode=new TwoTreeDemo(10);
        headNode.rightNode=new TwoTreeDemo(32);
        //二层
        headNode.leftNode.leftNode=new TwoTreeDemo(12);
        headNode.leftNode.rightNode=new TwoTreeDemo(32);
        headNode.rightNode.rightNode=new TwoTreeDemo(21);
        //三层
        headNode.leftNode.leftNode.leftNode=new TwoTreeDemo(52);
        headNode.leftNode.leftNode.rightNode=new TwoTreeDemo(63);
        headNode.leftNode.rightNode.rightNode=new TwoTreeDemo(15);
        return headNode;
        /*
                                     20
                         10                        32
                   12          32                         21
                52    63          15
         */

    }

}
