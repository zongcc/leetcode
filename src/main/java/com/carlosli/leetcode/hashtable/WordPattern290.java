package com.carlosli.leetcode.hashtable;

import java.util.HashMap;

/**
 * Created by yulongli on 2017/1/11.
 */
public class WordPattern290 {

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;

        HashMap index = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static boolean wordPattern2(String pattern, String str) {
        String[] arr = str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        if (arr.length != pattern.length()) return false;
        for (int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i]))
                    return false;
            } else {
                if (map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str1 = "cat dog dog cat";
        String str2 = "cat dog dog dog";
        System.out.println(wordPattern2(pattern, str1));
        System.out.println(wordPattern2(pattern, str2));
    }
}
