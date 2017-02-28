package com.carlosli.leetcode.binarysearch;

/**
 * Created by yulongli on 2017/2/28.
 */
public class FirstBadVersion278 {

    public static int firstBadVersion(int n) {
        int version = 1;
        while (version <= n) {
            if (isBadVersion(version)) {
                return version;
            } else {
                version++;
            }
        }
        return Integer.MIN_VALUE;
    }

    /*
    折半查找
    1.若是错的版本往前找（若当前版本的前一个版本是正确的，则当前版本即为第一个错误的版本），
    2.若是对的版本往后找
     */
    public static int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                if (!isBadVersion(middle - 1)) return middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int firstBadVersion3(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) left = mid + 1;
            else right = mid; // 不能是mid-1,否则会错过,例如错误版本为5 总共版本为6
        }
        // 当left和right重合时，就完成了查找（该方法最后一定会重合, 因right = mid）
        return left;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(20));
        System.out.println(firstBadVersion2(20));
        System.out.println(firstBadVersion3(10));
    }

    /*---------------提供的api--------------*/
    public static boolean isBadVersion(int version) {
        int badVersion = 15;
        if (badVersion <= version) {
            return true;
        } else {
            return false;
        }
    }
}
