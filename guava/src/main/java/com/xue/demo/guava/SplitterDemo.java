package com.xue.demo.guava;

import com.google.common.base.Splitter;

import java.util.Iterator;

/**
 * @description:
 * @author: xuexiong
 * @date: 2025/5/26 11:14
 */
public class SplitterDemo {
    public static void main(String[] args) {
        //自定义遍历器例子
        MyIterator myIterator = new MyIterator("foo,bar,,   qux");
        for (String oneString :myIterator) {
            System.out.println("forEach1:"+oneString);
        }
        for (String oneString :myIterator) {
            System.out.println("forEach2:"+oneString);
        }

        //输出分隔线
        System.out.println("------------------");
        /*
        状态模式（State Pattern）的应用
        流式 API 的设计思路
        不可变对象在工具类中的使用
         */
        Iterable<String> split = Splitter.on(',')// 工厂方法（工厂模式）
                .trimResults()// 链式配置（构建者模式）
                .omitEmptyStrings()// 链式配置（构建者模式）
                .split("foo,bar,,   qux");// 返回 Iterable，由 SplittingIterator 实现遍历（迭代器模式）
        for (String s : split) {
            System.out.println(s);
        }


    }
}
/*
自定义 遍历器 例子
按照逗号分隔输出字符串
 */
class MyIterator implements Iterator<String>,Iterable<String> {
    //当前遍历角标
    private int indexNow = 0;
    private String word;
    public MyIterator(String word) {
        this.word = word;
    }
    @Override
    public boolean hasNext() {
        if (indexNow < word.length()) {
            return true;
        }else {
            return false;
        }
    }
    @Override
    public String next() {
        //根据逗号分隔返回 遍历器实现
        StringBuilder sb = new StringBuilder();
        for (int i = indexNow; i < word.length(); i++) {
            if (word.charAt(i) == ',') {
                indexNow = i + 1;
                return sb.toString();
            }else {
                sb.append(word.charAt(i));
            }
        }
        //如果已经到末尾了 那么indexNow +1
        indexNow = word.length() + 1;

        return sb.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator(word);
    }
}
