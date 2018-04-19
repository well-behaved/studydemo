package com.xue.demo;

import java.util.Random;

public class NodeDemo<T> {

    /**
     * 下一节点
     */
    public NodeDemo nextNode;
    /**
     * 当前节点值
     */
    public T  value;

    /**
     * 返回一个随机测试使用的node
     */
    public static  NodeDemo<Integer>  getRandomNodes(){
        NodeDemo<Integer> headNode = new NodeDemo<Integer>(new Random().nextInt(60));
        NodeDemo<Integer> nodeNow = headNode;
        for (int i = 0; i < new Random().nextInt(10)+5; i++) {
            nodeNow.nextNode = new NodeDemo( new Random().nextInt(60));
            nodeNow =  nodeNow.nextNode;
        }
        return headNode;
    }

    /**
     * 从头部遍历node
     */
    public static <T>  String  outNode(NodeDemo<T> headNode){
        if(headNode == null){
            return "空节点";
        }
        if(headNode.nextNode == null){
            return headNode.value+"";
        }else{
           return headNode.value+","+outNode(headNode.nextNode);
        }

    }
    public NodeDemo() {
        super();
    }
    public NodeDemo(T value) {
        this.value = value;
    }

}
