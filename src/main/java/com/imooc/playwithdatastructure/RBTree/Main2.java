package com.imooc.playwithdatastructure.RBTree;

import com.imooc.playwithdatastructure.avltree.AVLTree;
import com.imooc.playwithdatastructure.set_and_map.BSTMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * @Author: hfr
 * @Date: 2019-08-28 10:12
 * @Version 1.0
 */
public class Main2 {

    /**
     * BST: 37.790032903 s
     * AVL: 37.62358752 s
     * RBTree: 38.390418942 s
     * @param args
     */
    public static void main(String[] args) {

        // int n = 20000000;
        int n = 20000000;

        Random random = new Random(n);
        ArrayList<Integer> testData = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i ++)
            testData.add(random.nextInt(Integer.MAX_VALUE));

        // Test BST
        long startTime = System.nanoTime();

        BSTMap<Integer, Integer> bst = new BSTMap<>();
        for (Integer x: testData)
            bst.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST: " + time + " s");


        // Test HashMap
        startTime = System.nanoTime();

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (Integer x: testData)
            hashMap1.put(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("HashMap1: " + time + " s");


        /**
         * 添加排序后，测试时间变为：
         * BST: 37.866520634 s
         * HashMap1: 7.36150322 s
         * HashMap2: 11.492474741 s
         * AVL: 9.475218353 s
         * RBTree: 9.30462801 s
         *
         */
        Collections.sort(testData);

        // Test HashMap
        startTime = System.nanoTime();

        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for (Integer x: testData)
            hashMap2.put(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("HashMap2: " + time + " s");

        // Test AVL
        startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x: testData)
            avl.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x: testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }

}