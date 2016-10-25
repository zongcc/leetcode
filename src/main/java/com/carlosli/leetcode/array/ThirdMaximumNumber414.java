package com.carlosli.leetcode.array;

/**
 * Created by yulongli on 2016/10/25.
 */
public class ThirdMaximumNumber414 {
    public static int thirdMax(int[] nums) {
        int max = -1, second = -1, third = -1;
        for (int num : nums) {
            if (num > max) {
                third = second;
                second = max;
                max = num;
            }
            if (max > num && num > second) {
                third = second;
                second = num;
            }
            if (second > num && num > third) {
                third = num;
            }
        }

        if (third == -1) {
            return max;
        } else {
            return third;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 5, 8, 3, 1};
        System.out.println(thirdMax(nums));
    }
}
