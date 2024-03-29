package com.lwz.topic.medium;

import java.util.HashSet;
import java.util.Set;

public class Topic03 {

    private static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    private static int lengthOfLongestSubstring2(String s) {
        int n = s.length();

        int res = 0;
        int rp = -1; // 窗口开始位置
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rp + 1 < n && !set.contains(s.charAt(rp + 1))) {
                set.add(s.charAt(rp + 1));
                rp++;
            }
            res = Math.max(res, rp - i + 1);
        }

        return res;
    }

    public static int lengthOfLongestSubstring3(String s) {
        if ("".equals(s)) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int temp = -1;
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (temp + 1 < len && !set.contains(s.charAt(temp + 1))) {
                set.add(s.charAt(temp + 1));
                ++temp;
            }
            max = max > set.size() ? max : set.size();
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "abcaaaabcbb";
//        int i = lengthOfLongestSubstring(str);
        int i = lengthOfLongestSubstring2(str);
        System.out.println(i);
    }

}
