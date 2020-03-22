package com.imooc;

/**
 * @Author: hfr
 * @Date: 2019-08-15 09:45
 * @Version 1.0
 *
 *
 * ^
 * true  ^ true   =
 * true  ^ false  =
 * false ^ true   =
 * false ^ false  =
 *
 * ||
 *
 *
 */
public class Test2 {

    public static void main(String[] args) {
        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ true);
        System.out.println(false ^ false);
        System.out.println();
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);
    }

}