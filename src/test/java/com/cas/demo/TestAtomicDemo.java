package com.cas.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: hfr
 * @Date: 2019-08-19 17:27
 * @Version 1.0
 */
public class TestAtomicDemo {

    public static void main(String[] args) {
//      int  i = 1;
//      i = i++;
//      System.out.println(i);
//              输出1

        AtomicDemo ad = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }

}

class AtomicDemo implements Runnable{

    //  当多线程操作时，volatile关键字无法保证原子性
    //  private volatile int serialNumber = 0;

    private AtomicInteger serialNumber = new AtomicInteger(0);

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        System.out.println(getSerialNumber());
    }

    public int getSerialNumber(){
//      return serialNumber++;

        return serialNumber.getAndIncrement();
    }

}