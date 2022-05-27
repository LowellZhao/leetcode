package com.lwz.topic.easy;

/**
 * @author
 * @date 2022/3/15
 */
public class Topic680 {

    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;

        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return some(low + 1, high, s) || some(low, high - 1, s);
            }
        }
        return true;
    }

    public boolean some(int low, int high, String s) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Topic680().validPalindrome("aba"));
        System.out.println(new Topic680().validPalindrome("231321"));
        System.out.println(new Topic680().validPalindrome("1"));
        System.out.println(new Topic680().validPalindrome("11"));
        System.out.println(new Topic680().validPalindrome("12"));
        System.out.println(new Topic680().validPalindrome("abca"));
        System.out.println(new Topic680().validPalindrome("abcaa"));
    }

}
