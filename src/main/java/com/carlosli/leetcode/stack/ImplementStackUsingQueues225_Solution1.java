package com.carlosli.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yulongli on 2016/11/8.
 */
public class ImplementStackUsingQueues225_Solution1 {

    private Queue<Integer> queue1 = new LinkedList<Integer>();
    private Queue<Integer> queue2 = new LinkedList<Integer>();

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        Integer remove = queue1.remove();
//        while (!queue2.isEmpty()) {
//            queue1.add(queue2.remove());
//        }
        // 改用下面的方式，更好
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return remove;
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        Integer element = queue1.element();
        queue2.add(queue1.remove());
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
        return element;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues225_Solution1 stack = new ImplementStackUsingQueues225_Solution1();
        stack.push(1);
        System.out.println(stack.top());
        stack.push(2);
        System.out.println(stack.top());
        stack.push(3);
        System.out.println(stack.top());
        stack.push(4);
        System.out.println(stack.top());
        System.out.println("------");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("======");
        System.out.println(stack.top());
        System.out.println("======");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
