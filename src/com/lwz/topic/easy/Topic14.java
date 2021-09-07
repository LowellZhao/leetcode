package com.lwz.topic.easy;

public class Topic14 {

    private static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();

        int length = Integer.MAX_VALUE;
        for (String s : strs) {
            length = Math.min(length, s.length());
        }

        if (length == Integer.MAX_VALUE) {
            return "";
        }

        boolean flag = true;
        char c1;
        for (int i = 0; i < length; i++) {
            c1 = strs[0].charAt(i);
            for (int i1 = 1; i1 < strs.length; i1++) {
                if (c1 != strs[i1].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            stringBuilder.append(c1);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs2 = new String[]{"dog", "racecar", "car"};
        String[] strs3 = new String[]{"dog"};
        String[] strs4 = new String[]{};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
        System.out.println(longestCommonPrefix(strs4));
    }

}
