package com.carlosli.leetcode.array;

import java.util.Arrays;

/**
 * Created by li on 2016/10/15.
 * 样例
 * 给定 [1,2,3] 表示 123, 返回 [1,2,4].
 * 给定 [9,9,9] 表示 999, 返回 [1,0,0,0]
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1]++;
        // 从最后一位往前遍历
        for (int i = n - 1; i >= 0; i--) {
            // 若当前位+1后等于10，则置当前位为0，它的前一位+1,
            if (digits[i] == 10) {
                digits[i] = 0;
                if (i != 0) {
                    digits[i - 1]++;
                } else {
                    // 当是数组第一位时，新建一个数组，第一位1，其余0
                    int[] newArray = new int[digits.length + 1];
                    newArray[0] = 1;
                    return newArray;
                }
            }
        }
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            // 无论是第几位，只要+1不=10，就可以截止了
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // 否则设置为0，至于他的高位下一个循环再说
            digits[i] = 0;
        }
        // 循环都结束了，还没有return，说明一定是需要再补一个高位为1
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        PlusOne66 plusOne66 = new PlusOne66();
        System.out.println(Arrays.toString(plusOne66.plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(plusOne66.plusOne2(new int[]{9, 9, 9})));
    }
}
