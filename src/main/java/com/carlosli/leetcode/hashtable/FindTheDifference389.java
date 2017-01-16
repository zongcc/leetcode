package com.carlosli.leetcode.hashtable;

import java.util.HashMap;

/**
 * Created by yulongli on 2017/1/12.
 */
public class FindTheDifference389 {

    // 统计每个字符的个数进行对比
    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sMap.get(c) == null) {
                sMap.put(c, 1);
            } else {
                sMap.put(c, sMap.get(c) + 1);
            }
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (tMap.get(c) == null) {
                tMap.put(c, 1);
            } else {
                tMap.put(c, tMap.get(c) + 1);
            }
        }

        // 这里必须是tMap，因为t更长
        for (Character character : tMap.keySet()) {
            if (sMap.get(character) != tMap.get(character)) {
                return character;
            }
        }
        return 1;
    }

    /**
     * 用2进制异或的方式进行判断，异或理论可参看
     *
     * @see SingleNumber136 singleNumber3方法注释
     */
    public static char findTheDifference2(String s, String t) {
        char result = 0;
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            result ^= t.charAt(i);
        }
        return result;
    }

    public static char findTheDifference3(String s, String t) {
        // Initialize variables to store sum of ASCII codes for
        // each string
        int charCodeS = 0, charCodeT = 0;
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) charCodeS += (int) s.charAt(i);
        for (int i = 0; i < t.length(); ++i) charCodeT += (int) t.charAt(i);
        // Return the difference between 2 strings as char
        return (char) (charCodeT - charCodeS);
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t1 = "bacde";
        String t2 = "bafcd";
        System.out.println(findTheDifference(s, t1));
        System.out.println(findTheDifference(s, t2));
        System.out.println(findTheDifference2(s, t1));
        System.out.println(findTheDifference2(s, t2));
        System.out.println(findTheDifference3(s, t1));
        System.out.println(findTheDifference3(s, t2));
    }
}
