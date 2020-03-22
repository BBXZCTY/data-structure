package com.cas.demo;

/**
 * @Author: hfr
 * @Date: 2019-08-19 17:27
 * @Version 1.0
 */
public class TestCompareAndSwap {


    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expectedValue = cas.get();
                int random = (int)(Math.random() * 101);
                System.out.println("expectedValue = " + expectedValue + ", random = " + random
                        + ", boolean = " + cas.compareAndSet(expectedValue, random) + ", cas.get() = " + cas.get());
            }).start();
        }
    }
}

class CompareAndSwap{
    private int value;

    //获取内存值
    public synchronized int get(){
        return value;
    }

    //比较
    public synchronized int compareAndSwap(int expectedValue, int newValue){
        int oldValue = value;

        if(oldValue == expectedValue){
            this.value = newValue;
        }

        return oldValue;
    }

    //设置
    public synchronized boolean compareAndSet(int expectedValue, int newValue){
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}