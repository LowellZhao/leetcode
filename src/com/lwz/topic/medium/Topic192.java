package com.lwz.topic.medium;

public class Topic192 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Topic192().hammingWeight(16));

        System.out.println(16 & 15);
        System.out.println(15 & 14);
    }

}
