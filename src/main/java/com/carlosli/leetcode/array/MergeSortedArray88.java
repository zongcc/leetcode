package com.carlosli.leetcode.array;

import java.util.Arrays;

/**
 * Created by yulongli on 2016/10/24.
 */
public class MergeSortedArray88 {
    public static void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) return;

        int newLength = m + n;
        int indexA = m - 1;
        int indexB = n - 1;
        for (int i = newLength - 1; i >= 0; i--) {
            // A已经传完了
            if (indexA < 0) {
                A[i] = B[indexB];
                indexB--;
                // B已经传完了
            } else if (indexB < 0) {
                A[i] = A[indexA];
                indexA--;
                // A、B都没有传完 A大
            } else if (A[indexA] >= B[indexB]) {
                A[i] = A[indexA];
                indexA--;
                // A、B都没有传完 B大
            } else {
                A[i] = B[indexB];
                indexB--;
            }
        }
    }

    public static void merge2(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        // A、B都没传完
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        // B传完了，A没传完（其实这一步不需要，B传完了就可以结束了）
        while (i >= 0) {
            A[index--] = A[i--];
        }
        // A传完了，B没传完
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }

    public static void merge3(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        // A没放完，B没放完
        while (i > -1 && j > -1) A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
        // A放完了，B没放完
        while (j > -1) A[k--] = B[j--];  // 当A[5,9...]B[1,3]会执行这句;  当B[5,9]A[1,3...]只会执行上一句
        // B放完了，就结束了
    }

    public static void merge4(int A[], int m, int B[], int n) {
        int length = m + n;
        // 若B放完了，就是全部都放完了
        // 故，B没放完的情况下，A没放完，和A放完了
        while (n > 0) A[--length] = (m == 0 || A[m - 1] < B[n - 1]) ? B[--n] : A[--m];
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 1;
        int[] A = new int[m + n + 1];
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;
        A[3] = 5;
        A[4] = 6;
        int[] B = new int[n];
        B[0] = 3;
//        merge(nums1, m, nums2, n);
        merge2(A, m, B, n);
//        merge3(nums1, m, nums2, n);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));


    }
}
