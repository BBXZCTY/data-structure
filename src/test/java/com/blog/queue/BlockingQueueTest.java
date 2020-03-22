package com.blog.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: hfr
 * @Date: 2019-06-28 17:54
 * @Version 1.0
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueueTest.testBasket();
    }

    //　测试方法
    public static void testBasket() {
        // 建立一个装苹果的篮子
        final Basket basket = new Basket();
        // 定义苹果生产者
        class Producer implements Runnable {
            public void run() {
                try {
                    while (true) {
                        // 生产苹果
                        System.out.println("生产者准备生产苹果："
                                + System.currentTimeMillis());
                        basket.produce();
                        System.out.println("生产者生产苹果完毕："
                                + System.currentTimeMillis());
                        System.out.println("生产完后有苹果："+basket.getAppleNumber()+"个");
                        // 休眠300ms
                        Thread.sleep(300);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
        // 定义苹果消费者
        class Consumer implements Runnable {
            public void run() {
                try {
                    while (true) {
                        // 消费苹果
                        System.out.println("消费者准备消费苹果："
                                + System.currentTimeMillis());
                        basket.consume();
                        System.out.println("消费者消费苹果完毕："
                                + System.currentTimeMillis());
                        System.out.println("消费完后有苹果："+basket.getAppleNumber()+"个");
                        // 休眠1000ms
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        service.submit(producer);
        service.submit(consumer);
        // 程序运行10s后，所有任务停止
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        service.shutdownNow();
    }

}