package com.carlosli.leetcode.array;

/**
 * Created by li on 2016/10/20.
 */
public class ContainsDuplicateII219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) return true;
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        for (int i = k; i >= 0; i--) {
            for (int j = 0; j + k < nums.length; j++) {
                if (nums[j] == nums[j + k]) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // 最后一个重复
        int[] nums = new int[101];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = i + 1;
        }
        nums[100] = 90;

        long l1 = System.nanoTime();
        System.out.println(ContainsDuplicateII219.containsNearbyDuplicate(nums, 11));
        long l2 = System.nanoTime();
        System.out.println(ContainsDuplicateII219.containsNearbyDuplicate2(nums, 10));
        long l3 = System.nanoTime();
//        System.out.println(ContainsDuplicateII219.containsDuplicate3(nums));
        long l4 = System.nanoTime();
        System.out.println(l2 - l1);
        System.out.println(l3 - l2);
        System.out.println(l4 - l3);
    }
}
