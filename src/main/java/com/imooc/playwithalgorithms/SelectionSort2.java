package com.imooc.playwithalgorithms;

/**
 * @Author: hfr
 * @Date: 2019-09-02 11:29
 * @Version 1.0
 *
 * 选择排序优化版
 *
 * 每一轮中，同时选出未处理的最小值和最大值
 *
 */
public class SelectionSort2 {

    // 我们的算法类不允许产生任何实例
    private SelectionSort2(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;


    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

    }

}