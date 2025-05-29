package com.xue.demo.guava;

import com.google.common.collect.ImmutableList;

import java.util.Iterator;
import java.util.List;

/**
 * @description: 不可变对象设计
 * @author: xuexiong
 * @date: 2025/5/27 18:06
 */
public class ImmutableListDemo {
    public static void main(String[] args) {
        //不可变    不可变对象一旦创建，就不能再被修改 不可以新增 也不可以删除 但是可以修改
        ImmutableList<String> immutableList = ImmutableList.of("a", "b", "c");
        ImmutableList.Builder<Object> add = ImmutableList.builder().add("d");
        //输出
        System.out.println(immutableList);
        //测试不可变 UnsupportedOperationException
//        immutableList.add("d");
        //删除尝试
        //UnsupportedOperationException: remove
//        immutableList.removeIf("a"::equals);
        System.out.println(immutableList);
    }
}
