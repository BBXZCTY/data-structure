package com.blog.concurrenthashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hfr
 * @Date: 2019-08-17 20:51
 * @Version 1.0
 */
public class MainClass {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> syncMap = Collections.synchronizedMap(hashMap);
        MapHelper1 mapHelper1 = new MapHelper1(syncMap);
        MapHelper2 mapHelper2 = new MapHelper2(syncMap);
        MapHelper3 mapHelper3 = new MapHelper3(syncMap);
        MapHelper4 mapHelper4 = new MapHelper4(syncMap);

        for (Map.Entry<String, Integer> e : syncMap.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }

    }

}