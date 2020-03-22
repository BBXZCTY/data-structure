package com.blog.concurrenthashmap;

import java.util.Map;

/**
 * @Author: hfr
 * @Date: 2019-08-17 20:49
 * @Version 1.0
 */
public class MapHelper4 implements Runnable {

    Map<String, Integer> map;

    public MapHelper4(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "MapHelper4").start();
    }

    public void run() {
        map.put("four", 2);
        try {
            System.out.println("MapHelper4 sleeping");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}