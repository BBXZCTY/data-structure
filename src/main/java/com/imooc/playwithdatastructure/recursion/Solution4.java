package com.imooc.playwithdatastructure.recursion;

/**
 * @Author: hfr
 * @Date: 2019-08-10 21:48
 * @Version 1.0
 */
public class Solution4 {

    public ListNode removeElements(ListNode head, int val) {

        if(head == null)
            return head;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution4()).removeElements(head, 6);
        System.out.println(res);
    }

}