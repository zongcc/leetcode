package com.carlosli.leetcode.array;

import java.util.Arrays;

/**
 * Created by yulongli on 2016/10/27.
 */
public class RotateArray189 {
    public static void rotate(int[] nums, int k) {
        int temp = 0;
        while (k-- > 0) {
            temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i+k)%nums.length] = nums[i];
        }

        //转存一下
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }

    /**
     *
     * 当nums的长度 n%k=0 !???????  n、k 有公因数  ？？？？(9,6)时，逐一替换后，
     * 会回到原始位置(停止条件为start=current,见下代码)，但是并不是所有位置的都替换了,
     * 一共需要替换最小公因数轮？？
     *
     * 如
     * 123456 k=3,一圈过后  (4)23(1)56   所以需要经过三轮替换，才能完全换完
     *
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
            System.out.println("@");
        }
    }


    /*
    * 根据热心网友waruzhi的留言，这道题其实还有种类似翻转字符的方法，
    * 思路是先把前n-k个数字翻转一下，再把后k个数字翻转一下，最后再把整个数组翻转一下：

1 2 3 4 5 6 7
4 3 2 1 5 6 7
4 3 2 1 7 6 5
5 6 7 1 2 3 4
    *
    * */
    public static void rotate4(int[] nums, int k) {
//        if (nums.length || (k %= nums.length)) == 0) return;
//        int n = nums.length;
//        reverse(nums.begin(), nums.begin() + n - k);
//        reverse(nums.begin() + n - k, nums.end());
//        reverse(nums.begin(), nums.end());
    }



    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6,7,8,9,10};
        rotate3(nums, 8);
        System.out.println(Arrays.toString(nums));
        System.out.println("fdsfd");
    }
}
