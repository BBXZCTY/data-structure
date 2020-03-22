package com.hashmap;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: hfr
 * @Date: 2019-08-15 10:53
 * @Version 1.0
 */
public class ConcurrentHashMapTest {

    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash

    // Unsafe mechanics
    private transient volatile int sizeCtl;

    private static final long SIZECTL;


    private Thread thread;

    static  {
        SIZECTL = 20;
    }




    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("zhangsan", 23);
        concurrentHashMap.put("zhangsan", 24);
        concurrentHashMap.put("lisi", 24);
        concurrentHashMap.put("wangwu", 25);
        concurrentHashMap.put("maliu", 26);
        for (int i = 0; i < 10; i++) {
            concurrentHashMap.put("key_" + i, i);
        }
        System.out.println(concurrentHashMap);




//        final ConcurrentHashMapTest concurrentHashMapTest = new ConcurrentHashMapTest();
//        for (int i = 0; i < 10; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        concurrentHashMapTest.test();
//                    } catch (NoSuchFieldException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }).start();
//        }
        new ConcurrentHashMapTest().test();


    }

    public void test() throws NoSuchFieldException, IllegalAccessException {
        int sc = 0;
        if ((sc = sizeCtl) < 0) {
            System.out.println(666);
        }
        System.out.println(sc);


//        String key = "zhangsan";
//        int h = key.hashCode();
//        System.out.println("hashcode = " + h);
//        int hash = (h ^ (h >>> 16)) & HASH_BITS;
//        System.out.println(HASH_BITS);
//        System.out.println("hash = " + hash);
//
//        int length, n = 16;
//        int i = (n - 1) & hash;
//        System.out.println("index = " + i);
//
//        System.out.println(-1>>>2);
//        System.out.println(2^4);

        sizeCtl = 20;
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe U = (Unsafe) f.get(null);
        System.out.println(U.compareAndSwapInt(this, SIZECTL, sc, -1));
        System.out.println("sizeCtl = " + sizeCtl);
        System.out.println("sc = " + sc);


    }

}