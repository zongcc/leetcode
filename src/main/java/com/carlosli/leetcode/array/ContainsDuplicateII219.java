package com.carlosli.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
        if (nums.length < 2) return false;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j + i < nums.length; j++) {
                if (nums[j] == nums[j + i]) return true;
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate3(int[] nums, int k) {
        // nums的值 做key index做value
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int index = 0; index < nums.length; index++) {
            Integer preIndex = map.get(nums[index]);
            if (preIndex != null && index - preIndex <= k) {
                return true;
            } else {
                /*
                 遇到==null 或者！=null两种情况
                     1. ==null  放
                     2. !=null  也要放，将index刷新为最新的，因为是按照顺序遍历，最新的跟后面比较时，肯定比前面的index近，
                                只要距离最近的小于k，即可
                */
                map.put(nums[index], index);
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate4(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 删除已经超过距离k的元素
            if (i > k) set.remove(nums[i - k - 1]);
            // set存的时候 若set中已经存在该值，则返回非空，那么就说明有符合要求的
            if (!set.add(nums[i])) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        // 最后一个重复
        int[] nums = new int[10001];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = i + 1;
        }
        nums[10000] = 9990;

        /*
        * 几个特殊情况要考虑
        * []        0
        * [99,99]   1
        * [1,2]     1
        * */
        long l1 = System.nanoTime();
//        System.out.println(ContainsDuplicateII219.containsNearbyDuplicate(nums, 11));
        long l2 = System.nanoTime();
        System.out.println(ContainsDuplicateII219.containsNearbyDuplicate2(nums, 9999));
        long l3 = System.nanoTime();
        System.out.println(ContainsDuplicateII219.containsNearbyDuplicate3(nums, 9999));
        long l4 = System.nanoTime();
        System.out.println(ContainsDuplicateII219.containsNearbyDuplicate4(nums, 9999));
        long l5 = System.nanoTime();
        System.out.println(l2 - l1);
        System.out.println(l3 - l2);
        System.out.println(l4 - l3);
        System.out.println(l5 - l4);
    }
}
