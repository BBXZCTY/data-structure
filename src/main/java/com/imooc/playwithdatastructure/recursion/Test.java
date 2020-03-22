package com.imooc.playwithdatastructure.recursion;

/**
 * @Author: hfr
 * @Date: 2019-08-10 18:31
 * @Version 1.0
 */
public class Test {

    public String test (String s) {
        String str = s;
        str = str + "hello";

        return s;
    }

    public int test2(int i) {
        int j = i;
        j = j + 10;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Test().test("abc"));
        System.out.println(new Test().test2(10));
    }

}