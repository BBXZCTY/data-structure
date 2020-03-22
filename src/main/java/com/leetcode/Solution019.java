package com.leetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 *
 * Given n will always be valid.
 *
 */
public class Solution019 {

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


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size  = 1;
        ListNode all = head;
        while (all.next != null) {
            all = all.next;
            size ++;
        }
        if (size == n) {
            return head.next;
        }

        ListNode delNode = head;
        ListNode prev = new ListNode(0);
        for (int i = 0; i < size - n; i++) {
            prev = delNode;
            delNode = delNode.next;
        }
        prev.next = delNode.next;
        return head;
    }


    public static void main(String[] args) {
        Solution019 solution019 = new Solution019();
        ListNode l1 = null;
        l1 = solution019.put(l1, 1);
        solution019.put(l1, 2);
        solution019.put(l1, 3);
        solution019.put(l1, 4);
        solution019.put(l1, 5);
        System.out.println(l1.toString());

        ListNode head = solution019.removeNthFromEnd(l1, 2);
        System.out.println(head);
    }
}