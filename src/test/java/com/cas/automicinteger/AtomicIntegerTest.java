package com.cas.automicinteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: hfr
 * @Date: 2019-08-19 17:42
 * @Version 1.0
 */
public class AtomicIntegerTest {

    private static final int THREADS_CONUT = 20;
//    public static int count = 0;
    public static volatile int count = 0;

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void increase() {
        count++;
    }

    public static void increase2() {
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    increase();
                    increase2();
                }
            });
            threads[i].start();
        }

//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
        System.out.println(count);
        System.out.println(atomicInteger);
    }

}