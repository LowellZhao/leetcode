package com.lwz.topic.easy;

/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 */
public class Topic1221 {

    public static int balancedStringSplit(String s) {
        if (s == null) {
            return 0;
        }
        int sum = 0;
        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('L' == c) {
                d++;
            } else if ('R' == c) {
                d--;
            }
            if (d == 0) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
        System.out.println(balancedStringSplit(null));
        System.out.println(balancedStringSplit(""));
    }

}
