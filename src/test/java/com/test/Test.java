package com.test;

import java.util.Scanner;

/**
 * @Author: hfr
 * @Date: 2019-05-20 16:25
 * @Version 1.0
 * 二分查找
 */
public class Test {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        // 从键盘接收数据
        Scanner scan = new Scanner(System.in);
        Integer x = (int)(1+Math.random()*(100-1+1));
//        System.out.println(x);
        System.out.println("请输入数字：");
        while (scan.hasNextInt()) {
            int in = scan.nextInt();
//            System.out.println("输入的数字为： " + in);
            if (in < x) {
                System.out.println("小了, 请继续输入数字：");
                continue;
            } else if (in > x) {
                System.out.println("大了，请继续输入数字：");
                continue;
            } else {
                System.out.println("正确");
                break;
            }
        }
        scan.close();
    }

    private static void test1() {
        // 从键盘接收数据
        Scanner scan = new Scanner(System.in);
        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }

}