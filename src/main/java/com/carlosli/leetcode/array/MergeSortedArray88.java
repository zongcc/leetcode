package com.carlosli.leetcode.array;

import java.util.Arrays;

/**
 * Created by yulongli on 2016/10/24.
 */
public class MergeSortedArray88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int newLength = m + n;
        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = newLength - 1; i >= 0; i--) {
            if (index1 < 0) {
                nums1[i] = nums2[index2];
                index2--;
            } else if (index2 < 0) {
                nums1[i] = nums1[index1];
                index1--;
            } else if (nums1[index1] >= nums2[index2]) {
                nums1[i] = nums1[index1];
                index1--;
            } else {
                nums1[i] = nums2[index2];
                index2--;
            }
        }

    }

    public static void merge2(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        // A没放完，B没放完
        while (i > -1 && j > -1)    A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
        // A放完了，B没放完
        while (j > -1)              A[k--] = B[j--];  // 当A[5,9...]B[1,3]会执行这句;  当B[5,9]A[1,3...]只会执行上一句
        // B放完了，就结束了
    }

    public static void merge3(int A[], int m, int B[], int n) {
        int length = m + n;
        // 若B放完了，就是全部都放完了
        // 故，B没放完的情况下，A没放完，和A放完了
        while (n > 0) A[--length] = (m == 0 || A[m - 1] < B[n - 1]) ? B[--n] : A[--m];
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 1;
        int[] nums1 = new int[m + n + 1];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 4;
        nums1[3] = 5;
        nums1[4] = 6;
        int[] nums2 = new int[n];
        nums2[0] = 3;
//        merge(nums1, m, nums2, n);
        merge2(nums1, m, nums2, n);
//        merge3(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));


    }
}
