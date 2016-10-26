package com.carlosli.leetcode.array;

/**
 * Created by yulongli on 2016/10/25.
 */
public class ThirdMaximumNumber414 {
    public static int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        boolean isFirstThird = true;
        int count = 0;
        for (int num : nums) {
            if (num > max) {
                third = second;
                second = max;
                max = num;
                count++;
                continue;
            }
            if (max > num && num > second) {
                third = second;
                second = num;
                count++;
                continue;
            }
            if (second > num && num > third) {
                third = num;
                count++;
                continue;
            }
            if (num == third && isFirstThird) {
                count++;
                isFirstThird = false;
            }
        }

        if (count < 3) {
            return max;
        } else {
            return third;
        }
    }

    public static int thirdMax2(int[] nums) {
        long max = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                third = second;
                second = max;
                max = num;
                continue;
            }
            if (max > num && num > second) {
                third = second;
                second = num;
                continue;
            }
            if (second > num && num > third) {
                third = num;
                continue;
            }
        }

        return (int) (third != Long.MIN_VALUE ? third : max);
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, -2147483648};
//        int[] nums = new int[]{2, 2, 5, 8, 3, 1};
        int[] nums = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax2(nums));
    }
}
