package com.imooc;

/**
 * @Author: hfr
 * @Date: 2019-08-13 17:11
 * @Version 1.0
 */
public class Person {

    private int age;
    private String name;

    public Person(int age) {
        this.age = age;
        System.out.println("年龄");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("名字");
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("名字+年龄");
    }

    public Person() {
        System.out.println("空");
    }

    public static void test() {
        System.out.println("test");
    }
}