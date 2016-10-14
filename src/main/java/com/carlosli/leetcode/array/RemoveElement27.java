package com.carlosli.leetcode.array;

import java.util.Arrays;

/**
 * Created by li on 2016/10/14.
 */
public class RemoveElement27 {

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * i��j�����������2n��
     * �õ�������� 1��2��3��4 **********��Ҫ���˵��*********
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * i��n�����������n��
     * �õ�������� 1��2��3��4     ȥ��5��һ�ζ�����Ҫ�ƶ�
     * ����������� 5��5��5��5     ȥ��5����Ҫ�ƶ�n��
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        RemoveElement27 removeElement = new RemoveElement27();
        int[] array = new int[]{3, 2, 2, 3};
        System.out.println(removeElement.removeElement(array, 3));
        System.out.println(Arrays.toString(array));

        int[] array2 = new int[]{3, 3,3, 3};
        System.out.println(removeElement.removeElement2(array2, 3));
        System.out.println(Arrays.toString(array2));
    }
}
