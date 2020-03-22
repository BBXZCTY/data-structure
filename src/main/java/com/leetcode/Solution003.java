package com.leetcode;

import java.util.*;

/**
 * @Author: hfr
 * @Date: 2019-08-31 12:33
 * @Version 1.0
 *
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class Solution003 {

    public int lengthOfLongestSubstring(String s) {

        if ("".equals(s)) {
            return 0;
        }
        int n = s.length(), ans = 0;
        List<String> set = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++) {
            String str = String.valueOf(s.charAt(i));
            if (!sb.toString().contains(str)) {
                sb.append(s.charAt(i));
            } else {
                set.add(sb.toString());
                sb = new StringBuilder(str);
            }

            if (i == n - 1) {
                set.add(sb.toString());
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < set.size(); i ++) {
            if (set.get(i).length() > set.get(maxIndex).length()) {
                maxIndex = i;
            }
        }
        System.out.println(set);
        return set.get(maxIndex).length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution003().lengthOfLongestSubstring("dvdf")); // d vdf
    }
}