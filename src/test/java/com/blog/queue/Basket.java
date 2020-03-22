package com.blog.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: hfr
 * @Date: 2019-06-28 17:53
 * @Version 1.0
 * 定义装苹果的篮子
 */
public class Basket {

    // 篮子，能够容纳3个苹果
    BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

    // 生产苹果，放入篮子
    public void produce() throws InterruptedException{
        // put方法放入一个苹果，若basket满了，等到basket有位置
        basket.put("An apple");
    }
    // 消费苹果，从篮子中取走
    public String consume() throws InterruptedException{
        // get方法取出一个苹果，若basket为空，等到basket有苹果为止
        String apple = basket.take();
        return apple;
    }

    public int getAppleNumber(){
        return basket.size();
    }


}