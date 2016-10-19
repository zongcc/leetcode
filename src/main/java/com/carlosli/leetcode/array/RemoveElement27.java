package com.carlosli.leetcode.array;

import java.util.Arrays;

/**
 * Created by li on 2016/10/14.
 */
public class RemoveElement27 {

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * i和j加起来最多走2n步
     * 好的情况，如 1、2、3、4 **********需要添加说明*********
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * i和n加起来最多走n步
     * 好的情况，如 1、2、3、4     去除5，一次都不需要移动
     * 坏的情况，如 5、5、5、5     去除5，需要移动n次
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        RemoveElement27 removeElement = new RemoveElement27();
        int[] array = new int[]{3, 2, 2, 3};
        System.out.println(removeElement.removeElement(array, 3));
        System.out.println(Arrays.toString(array));

        int[] array2 = new int[]{3, 3,3, 3};
        System.out.println(removeElement.removeElement2(array2, 3));
        System.out.println(Arrays.toString(array2));
    }
}
