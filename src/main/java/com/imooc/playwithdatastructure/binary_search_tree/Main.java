package com.imooc.playwithdatastructure.binary_search_tree;

/**
 * @Author: hfr
 * @Date: 2019-08-11 21:47
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println("以上为前序遍历");

        bst.inOrder();
        System.out.println("以上为中序遍历");

        bst.postOrder();
        System.out.println("以上为后序遍历");

        bst.levelOrder();
        System.out.println("以上为层序遍历");
    }
}