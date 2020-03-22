package com.imooc;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @Author: hfr
 * @Date: 2019-08-25 18:06
 * @Version 1.0
 */
public class Test3 {

    public static void main(String[] args) {
        int h = 6, w = 6;
        for (int i = 0; i < (h + 1) / 2; i++) {
            for (int j = 0; j < w / 2 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i + 1) * 2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(4,4);
        hashMap.put(3,3);
        hashMap.put(1,1);
        hashMap.put(2,2);
        hashMap.put(5,5);
        System.out.println(hashMap);

        System.out.println();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(3,3);
        treeMap.put(1,1);
        treeMap.put(2,2);
        treeMap.put(4,4);
        treeMap.put(5,5);
        System.out.println(treeMap);


    }

    public String cover(int num) {
        if (num >=0 && num < 10) {
            return "0" + num;
        }
        return String.valueOf(num);
    }
}