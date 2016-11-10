package com.carlosli.leetcode.stack;

import java.util.Stack;

/**
 * Created by yulongli on 2016/11/9.
 */
public class ValidParentheses20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.push(aChar);
            } else {
                // 防止出现 只有)}]的情况
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if (pop == '(') {
                    if (aChar != ')') return false;
                }
                if (pop == '{') {
                    if (aChar != '}') return false;
                }
                if (pop == '[') {
                    if (aChar != ']') return false;
                }
            }
        }
        // 防止 有前没有后的
        if (!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses20 vp = new ValidParentheses20();
        System.out.println(vp.isValid("({{[]}})"));
        System.out.println(vp.isValid("({{}}[])"));

        System.out.println(vp.isValid("({([]}})"));
        System.out.println(vp.isValid("({{[]]})"));
        System.out.println(vp.isValid("("));
        System.out.println(vp.isValid("]"));
    }
}
