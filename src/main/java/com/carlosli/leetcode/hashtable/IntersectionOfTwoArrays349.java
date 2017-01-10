package com.carlosli.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yulongli on 2017/1/9.
 */
public class IntersectionOfTwoArrays349 {
    // time 0(n)
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }

        int[] nums3 = new int[result.size()];

        int i = 0;
        for (Integer integer : result) {
            nums3[i++] = integer;
        }

        return nums3;
    }

    // o(nlogn) 这里其实是2nlogn+2n，前者两次排序，后者两次读取
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            int compare = Integer.compare(nums1[i], nums2[j]);
            if (compare < 0) {
                i++;
            } else if (compare > 0) {
                j++;
            } else if (compare == 0) {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[set.size()];
        int m = 0;
        for (Integer integer : set) {
            result[m++] = integer;
        }
        return result;
    }

    public static int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 3, 4, 5};
        int[] nums2 = new int[]{1, 2, 3, 7, 8, 0};
        int[] intersection = intersection(nums1, nums2);

        System.out.println(Arrays.toString(intersection));
    }
}
