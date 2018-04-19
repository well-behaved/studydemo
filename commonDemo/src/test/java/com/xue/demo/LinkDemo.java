package com.xue.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 单链表测试
 */
public class LinkDemo {
    NodeDemo<Integer> headNode;
    @Before
    public void initHeadNode(){
        headNode = NodeDemo.getRandomNodes();
        System.out.println("原始链表为："+NodeDemo.outNode(headNode));
    }
    /**
     * 链表递归反转
     */
    @Test
    public void nodeBack(){
        if(headNode == null) {

        }else{
            backNode(headNode);
        }

    }
    private void backNode(NodeDemo<Integer> headNode) {

        if(headNode.nextNode == null){//如果是最后一个
            this.headNode = headNode; //返回新的头部
            return ;
        }else {
            NodeDemo beforeNode = headNode;
            backNode(headNode.nextNode);
            headNode.nextNode.nextNode = beforeNode; // 反转
            headNode.nextNode = null; // 头结点置为空
        }
    }

    /**
     * 查找单链表倒数第k个节点
     */
    @Test
    public void getk(){
        System.out.println("倒数第2个节点为:"+getk(headNode,2).value);
    }

    private NodeDemo<Integer> getk(NodeDemo<Integer> headNode,int k) {
        if(headNode==null || k<0){
            return null;
        }
        NodeDemo oneNode = headNode;
        NodeDemo tweNode = headNode;
        int i = 1;
       while (oneNode.nextNode != null){
           oneNode = oneNode.nextNode;
           if(i>=k){
               tweNode = tweNode.nextNode;
           }
           i++;
       }
       if(i<k){
            return null;
       }
        return tweNode;
    }

    @After
    public void outHeadNode(){
        System.out.println("改后链表为："+NodeDemo.outNode(headNode));
    }

}
