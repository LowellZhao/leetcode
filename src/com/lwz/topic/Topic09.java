package com.lwz.topic;

public class Topic09 {

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int num = 0;
        while (temp != 0) {
            num = (num * 10) + (temp % 10);
            temp = temp / 10;
        }
        return x == num;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(11));
        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(-101));
        System.out.println(isPalindrome(0));
    }
}
