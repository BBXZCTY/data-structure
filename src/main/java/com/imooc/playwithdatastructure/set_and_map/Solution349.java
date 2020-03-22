package com.imooc.playwithdatastructure.set_and_map;

import java.util.*;

/**
 * @Author: hfr
 * @Date: 2019-08-22 17:22
 * @Version 1.0
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution349 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        BSTSet<Integer> set = new BSTSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] arr = new Solution349().intersect1(nums1,nums2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}