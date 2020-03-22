package com.imooc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author: hfr
 * @Date: 2019-08-12 15:28
 * @Version 1.0
 */
public class Test {

    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash


    public static void main(String[] args) {
        System.out.println(new BigDecimal(100.12).setScale(2, RoundingMode.HALF_UP).toString());
        Person.test();

        int a = 3;
        System.out.println(a << 2);

        boolean red = false;
        boolean black = false;
        System.out.println(red || black);

        System.out.println(Collections.synchronizedMap(new HashMap<>()));

        String key = "test23242432";
        int hash = spread(key.hashCode());
        System.out.println(hash);

    }

    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
}