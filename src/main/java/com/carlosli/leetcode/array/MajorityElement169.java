package com.carlosli.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by li on 2016/10/22.
 */
public class MajorityElement169 {
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> value_times = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer times = value_times.get(nums[i]);
            if (times == null) {
                value_times.put(nums[i], 1);
            } else {
                value_times.put(nums[i], times + 1);
            }
        }
        for (Integer integer : value_times.keySet()) {
            if (value_times.get(integer) >= (Math.round(nums.length / 2D))) return integer;
        }
        return 0;
    }

    public static int majorityElement2(int[] nums) {
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);
        // 长度
        int length = 0;
        // 对应长度上的索引位置
        int index = 0;

        int slow = 0;
        for (int quick = 0; quick < nums.length; quick++) {
            if (nums[slow] != nums[quick]) {
                int newLength = quick - slow;
                if (newLength > length) {
                    index = quick - 1;
                    length = newLength;
                    slow = quick;
                }
            }
            if (quick == nums.length - 1) {
                int newLength = quick - slow + 1;
                if (newLength > length) {
                    index = quick - 1;
                    length = newLength;
                    slow = quick;
                }
            }
        }
        return nums[index];
    }

    public static int majorityElement3(int[] num) {

        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 3};
//        int[] nums = new int[]{-1,1,1,1,2,1};
        int[] nums = new int[]{2, 2};
        int i = MajorityElement169.majorityElement3(nums);
        System.out.println(i);
    }
}
