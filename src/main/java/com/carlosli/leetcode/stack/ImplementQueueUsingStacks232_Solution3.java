package com.carlosli.leetcode.stack;

import java.util.Stack;

/**
 * Created by yulongli on 2016/11/6.
 */
public class ImplementQueueUsingStacks232_Solution3 {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks232_Solution3 queue = new ImplementQueueUsingStacks232_Solution3();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(4);
        queue.push(5);

        System.out.println(queue.pop());//3
        System.out.println(queue.pop());//4
        System.out.println(queue.pop());


        //测试peek
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();

        queue.push(4);
        queue.push(5);

        System.out.println(queue.peek());//3
        queue.pop();
        System.out.println(queue.peek());//4
        queue.pop();
        System.out.println(queue.peek());

    }
}
