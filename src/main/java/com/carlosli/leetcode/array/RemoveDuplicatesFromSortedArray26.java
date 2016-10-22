package com.carlosli.leetcode.array;

import java.util.Arrays;

/**
 * Created by li on 2016/10/16.
 */
public class RemoveDuplicatesFromSortedArray26 {

    public int removeDuplicates(int[] nums) {
        int duplicatePoint = 0;
        boolean isFirst = true;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                if (isFirst) {
                    duplicatePoint = i + 1;
                    isFirst = false;
                }
            } else {
                if (!isFirst) {
                    nums[duplicatePoint] = nums[i + 1];
                    duplicatePoint++;
                }
            }
            i++;
        }
        return duplicatePoint == 0 ? nums.length : duplicatePoint; // 防止nums没有重复的数据
    }

    /**
     * 思路
     * 2个指针，一个用于写，一个用于读。
     * 因为所有的都不同，只能有一个数字，只有在遇到不同的时候，写的指针才移动，这样保证留下一个数字
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray26 remove = new RemoveDuplicatesFromSortedArray26();
        int[] nums = new int[]{2, 2, 2, 3, 4, 4, 5};
//        int[] nums = new int[]{1,5};
//        int[] nums = new int[]{1};
        System.out.println(remove.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        int[] nums2 = new int[]{2, 2, 2, 3, 4, 4, 5};
//        int[] nums2 = new int[]{1, 5};
//        int[] nums2 = new int[]{1};
        System.out.println(remove.removeDuplicates2(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}
