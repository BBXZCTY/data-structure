package com.imooc.playwithalgorithms.Sorting_Basic;

/**
 * @Author: hfr
 * @Date: 2019-09-01 16:45
 * @Version 1.0
 *
 * 0、在索引为1的位置开始，倒序和索引区间为[0]的位置比较并交换（当arr[1] > arr[0] 再交换）
 * 1、在索引为2的位置开始，倒序和索引区间为[0, 1]的位置比较并交换
 * ...
 * n-1、在索引为n-1的位置开始，倒序和索引区间为[0, n-2]的位置比较
 *
 */
public class InsertionSort {

    // 我们的算法类不允许产生任何实
    private InsertionSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i ++) {
            // 写法1
//            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j -- ) {
//                swap(arr, j, j - 1);
//            }

            // 写法2
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.imooc.playwithalgorithms.Sorting_Basic.InsertionSort", arr);


        Integer[] arr2 = {2,3,4,5,6,1,9,7};
        InsertionSort.sort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }

}