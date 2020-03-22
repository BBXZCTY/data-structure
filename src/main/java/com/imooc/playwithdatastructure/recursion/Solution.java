package com.imooc.playwithdatastructure.recursion;

/**
 * @Author: hfr
 * @Date: 2019-08-09 18:22
 * @Version 1.0
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * 203题
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (null == head) {
            return head;
        }

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }

}