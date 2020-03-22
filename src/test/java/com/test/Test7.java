package com.test;

/**
 * @Author: hfr
 * @Date: 2019-09-12 14:15
 * @Version 1.0
 */
public class Test7 {

    private static void test666() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }


    public static void main(String[] args) {
        test666();
    }
}