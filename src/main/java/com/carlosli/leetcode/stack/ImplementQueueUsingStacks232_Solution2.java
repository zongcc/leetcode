package com.carlosli.leetcode.stack;

import java.util.Stack;

/**
 * push的时候调整顺序，pop peek就不用调整了
 * Created by yulongli on 2016/11/6.
 */
public class ImplementQueueUsingStacks232_Solution2 {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /**
     * 弹出
     */
    public int pop() {
        return stack1.pop();
    }

    /**
     * 查看，不弹出
     *
     * @return
     */
    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks232_Solution2 queue = new ImplementQueueUsingStacks232_Solution2();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
