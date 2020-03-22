package com.leetcode;

import java.util.zip.CRC32;

/**
 * @Author: hfr
 * @Date: 2020-03-16 17:20
 * @Version 1.0
 */


public class Solution021 {

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
                cur = cur.next;
            }
            sb.append("dummytail");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution021 solution021 = new Solution021();
        ListNode l1 = null;
        l1 = solution021.put(l1, 1);
        solution021.put(l1, 6);
        solution021.put(l1, 5);
        solution021.put(l1, 8);
        solution021.put(l1, 4);
        solution021.put(l1, 2);
        solution021.put(l1, 7);
        solution021.put(l1, 3);
        System.out.println(l1.toString());


        ListNode l2 = null;
        l2 = solution021.put(l2, 6);
        solution021.put(l2, 7);
        solution021.put(l2, 15);
        solution021.put(l2, 9);
        solution021.put(l2, 10);
        solution021.put(l2, 14);
        solution021.put(l2, 11);
        solution021.put(l2, 8);
        solution021.put(l2, 12);
        solution021.put(l2, 13);
        System.out.println(l2.toString());

        System.out.println(solution021.mergeTwoLists1(l1, l2));

    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l2.next, l1);
            return l2;
        }
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        return null;
    }




    /**
     * insert to the head
     * 需要用prev变量
     * 1
     * 2-->1
     * 3-->2-->1
     * 4-->3-->2-->1
     * 5-->4-->3-->2-->1
     *
     *
     * insert to the tail
     * 需要用next变量
     * 1
     * 1-->2
     * 1-->2-->3
     * 1-->2-->3-->4
     * 1-->2-->3-->4-->5
     *
     *
     * @param
     * @param
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



