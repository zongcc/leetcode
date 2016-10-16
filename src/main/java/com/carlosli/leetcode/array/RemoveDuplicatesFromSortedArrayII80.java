package com.carlosli.leetcode.array;

import java.util.Arrays;

/**
 * Created by li on 2016/10/16.
 */
public class RemoveDuplicatesFromSortedArrayII80 {

    public int removeDuplicates(int[] nums) {
        int times = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                if (times >= 1) {
                    i++;
                    i++;
                } else {
                    i++;
                }
                nums[i] = nums[j];
                times = 0;
            } else {
                if (i != j) {
                    times++;
                }
            }
            j++;
        }
        return i + 1;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII80 remove = new RemoveDuplicatesFromSortedArrayII80();
//        int[] nums = new int[]{2, 2, 2, 3, 4, 4, 5};
//        int[] nums = new int[]{1,5};
//        int[] nums = new int[]{1};
//        int[] nums = new int[]{1,2,2,2,3,3,4,5};
        int[] nums = new int[]{1,1};
        System.out.println(remove.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        int[] nums2 = new int[]{2, 2, 2, 3, 4, 4, 5};
//        int[] nums2 = new int[]{1, 5};
//        int[] nums2 = new int[]{1};
        System.out.println(remove.removeDuplicates2(nums2));
        System.out.println(Arrays.toString(nums2));

    }
}
