package com.imooc.playwithdatastructure.recursion;

/**
 * @Author: hfr
 * @Date: 2019-08-10 21:55
 * @Version 1.0
 */
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[l...n)这个区间内所有数字的和
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}