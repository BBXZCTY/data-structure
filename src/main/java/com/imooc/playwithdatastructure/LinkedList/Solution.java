package com.imooc.playwithdatastructure.LinkedList;

import com.imooc.playwithdatastructure.LinkedList.linkedlist_stack.LinkedListStack;

/**
 * @Author: hfr
 * @Date: 2019-08-09 17:40
 * @Version 1.0
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 该代码主要用于使用Leetcode上的问题测试我们的LinkedListStack：）
 *
 */
public class Solution {

    public boolean isValid(String s) {
        LinkedListStack<Character> listStack = new LinkedListStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                listStack.push(c);
            } else {
                if (listStack.isEmpty()) {
                    return false;
                }
                char topChar = listStack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                else if (c == ']' && topChar != '[')
                    return false;
                else if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return listStack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("{{{"));
        System.out.println(solution.isValid("{{{}}}"));
        System.out.println(solution.isValid("{{{ }}}"));
        System.out.println(solution.isValid("{[({ }}}"));
        System.out.println(solution.isValid("{[()]}"));
    }
}