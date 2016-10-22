package com.carlosli.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by li on 2016/10/13.
 */
public class ContainsDuplicate217 {
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        HashSet intSet = new HashSet();

        for (int num : nums) {
            boolean contains = intSet.contains(num);
            if (contains) return true;
            intSet.add(num);
        }
        return false;
    }

    public static boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        // 最后一个重复
        int[] nums = new int[30001];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = i + 1;
        }
        nums[30000] = 29999;

        long l1 = System.nanoTime();
        System.out.println(ContainsDuplicate217.containsDuplicate(nums));
        long l2 = System.nanoTime();
        System.out.println(ContainsDuplicate217.containsDuplicate2(nums));
        long l3 = System.nanoTime();
        System.out.println(ContainsDuplicate217.containsDuplicate3(nums));
        long l4 = System.nanoTime();
        System.out.println(l2 - l1);
        System.out.println(l3 - l2);
        System.out.println(l4 - l3);
    }
}
