package com.lwz.topic;

public class Topic1004 {

    public int longestOnes(int[] A, int K) {
        int right = 0;
        int left = 0;
        int zores = 0;
        int res = 0;

        int length = A.length;

        while (right < length) {
            if (A[right] == 0) {
                zores++;
            }
            while (zores > K) {
                if (A[left++] == 0) {
                    zores--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int i = new Topic1004().longestOnes(A, 2);
        System.out.println(i);
    }

}
