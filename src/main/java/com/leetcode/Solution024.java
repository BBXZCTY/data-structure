package com.leetcode;

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 */
public class Solution024 {

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

    public ListNode swapPairs(ListNode head) {
        int size = 1;
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            next = next.next;
            size  ++;
        }
        next  = cur.next;

        for (int i = 1; i <= size; i++) {
            // 奇数
            if (i % 2 == 1) {
                if (null != next) {
                    temp.next = new ListNode(next.val);

                }
            } else {
                if (null != cur) {
                    temp.next = new ListNode(cur.val);

                }
            }

            next = next.next;
            cur = cur.next;

            temp = temp.next;
            System.out.println("res.next = " + res.next);
        }


        return res.next;
    }

    public static void main(String[] args) {
        Solution024 solution024 = new Solution024();
        ListNode l1 = null;
        l1 = solution024.put(l1, 1);
        solution024.put(l1, 2);
        solution024.put(l1, 3);
        solution024.put(l1, 4);
//        solution024.put(l1, 5);
//        solution024.put(l1, 6);
//        solution024.put(l1, 7);
//        solution024.put(l1, 8);
//        solution024.put(l1, 9);
        System.out.println(l1.toString());
        System.out.println(solution024.swapPairs(l1));





    }

}