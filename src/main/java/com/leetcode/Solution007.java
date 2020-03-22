package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hfr
 * @Date: 2019-09-07 20:29
 * @Version 1.0
 *
 * 7. Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 */
public class Solution007 {

    public int reverse(int x) {

        String str = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i --) {
            sb.append(str.charAt(i));
        }

        int result = Integer.parseInt(sb.toString());
        return x > 0 ? result : - result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution007().reverse(Integer.MIN_VALUE));
    }

}