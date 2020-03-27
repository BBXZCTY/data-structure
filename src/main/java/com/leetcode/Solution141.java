package com.leetcode;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Input: head = [1,2], pos = -1
 * Output: false
 *
 *
 *
 */
public class Solution141 {

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


    public static void main(String[] args) {
        Solution141 solution041 = new Solution141();
        ListNode l1 = null;
        l1 = solution041.put(l1, 3);
        solution041.put(l1, 2);
        solution041.put(l1, 0);
        solution041.put(l1, 4);

        System.out.println(l1.toString());




    }


    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        return head.next != null;
    }


}