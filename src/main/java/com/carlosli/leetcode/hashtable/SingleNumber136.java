package com.carlosli.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yulongli on 2017/1/12.
 */
public class SingleNumber136 {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            // 避免最后一个单个
            if (i == nums.length - 1) return nums[i];
            // 正常和下一个判断
            if (nums[i] != nums[i + 1]) return nums[i];
            i += 2;
        }
        return Integer.MIN_VALUE;
    }

    public static int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++integer);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) return integer;
        }
        return Integer.MIN_VALUE;
    }

    /*
    * A^=B  =>  A = A^B
    * 异或  不同为1，相同为0
    *
    * 交换律： A^B=B^A
    * 结合律： (A^B)^C=A^(B^C)
    * 恒等律： A^0=A
    * 归零律： A^A=0
    * */
    public static int singleNumber3(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1};
        int[] nums3 = new int[]{1, 2, 3, 4, 1, 2, 4};

        System.out.println(singleNumber(nums1));
        System.out.println(singleNumber(nums2));
        System.out.println(singleNumber(nums3));
        System.out.println(singleNumber2(nums1));
        System.out.println(singleNumber2(nums2));
        System.out.println(singleNumber2(nums3));
        System.out.println(singleNumber3(nums1));
        System.out.println(singleNumber3(nums2));
        System.out.println(singleNumber3(nums3));

    }
}
