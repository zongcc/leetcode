package com.carlosli.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by li on 2017/1/15.
 */
public class LongestPalindrome309 {

    /*
    abccccdd -> dccaccd
    ccdd -> dccd
    单个的只能有最多一个，其他的都是成对的(2的倍数)
     */
    public static int longestPalindrome(String s) {
        // 先统计每个字符的数量
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int number = 0;
        // 取双数的进行统计
        for (Character character : map.keySet()) {
            if (map.get(character) % 2 == 0) {
                number += map.get(character);
            }
        }
        // 取单数的进行统计（为了方便观察就不同上面合并了）
        boolean haveOddNumber = false;
        for (Character character : map.keySet()) {
            if (map.get(character) % 2 != 0) {
                haveOddNumber = true;
                int i = map.get(character) / 2;
                number = number + 2 * i;
            }
        }
        if (haveOddNumber) number++;
        return number;
    }

    /*
    每次判断出有一对了后，清除set，数量+2，最后判断是否有单个的
     */
    public static int longestPalindrome2(String s) {
        HashSet<Character> set = new HashSet<>();
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
                number += 2;
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) number++;
        return number;
    }

    public static int longestPalindrome3(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp >= 97) lowercase[temp - 'a']++;
            else uppercase[temp - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            res += (lowercase[i] / 2) * 2;
            res += (uppercase[i] / 2) * 2;
        }
        return res == s.length() ? res : res + 1;

    }

    public static void main(String[] args) {

        String string1 = "abccccdd";
        String string2 = "abcccdd";
        String string3 = "ccdd";
        System.out.println(longestPalindrome(string1));
        System.out.println(longestPalindrome(string2));
        System.out.println(longestPalindrome(string3));
        System.out.println(longestPalindrome2(string1));
        System.out.println(longestPalindrome2(string2));
        System.out.println(longestPalindrome2(string3));
        System.out.println(longestPalindrome3(string1));
        System.out.println(longestPalindrome3(string2));
        System.out.println(longestPalindrome3(string3));
    }
}
