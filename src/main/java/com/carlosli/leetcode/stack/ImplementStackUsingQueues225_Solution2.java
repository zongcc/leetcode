package com.carlosli.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yulongli on 2016/11/7.
 */
public class ImplementStackUsingQueues225_Solution2 {

    private Queue<Integer> queue1 = new LinkedList<Integer>();
    private Queue<Integer> queue2 = new LinkedList<Integer>();

    public void push(int x) {
//        while (!queue1.isEmpty()) {
//            queue2.add(queue1.remove());
//        }
//        queue1.add(x);
//        while (!queue2.isEmpty()) {
//            queue1.add(queue2.remove());
//        }

        // 改用下面的方式，更好。直接存放到2中
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.element();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues225_Solution2 stack = new ImplementStackUsingQueues225_Solution2();
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
