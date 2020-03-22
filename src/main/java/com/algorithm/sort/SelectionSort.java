package com.algorithm.sort;

/**
 * @Author: hfr
 * @Date: 2019-05-21 10:29
 * @Version 1.0
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr={33,3,2,45,65,1,12};
        System.out.print("排序前：");
        for(int num : arr){
            System.out.print(num + " ");
        }
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            k = i;
            for (int j = k + 1; j < arr.length; j++) {
                // 选最小
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            if (i != k) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println();
        System.out.print("排序后：");
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}