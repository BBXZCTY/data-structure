package com.imooc.playwithdatastructure.array_queue;

import javafx.util.Pair;

import java.util.List;

/**
 * @Author: hfr
 * @Date: 2019-08-07 16:15
 * @Version 1.0
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 二叉树的层序遍历是一个典型的可以借助队列解决的问题。
 * 该代码主要用于使用Leetcode上的问题测试我们的ArrayQueue。
 *
 */
public class Solution2 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 我们使用LinkedList来做为我们的先入先出的队列
        ArrayQueue<Pair<TreeNode, Integer>> queue = new ArrayQueue<Pair<TreeNode, Integer>>();
        queue.enqueue(new Pair<TreeNode, Integer>(root, 0));
        return null;
    }

}