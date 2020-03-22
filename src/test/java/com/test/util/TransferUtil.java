package com.test.util;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: hfr
 * @Date: 2019-08-16 11:11
 * @Version 1.0
 */
public class TransferUtil {

    public static long test1(int num) {
        Stack<Integer> stack = new Stack<>();
        int temp = num / 2;
        int m = num % 2;
        stack.push(m);
        while (temp != 0) {
            m = temp % 2;
            temp = temp / 2;
            stack.push(m);
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }
        return Long.parseLong(sb.toString());
    }

    public static long test2(int num) {
        long result = 0;
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            result = result + (long) Math.pow(2, str.length() - i - 1) * Long.parseLong(String.valueOf(str.charAt(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(TransferUtil.test1(16));
//        System.out.println((long) Math.pow(2, 6));
        System.out.println(TransferUtil.test2(10000));
        System.out.println(Integer.toBinaryString(16));

        System.out.println(new BigInteger("16").toString(2));
        System.out.println(new BigInteger("10000", 2));

        int NCPU = Runtime.getRuntime().availableProcessors();
        System.out.println(NCPU);

        System.out.println(Integer.toBinaryString(1111 & 1001));

    }




}