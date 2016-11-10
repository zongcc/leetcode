package com.carlosli.leetcode.stack;

import java.util.Stack;

/**
 * Created by yulongli on 2016/11/9.
 */
public class MinStack155_Solution1 {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        // 每次push时，如果比min小，就连带着把min存进去，方便pop后，及时取出旧的min的值
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // 若当前取的值是最小值，就要把push时存入的旧的min值拿出来，并赋值给min
        // 会有异常，如果stack中只存在push的min的默认值（push时，会把Integer.MAX_VALUE最先插入）时，由于这里pop了两次，就会异常
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {

        MinStack155_Solution1 minStack = new MinStack155_Solution1();
        minStack.push(3);
        minStack.push(1);
        minStack.push(4);
        minStack.push(0);
        minStack.push(-2);
        System.out.println("");
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();


//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
////        System.out.println(minStack.pop());;
//        System.out.println(minStack.top());;
//        System.out.println(minStack.getMin());;
    }
}
