package com.xue.demo;

import org.junit.Before;
import org.junit.Test;

public class TreeDemo {
    TwoTreeDemo<Integer> headNode;
    @Before
    public void initHeadNode(){
        headNode = TwoTreeDemo.initTree();
        System.out.println("                               20");
        System.out.println("                  10                        32");
        System.out.println("            12          32                         21");
        System.out.println("       52    63            15");
        System.out.println("-------------------------------------");
    }

    /**
     * 先序遍历  中 左 右
     */
    @Test
    public void demo1(){
        if(headNode !=null){
            qianOut(headNode);
        }
    }
    private void qianOut(TwoTreeDemo<Integer> headNode) {
       if(headNode!=null){
           System.out.print(headNode.value+",");
           if(headNode.leftNode!=null){
               qianOut(headNode.leftNode);
           }if(headNode.rightNode!=null){
               qianOut(headNode.rightNode);
           }
       }
    }
}
