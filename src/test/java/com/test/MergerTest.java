package com.test;

/**
 * @Author: hfr
 * @Date: 2019-07-22 11:16
 * @Version 1.0
 */
public class MergerTest {

    public static void main(String[] args) {
//        MergerImpl<Integer> merger = new MergerImpl<>(20, 8, (l, r) -> l + r);
//        System.out.println(merger.getSum());

        int l = 2;
        int r = 8;

        System.out.println(l + (r - l));
        System.out.println(l + (r - l) / 2);
    }
}