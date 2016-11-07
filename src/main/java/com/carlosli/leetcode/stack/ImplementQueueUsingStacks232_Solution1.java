package com.carlosli.leetcode.stack;

import java.util.Stack;

/**
 * pop peek的时候调整顺序，push就不用调整了
 * Created by yulongli on 2016/11/6.
 */
public class ImplementQueueUsingStacks232_Solution1 {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int x) {
        stack1.push(x);
    }

    /**
     * 弹出
     */
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int temp = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return temp;
    }

    /**
     * 查看，不弹出
     *
     * @return
     */
    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int temp = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return temp;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks232_Solution1 queue = new ImplementQueueUsingStacks232_Solution1();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
