package com.carlosli.leetcode.binarysearch;

/**
 * Created by yulongli on 2017/2/22.
 */
public class GuessNumberHigherOrLower374 {
    // 知道范围后，尝试猜中系统的key
    public static int guessNumber(int n) {
        for (int i = 1; i < n; i++)
            if (guess(i) == 0)
                return i;
        return n;
    }

    // 折半查找
    public static int guessNumber2(int n) {
        int left = 0;
        int right = n;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (guess(middle) == -1) {
                right = middle - 1;
            } else if (guess(middle) == 1) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return Integer.MAX_VALUE;
    }

    // 三分查找
    public static int guessNumber3(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // guessNumber() 的方法参数是代表 猜数字的范围
        System.out.println(guessNumber(10));
        System.out.println(guessNumber2(10));
    }



    /*---------------提供的api--------------*/

    public static int guess(int guessNum) {
        int myKey = 5;
        if (myKey < guessNum) {
            return -1;
        } else if (myKey > guessNum) {
            return 1;
        } else {
            //myKey == guessNum
            return 0;
        }
    }
}
