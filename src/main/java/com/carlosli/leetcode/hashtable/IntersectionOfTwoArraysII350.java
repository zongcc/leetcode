package com.carlosli.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yulongli on 2017/1/10.
 */
public class IntersectionOfTwoArraysII350 {


    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            int compare = Integer.compare(nums1[i], nums2[j]);
            if (compare < 0) {
                i++;
            } else if (compare > 0) {
                j++;
            } else if (compare == 0) {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int k = 0;
        int[] result = new int[list.size()];
        for (Integer integer : list) {
            result[k++] = integer;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 3, 4, 5};
        int[] nums2 = new int[]{1, 2, 2, 3, 7, 8, 0};
        int[] intersect = intersect(nums1, nums2);

        System.out.println(Arrays.toString(intersect));

    }
}
