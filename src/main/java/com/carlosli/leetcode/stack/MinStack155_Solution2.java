package com.carlosli.leetcode.stack;

import java.util.Stack;

/**
 * 这个感觉不好
 * Created by yulongli on 2016/11/9.
 */
public class MinStack155_Solution2 {
    long min;
    Stack<Long> stack = new Stack<Long>();

    public void push(int x) {
        // 相当于，在新push进去的值，都是x和min的差
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);//Could be negative if min value needs to change
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;//If negative, increase the min value

    }

    public int top() {
        long top = stack.peek();
        // >0就意味着之前后放进的值大于min（因为push进去的值，是x-min）
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) (min);
        }
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {

        MinStack155_Solution2 minStack = new MinStack155_Solution2();
        minStack.push(3);
        minStack.push(1);
        minStack.push(4);
        minStack.push(0);
        minStack.push(-2);
        minStack.push(-6);
        System.out.println("");
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());


//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());;
//        System.out.println(minStack.getMin());;
    }
}
