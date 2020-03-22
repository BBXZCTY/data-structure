package com.test;

import javafx.scene.shape.VLineTo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: hfr
 * @Date: 2019-09-04 16:55
 * @Version 1.0
 */
public class TestJunit {

    @Test
    public void test01() {
        List<Integer> list = new LinkedList<>();

        do {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
            System.out.println(list.size());
//            Iterator<Integer> iterator = list.iterator();
//            for (;iterator.hasNext();) {
//                Integer integer = iterator.next();
////                System.out.println(integer);
//                System.out.println(list.size());
//            }
        } while (list.size() == 10);
    }

    @Test
    public void test02() {
        int i = 0;
        do {
            i ++;
            System.out.println(i);
        } while (i <= 5);
    }

    @Test
    public void test03() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        System.out.println("=============");
        Iterator<Integer> iterator = list.iterator();
        for (;iterator.hasNext();) {
            Integer next = iterator.next();
            System.out.println("next = " + next);
            System.out.println("size = " + list.size());
        }
        System.out.println("=============");

    }

    @Test
    public void test04() {
        Bird b1 = new Bird("zhangsan");
        Bird b2 = b1;
        System.out.println(b1);
        System.out.println(b2);
        b2.setName("lisi");
        System.out.println("==========");
        System.out.println(b1);
        System.out.println(b2);

        System.out.println("==========");

        String s1 = "zhangsan";
        String s2 = s1;
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("==========");
        s1 = "lisi";
        System.out.println(s1);
        System.out.println(s2);

    }

    @Test
    public void test05() {
        ArrayList<Integer> list = new ArrayList<>(5);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list.size());
    }

    @Test
    public void test06() {

        String key = "name";

        int keyHashCode = key.hashCode();

        System.out.println("keyHashCode = " + keyHashCode);

        int hash = spread(keyHashCode);

        System.out.println("hash = " + hash);



        int n = 3;
        int i = (n - 1) & hash;

        System.out.println("i = " + i);
    }

    static int spread(int h) {
        int HASH_BITS = 0x7fffffff;
        System.out.println("HASH_BITS = " + HASH_BITS);
        return (h ^ (h >>> 16)) & HASH_BITS;
    }

    @Test
    public void test07() {
        B b = new B();
        System.out.println(b instanceof A);
        System.out.println(b instanceof C);
    }

    @Test
    public void test08() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("zhangsan", 23);
        concurrentHashMap.put("zhangsan", 24);
        for (int i = 0; i < 200; i++) {
            concurrentHashMap.put("zhangsan_" + i, i);
        }
        concurrentHashMap.put("lisi", 18);
        System.out.println(concurrentHashMap);
    }

    @Test
    public void test09() {
        System.out.println(1 << 30);
    }


}


interface A {}

class B extends C implements A {}

class C {}