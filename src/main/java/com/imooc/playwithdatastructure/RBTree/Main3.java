package com.imooc.playwithdatastructure.RBTree;

import com.imooc.playwithdatastructure.avltree.AVLTree;
import com.imooc.playwithdatastructure.set_and_map.BSTMap;

import java.util.ArrayList;

/**
 * @Author: hfr
 * @Date: 2019-08-28 10:16
 * @Version 1.0
 */
public class Main3 {

    /**
     * AVL: 7.670688507 s
     * RBTree: 4.560465882 s
     * @param args
     */
    public static void main(String[] args) {

        int n = 20000000;

        ArrayList<Integer> testData = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i ++)
            testData.add(i);

        // Test BST
//        long startTime = System.nanoTime();
//
//        BSTMap<Integer, Integer> bst = new BSTMap<>();
//        for (Integer x: testData)
//            bst.add(x, null);
//
//        long endTime = System.nanoTime();
//
//        double time = (endTime - startTime) / 1000000000.0;
//        System.out.println("BST: " + time + " s");


        // Test AVL
        long startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x: testData)
            avl.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
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