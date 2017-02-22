package com.carlosli.leetcode.binarysearch;

import java.util.Arrays;

/**
 * Created by yulongli on 2017/2/21.
 */
public class SearchInsertPosition35 {
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // 小于（没有发现） 或 等于（发现了）
            if (target <= nums[i]) return i;
        }
        // 没有发现，插在最后面
        return nums.length;
    }

    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = nums.length / 2;

        while (left <= right) {
//        while (middle != target && middle >= left && middle <= right) {
            if (target > nums[middle]) {
                left = middle + 1;
                middle = (left + right) / 2;
            } else if (target < nums[middle]) {
                right = middle - 1;
                middle = (left + right) / 2;
            } else if (target == nums[middle]) return middle;
        }
        return left;
    }

    public static int searchInsert3(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(Arrays.toString(nums));
        System.out.println(searchInsert2(nums, 5));
        System.out.println(searchInsert2(nums, 2));
        System.out.println(searchInsert2(nums, 7));
        System.out.println(searchInsert2(nums, 0));
    }
}
