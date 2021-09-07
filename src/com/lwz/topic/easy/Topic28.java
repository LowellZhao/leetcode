package com.lwz.topic.easy;

public class Topic28 {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Topic28().strStr("hello", "ll"));
    }

}
