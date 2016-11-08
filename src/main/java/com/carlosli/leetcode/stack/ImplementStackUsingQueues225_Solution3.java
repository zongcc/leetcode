package com.carlosli.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yulongli on 2016/11/7.
 */
public class ImplementStackUsingQueues225_Solution3 {

    private Queue<Integer> queue = new LinkedList<Integer>();

    public void push(int x) {

        int size = queue.size();
        queue.add(x);

        while (size != 0) {
            queue.add(queue.remove());
            size--;
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.element();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues225_Solution3 stack = new ImplementStackUsingQueues225_Solution3();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
