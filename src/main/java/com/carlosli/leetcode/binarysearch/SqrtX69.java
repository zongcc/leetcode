package com.carlosli.leetcode.binarysearch;

/**
 * Created by yulongli on 2017/2/27.
 */
public class SqrtX69 {
    /*
    题目中没有提到，若类似于5这种不是整数的平方，应当给出近似最大的值，例如 5 返回2 因2*2=4
     */
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x;
        while (left <= right) {
            // 不能用      (left + right) / 2       可能会 + 后超出int的表达范围
            int middle = left + (right - left) / 2;
            // 不能用      middle * middle > x      可能会 * 后超出int的表达范围
            if (middle > x / middle) {
                right = middle - 1;
            }
            if (middle < x / middle) {
                // 不能用      middle + 1) * (middle + 1) > x    可能 * 后会超出int的表达范围
                if ((middle + 1) > x / (middle + 1)) return middle;
                left = middle + 1;
            }
            if (middle == x / middle) {
                return middle;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(14));
    }
}
