package com.lwz.topic;

public class Topic13 {

    private static int romanToInt(String s) {
        int[] p = new int[26];
        p['I' - 'A'] = 1;
        p['V' - 'A'] = 5;
        p['X' - 'A'] = 10;
        p['L' - 'A'] = 50;
        p['C' - 'A'] = 100;
        p['D' - 'A'] = 500;
        p['M' - 'A'] = 1000;

        int length = s.length();
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            num[i] = p[c - 'A'];
        }

        int res = num[length - 1];
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                res -= num[i];
            } else {
                res += num[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));

        // 4 104 94 1094 994
    }

}
