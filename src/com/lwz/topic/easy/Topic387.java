package com.lwz.topic.easy;

import java.util.HashMap;
import java.util.Map;

public class Topic387 {

    public static int firstUniqChar(String s) {
        if ("".equals(s)) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }

        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) != -1) {
                return i;
            }
        }

//        int min = Integer.MAX_VALUE;
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() != -1) {
//                min = min > entry.getValue() ? entry.getValue() : min;
//            }
//        }
//        if (min != Integer.MAX_VALUE) {
//            return min;
//        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aaaaaaaa"));
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

}
