package com.imooc.playwithdatastructure.set_and_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hfr
 * @Date: 2019-08-22 10:49
 * @Version 1.0
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution350 {

    public int[] intersect1(int[] nums1, int[] nums2) {
        BSTMap<Integer, Integer> bstMap = new BSTMap<>();
        for (int num : nums1) {
            if (!bstMap.contains(num)) {
                bstMap.add(num, 1);
            } else {
                bstMap.add(num, bstMap.get(num) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (bstMap.contains(num)) {
                res.add(num);
                bstMap.set(num, bstMap.get(num) - 1);
                if (bstMap.get(num) == 0) {
                    bstMap.remove(num);
                }
            }
        }

        System.out.println(res);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        LinkedListMap<Integer, Integer> linkedListMap = new LinkedListMap<>();
        for (int num : nums1) {
            if (!linkedListMap.contains(num)) {
                linkedListMap.add(num, 1);
            } else {
                linkedListMap.add(num, linkedListMap.get(num) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (linkedListMap.contains(num)) {
                res.add(num);
                linkedListMap.set(num, linkedListMap.get(num) - 1);
                if (linkedListMap.get(num) == 0) {
                    linkedListMap.remove(num);
                }
            }
        }

        System.out.println(res);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] arr = new Solution350().intersect2(nums1,nums2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                res.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}