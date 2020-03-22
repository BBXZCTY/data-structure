package com.leetcode;

import java.util.List;

/**
 * @Author: hfr
 * @Date: 2019-08-30 23:14
 * @Version 1.0
 *
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) { val = x; }
 * }
 *
 */
public class Solution002 {


    public static void main(String[] args) {
        Solution002 solution002 = new Solution002();
        ListNode l1 = null;
        l1 = solution002.put(l1, 9);
//        solution002.put(l1, 4);
//        solution002.put(l1, 3);
//        solution002.put(l1, 1);
        System.out.println(l1);


        ListNode l2 = null;
        l2 = solution002.put(l2, 9);
//        solution002.put(l2, 6);
//        solution002.put(l2, 4);
//        solution002.put(l2, 9);
        System.out.println(l2);

//        System.out.println(10 / 10);
//        System.out.println(9 / 10);
//        System.out.println(10 % 10);
//        System.out.println(8 % 10);
//        System.out.println(7 / 10);

        System.out.println(solution002.addTwoNumbers(l1, l2));
//        System.out.println(l1);
//        System.out.println(l2);

        System.out.println();

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newNode = new ListNode(0);
        ListNode res = newNode;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            newNode.next = new ListNode(sum % 10);
            newNode = newNode.next;
            System.out.println("new Node = " + newNode);
            System.out.println("res = " + res);
        }
        if (sum / 10 == 1) {
            newNode.next = new ListNode(1);
        }
        return res.next;
    }




    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("dummyhead-->");
            ListNode cur = this;
            sb.append(cur.val);
            sb.append("-->");
            while (cur.next != null) {
                sb.append(cur.next.val);
                sb.append("-->");
                cur  = cur.next;
            }
            sb.append("dummytail");
            return sb.toString();
        }
    }

    /**
     *
     * @param l
     * @param val
     * @return
     */
    public ListNode put(ListNode l, int val) {
        if (l == null) {
            l = new ListNode(val);
        } else {
            ListNode cur = l;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(val);
        }
        return l;
    }



}