package com.carlosli.leetcode.array;

import java.util.Arrays;

/**
 * Created by li on 2016/10/15.
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int zeroPoint = 0; // 有可能指向非0元素
        for (int numPoint = 0; numPoint < nums.length; numPoint++) {
            if (nums[numPoint] != 0) {
                int temp = nums[zeroPoint];
                nums[zeroPoint] = nums[numPoint];
                nums[numPoint] = temp;
                zeroPoint++;
            }
        }

    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        // 依次把非0的移动到前端
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        // insertPos指针指向的以及后面的都应为0
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes283 moveZeroes283 = new MoveZeroes283();

        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{1, 2, 0, 3, 12};
        moveZeroes283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        moveZeroes283.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));



        int[] nums3 = new int[]{0, 1, 0, 3, 12};
        int[] nums4 = new int[]{1, 2, 0, 3, 12};
        moveZeroes283.moveZeroes2(nums3);
        System.out.println(Arrays.toString(nums3));
        moveZeroes283.moveZeroes2(nums4);
        System.out.println(Arrays.toString(nums4));


    }
}
